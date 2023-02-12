package br.curso.jsp.inteface.repository;

import java.sql.SQLException;

import br.curso.jsp.model.Usuario;

public interface IDAOAutenticarUsuario {

	
	boolean logarUsuarioLogin(Usuario usuarioLogin) throws SQLException;
	
}
