package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conexao;
import model.ContatoDAO;
import beans.Contato;
import beans.Logica;

//@WebServlet("/addContato")
public class AddContatos implements Logica {

	@Override
	public String executa(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
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

		Connection connection = new Conexao().getConnection();

		new ContatoDAO(connection).salvarContato(contato);

		connection.close();
		
		return "contatos-servlet?logica=ListarContatos";
	}

}
