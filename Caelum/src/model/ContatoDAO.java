package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import beans.Contato;

public class ContatoDAO {

	private ArrayList<Contato> lista;

	public void alterarContato(Contato contato) {
		Connection conn = new Conexao().getConnection();
		 String sql = "update estudos.contatos set nome ='" +
		 contato.getNome()
		 + "' ,  endereco ='" + contato.getEndereco()
		 + "' ,   email ='" + contato.getEmail()
		 + "' ,   dt_nascimento ='" + contato.getDataNascimento()
		 + "' where idcontatos ='"+contato.getId()+"'" ;

	//	String sql = "update estudos.contatos set nome = ? ,  endereco = ? ,   email = ? ,   dt_nascimento = ?, where idcontatos = ? ";
		
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

//			statement.setString(1, contato.getNome());
//			statement.setString(2, contato.getEndereco());
//			statement.setString(3, contato.getEmail());
//			statement.setString(4, contato.getDataNascimento());
//			statement.setLong(5, contato.getId());
//
//		System.out.println(sql);
			
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void salvarContato(Contato contato) {
		Connection conn = new Conexao().getConnection();
		String sql = "insert into estudos.contatos(nome,endereco,email,dt_nascimento) values(?,?,?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3, contato.getEndereco());
			statement.setString(4, contato.getDataNascimento());

			statement.execute();

			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void excluirContato(Contato contato) {

		Connection conn = new Conexao().getConnection();
		String sql = "delete from estudos.contatos where idcontatos = '"
				+ contato.getId() + "'";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.execute();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Contato> listarContatos() {

		ArrayList<Contato> lista = new ArrayList<Contato>();

		Connection conn = new Conexao().getConnection();

		String sql = "select * from estudos.contatos";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Contato contato = new Contato();
				contato.setNome(result.getString("nome"));
				contato.setEmail(result.getString("email"));
				contato.setEndereco(result.getString("endereco"));
				contato.setDataNascimento(result.getString("dt_nascimento"));
				contato.setId(result.getLong("idcontatos"));
				lista.add(contato);
			}

			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}

	public ArrayList<Contato> getLista() {
		return listarContatos();
	}

}
