package controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conexao;
import model.ContatoDAO;
import beans.Contato;
import beans.Logica;

public class RemoveContatos implements Logica {

	@Override
	public String executa(HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = new Contato();

		contato.setId(id);

		Connection connection = new Conexao().getConnection();

		ContatoDAO dao = new ContatoDAO(connection);

		dao.excluirContato(contato);

		return "contatos-servlet?logica=ListarContatos";
	}

}
