package br.curso.jsp.inteface.login;

import java.sql.SQLException;

import br.curso.jsp.model.Usuario;

public interface IDAOAutenticarUsuario {

	
	boolean logarUsuarioLogin(Usuario usuarioLogin) throws SQLException;
	
}
