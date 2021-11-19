package br.com.CheckBike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.CheckBike.domain.Oficina;
import br.com.CheckBike.factory.ConexaoFactory;

public class OficinaDAO {
	public void salvar(Oficina of) throws SQLException {
		StringBuilder sql = new StringBuilder(); // ParteSQL
		sql.append("INSERT INTO oficina ");
		sql.append("(nome, estado, cidade, rua, email, numero, bairro, cnpj, senha, contato) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = ConexaoFactory.conectar(); // CAPTUROU A CONEXÃO

			PreparedStatement comando = conexao.prepareStatement(sql.toString()); // CRIOU UM COMANDO APARTIR DA SQL QUE
																					// ERA
																					// UM TEXTO

			comando.setString(1, of.getNome()); // SUBSTITUIU AS INTERROGAÇÕES COM OS NUMEROS
			comando.setString(2, of.getEstado());
			comando.setString(3, of.getCidade());
			comando.setString(4, of.getRua());
			comando.setString(5, of.getEmail());
			comando.setString(6, of.getNumero());
			comando.setString(7, of.getBairro());
			comando.setString(8, of.getCnpj());
			comando.setString(9, of.getSenha());
			comando.setString(10, of.getContato());
			comando.executeUpdate(); // MANDOU RODAR O COMANDO
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(Oficina of) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM oficina ");
		sql.append("WHERE id_oficina = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, of.getIdOficina());

		comando.executeUpdate();
	}

	public void editar(Oficina of) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE oficina ");
		sql.append("SET nome = ?, email = ?, cidade = ?, contato = ? ");
		sql.append("WHERE id_oficina = ? "); // USA O WHERE PQ SE N VAI ALTERAR TODOS OS NOMES, DESSE JEITO ALTERA DE
												// ACORDO COM O ID

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, of.getNome());
		comando.setString(2, of.getEmail());
		comando.setString(3, of.getCidade());
		comando.setString(4, of.getContato());
		comando.setLong(5, of.getIdOficina());

		comando.executeUpdate();

	}

	public Oficina buscarPorCodigo(Oficina of) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_oficina, cnpj, nome, cidade, email, contato ");
		sql.append("FROM oficina ");
		sql.append("WHERE id_oficina = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, of.getIdOficina());

		// RESULTSET É UMA VARIAVEL QUE GUARDA RESULTADO DE CONSULTA
		ResultSet resultado = comando.executeQuery(); // NO SELECT O COMANDO EXECUTAR É O QUERY, PQ ALÉM DE CONSULTAR É
														// NECESSÁRIO QUE
														// ELE RETORNE ALGO, DIFERENTE DOS OUTROS, QUE NÃO PRECISAVA
														// RETORNAR NADA

		Oficina retorno = null; // A VARIAVEL RETORNO DO TIPO CLIENTE. VAI SER O CLIENTE QUE SERÁ RETORNADO,
		// COMEÇA COM NULL PQ SE N ACHAR NENHUM CLIENTE O RETORNO É O PROPRIO NULL, E SE
		// ACHAR, IRÁ SER INSTANCIADO COM O NEW, E DPS USAR O SETTERS PRA PREENCHELO

		// PARA SABER SE RETORNA ALGO
		if (resultado.next()) {
			retorno = new Oficina();
			retorno.setIdOficina(resultado.getLong("id_oficina")); // PERGUNTA SE TEM PROXIMO, SE DEU CERTO QUER DIZER
																	// QUE TEM PROXIMO, SE NÃO
			retorno.setNome(resultado.getString("nome")); // ,QUER DIZER QUE NÃO TEM NADA E CONTINUA VALENDO NULL

			retorno.setCnpj(resultado.getString("cnpj")); // ,QUER DIZER QUE NÃO TEM NADA E CONTINUA VALENDO NULL
			retorno.setEmail(resultado.getString("email"));
			retorno.setContato(resultado.getString("Contato"));

		}

		return retorno;

	}

	public ArrayList<Oficina> listarOficina() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_oficina, cnpj, nome, cidade, email, contato ");
		sql.append("FROM oficina ");
		

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Oficina> listaOficina = new ArrayList<Oficina>();

		while (resultado.next()) {
			Oficina of = new Oficina();
			of.setIdOficina(resultado.getLong("id_Oficina"));
			of.setCnpj(resultado.getString("cnpj"));
			of.setNome(resultado.getString("nome"));
			of.setCidade(resultado.getString("cidade"));
			of.setEmail(resultado.getString("email"));
			of.setContato(resultado.getString("contato"));

			listaOficina.add(of);

		}

		return listaOficina;

	}

	public ArrayList<Oficina> buscarPorCidade(Oficina of) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_oficina, cnpj, nome, cidade, email, contato ");
		sql.append("FROM oficina ");
		sql.append("WHERE cidade LIKE ? ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + of.getCidade() + "%");
		

		ResultSet resultado = comando.executeQuery();

		ArrayList<Oficina> lista = new ArrayList<Oficina>();

		while (resultado.next()) {
			Oficina oficina = new Oficina();
			oficina.setIdOficina(resultado.getLong("id_Oficina"));
			oficina.setCnpj(resultado.getString("cnpj"));
			oficina.setNome(resultado.getString("nome"));
			oficina.setCidade(resultado.getString("cidade"));
			oficina.setEmail(resultado.getString("email"));
			oficina.setContato(resultado.getString("contato"));

			lista.add(oficina);

		}

		return null;

	}

	public static void main(String[] args) {
		// TESTANDO LISTA
//
//		OficinaDAO ofLista = new OficinaDAO();
//		try {
//			ArrayList<Oficina> listaOficina = ofLista.listarOficina();
//
//			for (Oficina of : listaOficina) {
//				System.out.println("Resultado: " + of);
//			}
//		} catch (SQLException e) {
//			System.out.println("Ocorreu um erro ao tentar listar as oficinas!");
//			e.printStackTrace();
//		}

		// TESTANDO LISTA POR CIDADE

		Oficina of1 = new Oficina();
		of1.setCidade("a");

		OficinaDAO oficinaDao = new OficinaDAO();

		try {
			ArrayList<Oficina> lista = oficinaDao.buscarPorCidade(of1);

			for(Oficina of : lista) {
				System.out.println("Resultado: " + of);
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar listar as oficinas!");
			e.printStackTrace();
		}
	}
}
