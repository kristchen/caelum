package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		System.out.println("chamou");
		
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataNascimento = request.getParameter("dataNascimento");

		System.out.println(nome);
		
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);

		new ContatoDAO().salvarContato(contato);
	
		return "listarContatos.jsp";
	}

}
