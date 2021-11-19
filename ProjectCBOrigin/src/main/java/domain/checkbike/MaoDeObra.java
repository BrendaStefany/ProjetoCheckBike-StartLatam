package domain.checkbike;

public class MaoDeObra {

	private Long idMaoDeObra;
	private String descricao;
	private Double valorMaoDeObra;
	
	public MaoDeObra(Long idMaoDeObra, String descricao, Double valorMaoDeObra) {
		
		this.idMaoDeObra=idMaoDeObra;
		this.descricao=descricao;
		this.valorMaoDeObra=valorMaoDeObra;
		
	}

	public Long getIdMaoDeObra() {
		return idMaoDeObra;
	}

	public void setIdMaoDeObra(Long idMaoDeObra) {
		this.idMaoDeObra = idMaoDeObra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorMaoDeObra() {
		return valorMaoDeObra;
	}

	public void setValorMaoDeObra(Double valorMaoDeObra) {
		this.valorMaoDeObra = valorMaoDeObra;
	}

}