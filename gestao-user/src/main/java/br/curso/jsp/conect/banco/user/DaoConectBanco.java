package br.curso.jsp.conect.banco.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

public class DaoConectBanco {
	private static Connection connection = null;
	private static String url = "jdbc:postgresql://localhost:5432/usuario";
	private static String senha = "1991";
	private static String usuario = "postgres";
	
	
	

	private  static  Connection criaConexao() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
			if (connection == null) {
				connection = DriverManager.getConnection(url, usuario, senha);
				connection.setAutoCommit(false);
				System.out.println("Conexao Efetuada Com Sucesso");
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("erro ao abrir conexao" + e.getMessage() + " O DRIVER DE CONEXAO NAO FOI ENCONTRADO");
		}

		return connection;
	}
	
	
	@SuppressWarnings("finally")
	public static Connection getConnection()   {
		  try {
		  connection = criaConexao();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		return connection;
		 
	
	}
	
	

}