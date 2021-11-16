//package br.com.CheckBike.model;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import domain.checkbike.Cliente;
//
//public class Teste {
//
//	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Banco");
//	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
//	
//	public static void main(String[] args) {
//		
//		
//		
//		  //SELECT 
//			
//			  Cliente cliente = entityManager.find(Cliente.class,2L);
//			  
//			  //lemmbrar sempre de testar se houve retorno de objeto do banco
//			  System.out.println("Nome do cliente" + cliente.toString());
//			 
//		
//		
//	    /*
//	     * if(teste != null) {
//	     * 
//	     * System.out.println("Nome do cliente" + cliente.getNome()); } else {
//	     * System.out.println("Objeto não encontrado no BD"); }
//	     */		
//
//		
//		/*
//		 * // INSERT Cliente cliente = new Cliente(); cliente.setNome("Teste");
//		 * cliente.setBairro("cruz"); cliente.setCidade("igarauu");
//		 * cliente.setCpf("0000000"); cliente.setEmail("teste");
//		 * cliente.setEstado("pe"); cliente.setNascimento(new Date());
//		 * cliente.setNumero("123123"); cliente.setRua("rua a"); cliente.setSexo("M");
//		 */
//		  entityManager.getTransaction().begin(); 
//		  entityManager.persist(cliente);
//		  entityManager.getTransaction().commit();
//		 
//		  
//		 /* DELETE
//		  * Cliente cliente = entityManager.find(Cliente.class,1L);
//		  * cliente.setNome("Teste");
//		  * entityManager.getTransaction().begin(); 
//		  * entityManager.remove(cliente);
//		  * entityManager.getTransaction().commit(); 
//		  */
//		
//		 /*
//		  * MODIFY
//		  * Cliente cliente = new Cliente();
//		  * cliente.setId(2);
//		  * cliente.setNome("Teste2");
//		  * 
//		  * entityManager.getTransaction().begin(); 
//		  * entityManager.merge(cliente);
//		  * entityManager.getTransaction().commit(); 
//		  */
//	}
//
//}
