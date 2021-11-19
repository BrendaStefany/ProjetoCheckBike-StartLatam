package br.com.CheckBike.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.CheckBike.domain.ClienteNovo;
import br.com.CheckBike.factory.ConexaoFactory;

public class ClienteNovoDAO {
	public void salvarTeste(ClienteNovo c) throws Exception { // THROWS PROPAGOU O ERRO MAIS UMA VEZ, PARA FRENTE, NO
																	// CASO P O
		// JSF
		StringBuilder sql = new StringBuilder(); // ParteSQL
		sql.append("INSERT INTO cliente ");
		sql.append("(cpf, nome, nascimento, sexo, estado, cidade, bairro, rua, numero, email, senha, contato) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = ConexaoFactory.conectar(); // CAPTUROU A CONEXÃO

			PreparedStatement comando = conexao.prepareStatement(sql.toString()); // CRIOU UM COMANDO APARTIR DA SQL QUE
																					// ERA
																				// UM TEXTO
			
			comando.setString(1, c.getCpf()); // SUBSTITUIU AS INTERROGAÇÕES COM OS NUMEROS
			comando.setString(2, c.getNome());
			comando.setDate(3, new java.sql.Date(c.getNascimento().getTime()));

			comando.setString(4, c.getSexo());
			comando.setString(5, c.getEstado());
			comando.setString(6, c.getCidade());
			comando.setString(7, c.getBairro());
			comando.setString(8, c.getRua());
			comando.setString(9, c.getNumero());
			comando.setString(10, c.getEmail());
			comando.setString(11, c.getSenha());
			comando.setString(12, c.getContato());
			comando.executeUpdate(); // MANDOU RODAR O COMANDO
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Exception message");

		}

	}

	public void excluir(ClienteNovo c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM cliente ");
		sql.append("WHERE id_cliente = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getIdCliente());

		comando.executeUpdate();

	}

	public void editar(ClienteNovo c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE cliente ");
		sql.append("SET nome = ? ");
		sql.append("WHERE id_cliente = ? "); // USA O WHERE PQ SE N VAI ALTERAR TODOS OS NOMES, DESSE JEITO ALTERA DE
												// ACORDO COM O ID

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, c.getNome());
		comando.setLong(2, c.getIdCliente());

		comando.executeUpdate();

	}
	
	
	public ClienteNovo login(ClienteNovo c) throws SQLException {
		 ClienteNovo usuario = null;
		 StringBuilder sql = new StringBuilder();
		 sql.append("SELECT * ");
		 sql.append("FROM cliente ");
		 sql.append("WHERE login=? AND senha=? ");
//		 String sql = “SELECT * FROM Usuario WHERE login=? AND senha=?”;
		 
		 Connection conexao = ConexaoFactory.conectar();
		 
		 PreparedStatement ps = conexao.prepareStatement(sql.toString());
		 ps.setString(1, usuario.getCpf());
		 ps.setString(2, usuario.getSenha());
		 ResultSet rs = ps.executeQuery();
		 
		return usuario;
		
		}
	
	 
	public ClienteNovo loginValidar(ClienteNovo c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM cliente ");
		sql.append("WHERE cpf = ? AND senha = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		// RESULTSET É UMA VARIAVEL QUE GUARDA RESULTADO DE CONSULTA
		ResultSet resultado = comando.executeQuery(); 

		ClienteNovo retorno = null;
		

		// PARA SABER SE RETORNA ALGO
		if (resultado.next()) {
			retorno = new ClienteNovo();
			// PERGUNTA SE TEM PROXIMO, SE DEU CERTO QUER DIZER
																	// QUE TEM PROXIMO, SE NÃO
			retorno.setCpf(resultado.getString("cpf")); // ,QUER DIZER QUE NÃO TEM NADA E CONTINUA VALENDO NULL
			retorno.setSenha(resultado.getString("senha"));
		}

		return retorno;

	}

	public static void main(String[] args) {
//
//		// TESTANDO METODO SALVAR
//
		ClienteNovo c1 = new ClienteNovo();
		c1.setCpf("5678");
		c1.setNome("BrendaTeste");
		c1.setNascimento(new Date(0));
		c1.setSexo("F");
		c1.setEstado("Pernambuco");
		c1.setCidade("test");
		c1.setBairro("test");
		c1.setRua("Luciana Paiva de Souza");
		c1.setNumero("620");
		c1.setEmail("brenda@gmail.com");
		c1.setSenha("134562");
		c1.setContato("(81) 988651275");

		ClienteNovoDAO tdao = new ClienteNovoDAO();

		try {
			tdao.salvarTeste(c1);
			System.out.println("Clientes salvos com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Os Clientes não foram salvos!!");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TESTANDO METODO EXCLUIR

		/*
		 * ClienteNovo c1 = new ClienteNovo(); c1.setIdCliente(2L);
		 * 
		 * ClienteNovoDAO cdao = new ClienteNovoDAO();
		 * 
		 * try { cdao.excluir(c1); System.out.println("Cliente excluído com sucesso!!");
		 * } catch (SQLException e) {
		 * System.out.println("Infelizmente não foi possível excluir este cliente");
		 * e.printStackTrace(); }
		 */

		// TESTANDO METODO EDITAR

//		  ClienteNovo c1 = new ClienteNovo(); 
//		  
//		  c1.setNome("Brenda Stefany");
//		  
//		  
//		  
//		  ClienteNovoDAO cdao = new ClienteNovoDAO();
//		  
//		  try { cdao.editar(c1); System.out.println("Nome editado com sucesso!!"); }
//		  catch (SQLException e) {
//		  System.out.println("Infelizmente não foi possível editar este cliente");
//		  e.printStackTrace(); }
//		 

		// TESTANDO METODO DE CONSULTA(buscarPorCodigo)

//		ClienteNovo c1 = new ClienteNovo();
//		c1.setIdCliente(1L);
//
//		ClienteNovo c2 = new ClienteNovo(); c2.setIdCliente(4L);
//
//		ClienteNovoDAO cdao = new ClienteNovoDAO();
//
//		try {
//			ClienteNovo retornoC3 = cdao.buscarPorCodigo(c1);
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