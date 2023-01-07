package br.curso.jsp.inteface.login;

import java.sql.SQLException;

import br.curso.jsp.model.user.Usuario;

public interface IDAOAutenticarUsuario {

	
	boolean logarUsuarioLogin(Usuario usuarioLogin) throws SQLException;
	
}
