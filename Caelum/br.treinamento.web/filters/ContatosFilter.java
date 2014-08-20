package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import model.Conexao;

//@WebFilter("/*")
public class ContatosFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		tempoExecucao(request, response, chain);

		abrirConexao(request, response, chain);

		
		
	}

	private void abrirConexao(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		Connection connection = new Conexao().getConnection();
		
		request.setAttribute("connection", connection);
		
		chain.doFilter(request, response);
		
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void tempoExecucao(ServletRequest request,
			ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		long tempoInicial = System.currentTimeMillis();

		chain.doFilter(request, response);

		long tempoFinal = System.currentTimeMillis();

		String uri = ((HttpServletRequest) request).getRequestURI();

		String param = ((HttpServletRequest) request).getParameter("logica");

		System.out.println("Tempo da requisição de " + uri + "?logica=" + param
				+ " demorou (ms) : " + (tempoFinal - tempoInicial));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
