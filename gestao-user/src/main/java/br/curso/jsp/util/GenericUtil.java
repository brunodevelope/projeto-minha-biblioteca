package br.curso.jsp.util;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.curso.jsp.dao.user.DAOUser;
import br.curso.jsp.model.user.Usuario;

public class GenericUtil {

	private DAOUser daoUser = new DAOUser();
	
	public long getUserSession(HttpServletRequest httpServletRequest) throws SQLException {
		Usuario nomeUser =(Usuario)httpServletRequest.getSession().getAttribute("dados");
		
		return this.daoUser.getIDAdmin(nomeUser.getNome());
	}
	
}
