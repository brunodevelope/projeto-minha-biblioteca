package br.curso.jsp.util;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.curso.jsp.dao.user.repository.DaoUsuarioRepository;
import br.curso.jsp.model.Usuario;

public class GenericUtil {

	private DaoUsuarioRepository daoUser = new DaoUsuarioRepository();
	
	public long getUserSession(HttpServletRequest httpServletRequest) throws SQLException {
		Usuario nomeUser =(Usuario)httpServletRequest.getSession().getAttribute("dados");
		return this.daoUser.getIDAdmin(nomeUser.getNome());
	}
	
}
