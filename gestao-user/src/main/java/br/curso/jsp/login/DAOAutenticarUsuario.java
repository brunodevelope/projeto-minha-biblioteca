package br.curso.jsp.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.StyledEditorKit.BoldAction;

import br.curso.jsp.conect.banco.user.DaoConectBanco;
import br.curso.jsp.inteface.login.IDAOAutenticarUsuario;
import br.curso.jsp.model.Usuario;

public class DAOAutenticarUsuario implements IDAOAutenticarUsuario {
	private Connection connecxaoComBanco;

	public DAOAutenticarUsuario() {
		connecxaoComBanco = DaoConectBanco.getConnection();
	}

	@Override
	public boolean logarUsuarioLogin(Usuario usuario) throws SQLException {

		String sqlValidator = "select  *  from tabela_usuario  where login=? and senha =?";

		PreparedStatement preparedStatement = connecxaoComBanco.prepareStatement(sqlValidator);
		preparedStatement.setString(1, usuario.getLogin());
		preparedStatement.setString(2, usuario.getSenha());

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}

		return false;

	}

}
