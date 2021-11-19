//package domain.checkbike;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="bicicleta")
//public class Bicicleta implements Serializable{
//
//	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
//	@Column (name = "id_bicicleta")
//	private Long idBicicleta;
//	@Column (length=255)
//	private String descricao;
//	private Long modeloFabricante;
//	
//	//private List<ClienteBicicleta> listClienteBicicleta;
//
//	public Bicicleta(Long idBicicleta, String descricao, Long modeloFabricante) {
//		this.idBicicleta = idBicicleta;
//		this.modeloFabricante = modeloFabricante;
//		/* this.listClienteBicicleta = listClienteBicicleta; */
//	}
//
//
//	public Bicicleta() {
//		
//	}
//	
//	
//	public Long getIdBicicleta() {
//		return idBicicleta;
//	}
//
//	public void setIdBicicleta(Long idBicicleta) {
//		this.idBicicleta = idBicicleta;
//	}
//
//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//
//	public Long getModeloFabricante() {
//		return modeloFabricante;
//	}
//
//	public void setModeloFabricante(Long modeloFabricante) {
//		this.modeloFabricante = modeloFabricante;
//	}
//
////	public List<ClienteBicicleta> getListClienteBicicleta() {
////		return listClienteBicicleta;
////	}
////
////	public void setListClienteBicicleta(List<ClienteBicicleta> listClienteBicicleta) {
////		this.listClienteBicicleta = listClienteBicicleta;
////	}
//
//}