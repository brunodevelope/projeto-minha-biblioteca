package br.curso.jsp.controle;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.ImageOutputStreamImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import br.curso.jsp.constante.paginas.PaginasRedirect;
import br.curso.jsp.dao.user.DAOUser;
import br.curso.jsp.model.Usuario;
import br.curso.jsp.util.GenericUtil;

@MultipartConfig
@WebServlet(urlPatterns = { "/salvar", "/pesquisar", "/deletarusuario", "/voltarinicio", "/editarmeusdados",
		"/detalhes" })
public class ControleUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAOUser daoUser = new DAOUser();

	public ControleUsuario() {
		super();

		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String mensagem = null;
			int seDeletou = 0;
			String action = request.getServletPath();
			if (action.equals("/deletarusuario")) {
				String idUser = request.getParameter("idUser");
				seDeletou = daoUser.deletar(idUser, new GenericUtil().getUserSession(request));

				if (seDeletou > 0) {
					mensagem = "UUARIO DO ID  :" + idUser + " FOI DELETADO COM SUCESSO ";

				} else {
					mensagem = "OPS : ALGO DE ERRADO  OCORREU ESSE USUARIO JA FOI DELETADO ";
				}
				response.getWriter().write(mensagem);

			} else if (action.equals("/editarmeusdados") && !request.getParameter("loginUser").isEmpty()) {
				Usuario user = null;
				String login = request.getParameter("loginUser");
				user = daoUser.buscarUsuario(login);
				request.setAttribute("user", user);
				request.getRequestDispatcher(PaginasRedirect.PAGINA_CADASTRO_USUARIO).forward(request, response);

			} else if (action.equals("/pesquisar")) {
				String nomePesquisa = request.getParameter("nomeUser");
				List<Usuario> listUsuario = daoUser.pesquisarUsuariosPorNome(nomePesquisa,
						new GenericUtil().getUserSession(request));
				Gson gson = new Gson();
				String dadosJson = gson.toJson(listUsuario);
				response.getWriter().write(dadosJson);

			} else if (action.equals("/detalhes")) {
				Usuario user = null;
				long id = Long.parseLong(request.getParameter("idUsuario"));
				user = daoUser.buscarUsuario(id);
				request.setAttribute("user", user);
				request.getRequestDispatcher(PaginasRedirect.PAGINA_CADASTRO_USUARIO).forward(request, response);
			} else {
				request.getRequestDispatcher("paginas/home.jsp").forward(request, response);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			request.setAttribute("msg", " Algo de errado ocorreu com essa Operacao");
			request.getRequestDispatcher(PaginasRedirect.PAGINA_CADASTRO_USUARIO).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String nome = request.getParameter("nome").trim();
			String email = request.getParameter("email").trim();
			String data = request.getParameter("data-nascimento").trim();
			String login = request.getParameter("login").trim();
			String senha = request.getParameter("senha").trim();
			String id = request.getParameter("id");
			Part foto = request.getPart("foto");
			Usuario usuario = new Usuario();

			if (nome != null && !nome.isEmpty() && email != null && !email.isEmpty() && data != null && !data.isEmpty()
					&& login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {

				String msg = "";
				usuario.setNome(nome);
				usuario.setEmail(email);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				usuario.setDataNascimento(new Date(new SimpleDateFormat("yyyy-mm-dd").parse(data).getTime()));

				usuario.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);

				if (foto.getSize() > 0) {
					InputStream input = foto.getInputStream();
					BufferedInputStream bufferedInputStream = new BufferedInputStream(input);
					byte[] fotoBytes = bufferedInputStream.readAllBytes();
					String fotoBase64 = "data:" + foto.getContentType() + ";base64,"
							+ new Base64().encodeAsString(fotoBytes);
					usuario.setFoto(fotoBase64);

				}

				if (daoUser.existeUsuario(usuario)  && usuario.novoUsuario()) {
					msg = "Usuario Ja Existe ..";
				} else {
					if (usuario.novoUsuario()) {
						msg = "Usuario Salvo Com Sucesso";
					} else {
						msg = "Usuario Atualizado  Com Sucesso";

					}
					usuario = daoUser.salvar(usuario, new GenericUtil().getUserSession(request));

				}
				request.setAttribute("user", usuario);
				request.setAttribute("msg", msg);
				request.getRequestDispatcher(PaginasRedirect.PAGINA_CADASTRO_USUARIO).forward(request, response);

			} else {

				request.setAttribute("msg", "Campos Obrigatorio");
				request.getRequestDispatcher(PaginasRedirect.PAGINA_CADASTRO_USUARIO).forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", " Algo de errado ocorreu com essa Operacao");
			request.getRequestDispatcher(PaginasRedirect.PAGINA_CADASTRO_USUARIO).forward(request, response);

		} catch (ParseException e) {
			e.printStackTrace();
			request.setAttribute("msg", " data invalida ");
			request.getRequestDispatcher(PaginasRedirect.PAGINA_CADASTRO_USUARIO).forward(request, response);
		}

	}

}
