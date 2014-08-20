package controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conexao;
import model.ContatoDAO;
import beans.Contato;
import beans.Logica;

public class ListarContatos  implements Logica{

	@Override
	public String executa(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		
		Connection connection = new Conexao().getConnection();
		
		ArrayList<Contato> contatos = new ContatoDAO(connection).getLista();
		
		connection.close();
	
		
		request.setAttribute("contatos", contatos);
		
		return "listarContatos.jsp";
	}

	
	
}
