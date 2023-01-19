package br.curso.jsp.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.curso.jsp.constante.paginas.PaginasRedirect;
import br.curso.jsp.dao.user.DAOUser;
import br.curso.jsp.login.DAOAutenticarUsuario;
import br.curso.jsp.model.Usuario;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class ControleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOAutenticarUsuario autenticarsuario = new DAOAutenticarUsuario();
	private DAOUser daoUser = new DAOUser();
	

	public ServletConfig getServletConfig() {
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		if (action.equals("/logout")) {
			request.getSession().removeAttribute("usuario");
			request.getRequestDispatcher(PaginasRedirect.INDEX).forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		try {
			String login = request.getParameter("login").trim();
			String senha = request.getParameter("senha").trim();
			String msg = "";
			boolean isUserValido = false;
			if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(login);
				usuario.setSenha(senha);


					isUserValido = autenticarsuario.logarUsuarioLogin(usuario);
					if (isUserValido) {
						// Usuario Acessa O sistema
						Usuario dadosUsuario = daoUser.buscarUsuario(login);
						request.getSession().setAttribute("usuario", usuario.getLogin());
						request.getSession().setAttribute("dados", dadosUsuario);

						request.getRequestDispatcher(PaginasRedirect.PAGINA_HOME).forward(request, response);

					} else {
						msg = "usuario invalido";
						request.setAttribute("msg", msg);
						request.getRequestDispatcher(PaginasRedirect.INDEX).forward(request, response);
					}
				

			} else {

				request.setAttribute("msg", "Campos Obrigatorio");
				request.getRequestDispatcher(PaginasRedirect.INDEX).forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + " erro na conexao");
		}

	}

}
