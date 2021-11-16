//package teste;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//import br.com.CheckBike.dao.BicicletaDAO;
//import br.com.CheckBike.domain.BicicletaNova;
//import br.com.CheckBike.domain.ClienteNovo;
//
//public class BicicletaDAOTest {
//	@Test
//	@Ignore
//	public void salvarBici() throws SQLException {
//		BicicletaNova bici = new BicicletaNova();
//		bici.setDescricao("Bicicleta Azul");
//		bici.setModelo("Caloi - 18");
//
//		ClienteNovo cn = new ClienteNovo();
//		cn.setIdCliente(3L);
//
//		bici.setClienteNovo(cn);
//
//		BicicletaDAO dao = new BicicletaDAO();
//		dao.salvarBicicleta(bici);
//
//	}
//	
//	@Test
//	@Ignore
//	public void listar() throws SQLException {
//		BicicletaDAO dao = new BicicletaDAO();
//		ArrayList<BicicletaNova> lista = dao.listar();
//		
//		for(BicicletaNova b : lista) {
//			System.out.println("Código da Bicicleta: " + b.getId_bicicleta());
//			System.out.println("Descrição: " + b.getDescricao());
//			System.out.println("Modelo da Bicicleta: " + b.getModelo());
//			System.out.println("Nome do Cliente: " + b.getClienteNovo().getNome());
//			System.out.println("E-mail: " + b.getClienteNovo().getEmail());
//			System.out.println("Contato (com DDD): " + b.getClienteNovo().getContato());
//			System.out.println("Cidade: " + b.getClienteNovo().getCidade());
//			System.out.println("Rua/Av.: " + b.getClienteNovo().getRua());
//			System.out.println("Nº: " + b.getClienteNovo().getNumero());
//			System.out.println();
//		}
//	}
//	@Test
//	@Ignore
//	public void excluir() throws SQLException {
//		BicicletaNova b = new BicicletaNova();
//		b.setId_bicicleta(1L);
//		
//		BicicletaDAO dao = new BicicletaDAO();
//		dao.excluir(b);
//	}
//	
//	@Test
//	public void editar() throws SQLException {
//		BicicletaNova b = new BicicletaNova();
//		
//		b.setId_bicicleta(1L);
//		b.setDescricao("vaidarcerto checkbike");
//		b.setModelo("Oggi Maquina");
//		
//		ClienteNovo c = new ClienteNovo();
//		c.setIdCliente(1L);
//		
//		b.setClienteNovo(c);
//	}
//
//}