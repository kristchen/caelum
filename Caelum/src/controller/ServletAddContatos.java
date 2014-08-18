package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContatoDAO;
import beans.Contato;

public class ServletAddContatos extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Contato contato = new Contato();

		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataNascimento = request.getParameter("dataNascimento");

		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);

		new ContatoDAO().salvar(contato);
		
		RequestDispatcher rd =  request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
		
		
		
//		out.println("<html>");
//		out.println("<body>");
//		out.println("Contato " + contato.getNome() + " adicionado com sucesso");
//		out.println("</body>");
//		out.println("</html>");
	}

}
