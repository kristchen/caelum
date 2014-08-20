package controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conexao;
import model.ContatoDAO;
import beans.Contato;
import beans.Logica;

public class AlterarContatos implements Logica {

	@Override
	public String executa(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		System.out.println(id);
		if (request.getParameter("pass").equals("listar")) {
			System.out.println(id);

			Contato contato = new Contato();
			contato.setId(id);

			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String email = request.getParameter("email");
			String dataNascimento = request.getParameter("dataNascimento");

			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(dataNascimento);
			System.out.println(request.getParameter("id"));
			System.out.println(nome);

			Connection connection = new Conexao().getConnection();

			new ContatoDAO(connection).alterarContato(contato);

			connection.close();

			return "contatos-servlet?logica=ListarContatos";
		}

		request.setAttribute("id", id);

		return "alterar-contato.jsp";
	}

}
