package br.curso.jsp.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.curso.jsp.constante.paginas.PaginasRedirect;

/**
 * Servlet implementation class RequestPaginad
 */
@WebServlet(urlPatterns = {"/novousuario" ,   "/novolivro"})
public class ControlePaginas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

   
    public ControlePaginas() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		if(action.equals("/novousuario")) {
			request.getRequestDispatcher(PaginasRedirect.PAGINA_CADASTRO_USUARIO).forward(request, response);
			
		}else if(action.equals("/novolivro")) {
			request.getRequestDispatcher(PaginasRedirect.PAGINA_CADASTRO_LIVROS).forward(request, response);

		}else {
			request.getRequestDispatcher(PaginasRedirect.PAGINA_HOME).forward(request, response);

		}
		
		
		
		
		
	}

	
}
