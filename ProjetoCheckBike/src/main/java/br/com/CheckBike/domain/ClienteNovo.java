package br.com.CheckBike.domain;


//import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;



public class ClienteNovo /*implements Serializable*/{


	
	//private static final long serialVersionUID=1L;
	
	
	private Long idCliente;
	
	private String cpf;
	
	private String nome;
	
	private Date nascimento;
	
	private String sexo;

	private String estado;
	
	private String cidade;

	private String bairro;

	private String rua;
	
	private String numero;

	private String email;
	
	private String senha;
	
	private String contato;
	
	
	

	public ClienteNovo(Long idCliente, String cpf, String nome, Date nascimento, String sexo, String estado,
			String cidade, String bairro, String rua, String numero, String email, String senha, String contato) {
		
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.email = email;
		this.senha = senha;
		this.contato = contato;
	}

	public ClienteNovo() {
		
	}

	
	
	
	//ENSINANDO O JAVA A IMPRIMIR O LUGAR CERTO DO CLIENTE , SERA IMPRESSO CONFORME CONFIGURAR NA LINHA 159
	
	
	  public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override public String toString() { String saida = idCliente + " - " + cpf +
	  " - " + nome + " - " + cidade + " - " + email; return saida; }
	 
	
	
	
	
}
