package br.com.CheckBike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.CheckBike.domain.BicicletaNova;
import br.com.CheckBike.domain.ClienteNovo;
import br.com.CheckBike.domain.Oficina;
import br.com.CheckBike.factory.ConexaoFactory;

public class BicicletaDAO {
	public void salvarBicicleta(BicicletaNova b) throws SQLException {

		StringBuilder sql = new StringBuilder(); // ParteSQL
		sql.append("INSERT INTO bicicleta ");
		sql.append("(descricao, modelo) ");

		sql.append("VALUES (?, ?) ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = ConexaoFactory.conectar(); // CAPTUROU A CONEXÃO

			PreparedStatement comando = conexao.prepareStatement(sql.toString()); // CRIOU UM COMANDO APARTIR DA SQL QUE
			// ERA
			// UM TEXTO

			comando.setString(1, b.getDescricao());
			comando.setString(2, b.getModelo());
			// comando.setLong(3, b.getClienteNovo().getIdCliente());
			// comando.setLong(3, b.getId_bicicleta());
			comando.executeUpdate(); // MANDOU RODAR O COMANDO
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<BicicletaNova> listarBicicleta() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_bicicleta, descricao, modelo ");
		sql.append("FROM bicicleta ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<BicicletaNova> listaBicicleta = new ArrayList<BicicletaNova>();

		while (resultado.next()) {
			BicicletaNova b = new BicicletaNova();
			b.setId_bicicleta(resultado.getLong("id_Bicicleta"));
			b.setDescricao(resultado.getString("descricao"));
			b.setModelo(resultado.getString("modelo"));

			listaBicicleta.add(b);

		}

		return listaBicicleta;

	}

	public void excluir(BicicletaNova b) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM bicicleta ");
		sql.append("WHERE id_bicicleta = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, b.getId_bicicleta());

		comando.executeUpdate();

	}

	public void editar(BicicletaNova b) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE bicicleta ");
		sql.append("SET descricao = ?, modelo = ? ");
		sql.append("WHERE id_bicicleta = ? "); // USA O WHERE PQ SE N VAI ALTERAR TODOS OS NOMES, DESSE JEITO ALTERA DE
												// ACORDO COM O ID

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, b.getDescricao());
		comando.setString(2, b.getModelo());
		// comando.setLong(3, b.getClienteNovo().getIdCliente());
		comando.setLong(3, b.getId_bicicleta());

		comando.executeUpdate();

	}

	public BicicletaNova buscarPorCodigo(BicicletaNova b) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_bicicleta, descricao, modelo, id_cliente ");
		sql.append("FROM bicicleta ");
		sql.append("WHERE id_bicicleta = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, b.getId_bicicleta());

		// RESULTSET É UMA VARIAVEL QUE GUARDA RESULTADO DE CONSULTA
		ResultSet resultado = comando.executeQuery(); // NO SELECT O COMANDO EXECUTAR É O QUERY, PQ ALÉM DE CONSULTAR É
														// NECESSÁRIO QUE
														// ELE RETORNE ALGO, DIFERENTE DOS OUTROS, QUE NÃO PRECISAVA
														// RETORNAR NADA

		BicicletaNova retorno = null; // A VARIAVEL RETORNO DO TIPO CLIENTE. VAI SER O CLIENTE QUE SERÁ RETORNADO,
		// COMEÇA COM NULL PQ SE N ACHAR NENHUM CLIENTE O RETORNO É O PROPRIO NULL, E SE
		// ACHAR, IRÁ SER INSTANCIADO COM O NEW, E DPS USAR O SETTERS PRA PREENCHELO

		// PARA SABER SE RETORNA ALGO
		if (resultado.next()) {
			retorno = new BicicletaNova();
			retorno.setId_bicicleta(resultado.getLong("id_bicicleta")); // PERGUNTA SE TEM PROXIMO, SE DEU CERTO QUER
																		// DIZER
			// QUE TEM PROXIMO, SE NÃO
			retorno.setDescricao(resultado.getString("descricao")); // ,QUER DIZER QUE NÃO TEM NADA E CONTINUA VALENDO
																	// NULL
			retorno.setModelo(resultado.getString("modelo"));

		}

		return retorno;

	}
//	

	public static void main(String[] args) {
//		// TESTANDO METODO SALVAR
//		
//				BicicletaNova b1 = new BicicletaNova();
//				b1.setDescricao("bicicleta rosinha");
//				b1.setModelo("Caloi - 12");
//				
//				BicicletaDAO dao = new BicicletaDAO();
//				
//				try {
//					dao.salvarBicicleta(b1);
//					System.out.println("Bicicleta Salva com Sucesso!!");
//				} catch (SQLException e) {
//					System.out.println("A Bicicleta não foi Salva!");
//					e.printStackTrace();
//				}
//				

//				
//				
//				c1.setNome("BrendaTeste");
//				c1.setNascimento(new Date(0));
//				c1.setSexo("F");
//				c1.setEstado("Pernambuco");
//				c1.setCidade("test");
//				c1.setBairro("test");
//				c1.setRua("Luciana Paiva de Souza");
//				c1.setNumero("620");
//				c1.setEmail("brenda@gmail.com");
//				c1.setSenha("134562");
//				c1.setContato("(81) 988651275");
//		
//				ClienteNovoDAO tdao = new ClienteNovoDAO();
//		
//				try {
//					tdao.salvarTeste(c1);
//					System.out.println("Clientes salvos com sucesso!!");
//				} catch (SQLException e) {
//					System.out.println("Os Clientes não foram salvos!!");
//					e.printStackTrace();
//				}

		// TESTANDO METODO EXCLUIR
//
//		BicicletaNova b1 = new BicicletaNova();
//		b1.setId_bicicleta(1L);
//
//		BicicletaDAO cdao = new BicicletaDAO();
//
//		try {
//			cdao.excluir(b1);
//			System.out.println("Cliente excluído com sucesso!!");
//		} catch (SQLException e) {
//			System.out.println("Infelizmente não foi possível excluir este cliente");
//			e.printStackTrace();
//		}
//

		// TESTANDO METODO EDITAR

//		BicicletaNova b = new BicicletaNova();
//		b.setId_bicicleta(4L);
//		b.setDescricao("Bicicleta Rosa Chock teste");
//		b.setModelo("teste");
//		BicicletaDAO cdao = new BicicletaDAO();
//
//		try {
//			cdao.editar(b);
//			System.out.println("Descrição editado com sucesso!!");
//		} catch (SQLException e) {
//			System.out.println("Infelizmente não foi possível editar este cliente");
//			e.printStackTrace();
//		}

		// TESTANDO METODO DE CONSULTA(buscarPorCodigo)

//		BicicletaNova b = new BicicletaNova();
//		b.setId_bicicleta(4L);
//
//		BicicletaDAO cdao = new BicicletaDAO();
//
//		try {
//			BicicletaNova retornoC3 = cdao.buscarPorCodigo(b);
//			//ClienteNovo retornoC4 = cdao.buscarPorCodigo(c2);
//
//			System.out.println("Resultado 1: " + retornoC3);
//			// TESTE PRA SABER SE RETORNA ALGO
//			//System.out.println("Resultado 2: " + retornoC4); // FAZENDO TESTE QUANDO NÃO EXISTE ESSE CLIENTE COM
//			// DETERMNINADO CODIGO, O RESULTADO É NULL
//		} catch (SQLException e) {
//			System.out.println("Infelizmente não foi possível consultar este cliente");
//			e.printStackTrace();
//		}

	}

}
