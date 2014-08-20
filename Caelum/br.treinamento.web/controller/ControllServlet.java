package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

import beans.Logica;

//@WebServlet("/contatos-servlet")
public class ControllServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		service(req, resp);

	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String param = request.getParameter("logica");

		String nomeClasse = "controller." + param;

		try {
			Class classe = Class.forName(nomeClasse);

			Logica logica = (Logica) classe.newInstance();

			String pagina = logica.executa(response, request);

			request.getRequestDispatcher(pagina).forward(request, response);

		

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
