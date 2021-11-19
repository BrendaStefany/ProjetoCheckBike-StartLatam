package domain.checkbike;
//package br.com.CheckBike.domain;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//import domain.checkbike.Bicicleta;
//
//@Entity
//@Table(name = "modelo_fabricante")
//public class ModeloFabricante {
//
//	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
//	@Column(name="id_modelo_fabricante")
//	private Long idModeloFabricante;
//	@Column(length=255, nullable=false)
//	private String fabricante;
//	@Transient
//	private List<Bicicleta> listBicicleta;
//	
//	public ModeloFabricante(Long idModeloFabricante, String fabricante, List<Bicicleta> listBicicleta ) {
//	
//		this.idModeloFabricante=idModeloFabricante;
//		this.fabricante=fabricante;
//		this.listBicicleta=listBicicleta;
//	}
//	
//	public ModeloFabricante() {
//		
//		
//	}
//
//	public Long getIdModeloFabricante() {
//		return idModeloFabricante;
//	}
//
//	public void setIdModeloFabricante(Long idModeloFabricante) {
//		this.idModeloFabricante = idModeloFabricante;
//	}
//
//	public String getFabricante() {
//		return fabricante;
//	}
//
//	public void setFabricante(String fabricante) {
//		this.fabricante = fabricante;
//	}
//
//	public List<Bicicleta> getListBicicleta() {
//		return listBicicleta;
//	}
//
//	public void setListBicicleta(List<Bicicleta> listBicicleta) {
//		this.listBicicleta = listBicicleta;
//	}
//	
//}
