package br.curso.jsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.postgresql.translation.messages_bg;

@WebFilter(urlPatterns = { "/paginas/*" })
public class FilterLogin implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String menssagem;
		String usuarioDaSessao = (String) req.getSession().getAttribute("usuario");
		String url = req.getServletPath();

		if (usuarioDaSessao == null || (usuarioDaSessao.isEmpty() && !url.contains("/login"))) {
			menssagem = "Voce Nao Tem Permissaó";
			req.setAttribute("msg", menssagem);
			RequestDispatcher redirect = req.getRequestDispatcher("/index.jsp");
            redirect.forward(req, response);
		}else {
			// continua o fluxo
			chain.doFilter(req, response);
		}

	}

}
