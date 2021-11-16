//package br.com.CheckBike.bean;
//
//import java.sql.SQLException;
//import java.util.Date;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.event.ActionEvent;
//
//import br.com.CheckBike.dao.ClienteNovoDAO;
//import br.com.CheckBike.domain.Cliente;
//
//@ViewScoped
//@ManagedBean(name = "testeBean")
//public class testeBean {
//
//	private Cliente cliente;
//	
//
////	// chama teu método de salvar
////	public void salvar(ActionEvent ae) {
////		try {
////			cliente.setNome("brenda");
////			cliente.setCpf("222");
////			cliente.setEmail("teste");
////			cliente.setNascimento(new Date(0));
////			cliente.setSexo("F");
////			cliente.setEstado("pe");
////			cliente.setBairro("teste");
////			cliente.setCidade("teste");
////			cliente.setRua("teste");
////			cliente.setNumero("2");
////			cliente.setSenha("134562");
////			testeDAO.salvar(cliente);
////		} catch (Exception e) {
////
////			System.out.println("Ocorreu o seguinte erro" + e);
////
////		}
////	}
//
////	public void setClientes() {
////		try {
////			cliente.setNome("chiquinho");
////			cliente.setCpf("222");
////			cliente.setEmail("teste");
////			cliente.setNascimento(new Date(0));
////			cliente.setSexo("M");
////			cliente.setEstado("pe");
////			cliente.setBairro("teste");
////			cliente.setCidade("teste");
////			cliente.setRua("teste");
////			cliente.setNumero("2");
////			cliente.setSenha("134562");
////			testeDAO.salvarTeste(cliente);
////			System.out.println("Cliente salvo com sucesso");
////		} catch (Exception e) {
////
////			System.out.println("Ocorreu o seguinte erro" + e);
////
////		}
////}
//	
//	
//
//	public void salvarTeste() {
//		ClienteNovoDAO dao = new ClienteNovoDAO();
//		dao.salvarTeste(cliente);
//	}
//	
//	
//	
//	
//	/*
//	 * public void salvarT() { try { testeDAO.salvarTeste(cliente); } catch
//	 * (SQLException e) { e.printStackTrace(); } }
//	 */
//	
//	
//
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
//
//	public ClienteNovoDAO getTesteDAO() {
//		return ClienteNovoDAO;
//	}
//
//	public void setTesteDAO(ClienteNovoDAO testeDAO) {
//		this.testeDAO = testeDAO;
//	}
//
//}
