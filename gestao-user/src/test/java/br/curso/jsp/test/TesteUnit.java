package br.curso.jsp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.curso.jsp.dao.user.repository.DaoUsuarioRepository;
import br.curso.jsp.login.DAOAutenticarUsuario;
import br.curso.jsp.model.Usuario;

class TesteUnit {
	private DaoUsuarioRepository daoUser = new DaoUsuarioRepository();

	@Test
	void test() {
		Usuario user = new Usuario();
		user.setLogin("258");
		user.setSenha("123");
		user.setEmail("erickjava1991@outlook.com");

		try {
			Boolean existe = daoUser.existeUsuario(user);
			System.out.println(existe);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Test
	void buscarUsuarios() {
		try {
			List<Usuario> result = daoUser.pesquisarUsuariosPorNome("e", 1000);
			for (Usuario u : result) {
				System.out.println(u.getNome());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testeDelete() throws SQLException {
       int d = daoUser.deletar("1006", 1005);
       System.out.println(d);
	}

}
