//package domain.checkbike;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Transient;
//
//
//@Entity
//@Table (name = "cliente")
//public class Cliente implements Serializable{
//
//	
//	//perguntar se é pra chamar direto da tela, a DAO ou vai ter uma transaction
//
//	
//	private static final long serialVersionUID=1L;
//	
//	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
//	@Column (name = "id_cliente")
//	private Long idCliente;
//	@Column (length=45, nullable=false)
//	private String cpf;
//	@Column (length=255, nullable=false)
//	private String nome;
//	@Temporal(TemporalType.DATE)
//	@Column (nullable=false)
//	private Date nascimento;
//	@Column (length=20, nullable=false)
//	private String sexo;
//	@Column (length=20, nullable=false)
//	private String estado;
//	@Column (length=45, nullable=false)
//	private String cidade;
//	@Column (length=255, nullable=false)
//	private String bairro;
//	@Column (length=255, nullable=false)
//	private String rua;
//	@Column (length=20, nullable=false)
//	private String numero;
//	@Column (length=255, nullable=false)
//	private String email;
//	@Column (length=8, nullable=false)
//	private String senha;
//	/*
//	 * @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch =
//	 * FetchType.LAZY)
//	 * 
//	 * @JoinTable(name="cliente_bicicleta", joinColumns =
//	 * {@JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")},
//	 * inverseJoinColumns = {@JoinColumn(name="id_bicicleta", referencedColumnName =
//	 * "id_bicicleta")})
//	 * 
//	 * private List<ClienteBicicleta> listClienteBicicleta; // private
//	 * List<ClienteTelefone> listClienteTelefone;
//	 */	
//
//	/*
//	 * //tirei do construtor List<ClienteBicicleta> listClienteBicicleta,
//	 * List<ClienteTelefone> listClienteTelefone public Cliente(Long idCliente,
//	 * String cpf, String nome, Date nascimento, String sexo, String estado, String
//	 * cidade, String bairro, String rua, String numero, String email,String senha )
//	 * {
//	 * 
//	 * this.idCliente = idCliente; this.cpf = cpf; this.nome = nome; this.nascimento
//	 * = nascimento; this.sexo = sexo; this.estado = estado; this.cidade = cidade;
//	 * this.bairro = bairro; this.rua = rua; this.numero = numero;
//	 * 
//	 * this.email = email; this.senha=senha; // this.listClienteBicicleta =
//	 * listClienteBicicleta; // this.listClienteTelefone = listClienteTelefone;
//	 * 
//	 * }
//	 * 
//	 */
//	
//	public Cliente() {
//		
//	
//	}
//
//	
//	public Long getIdCliente() {
//		return idCliente;
//	}
//
//	public void setIdCliente(Long idCliente) {
//		this.idCliente = idCliente;
//	}
//
//	public String getCpf() {
//		return cpf;
//	}
//
//	public void setCpf(String cpf) {
//		this.cpf = cpf;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public Date getNascimento() {
//		return nascimento;
//	}
//
//	public void setNascimento(Date nascimento) {
//		this.nascimento = nascimento;
//	}
//
//	public String getSexo() {
//		return sexo;
//	}
//
//	public void setSexo(String sexo) {
//		this.sexo = sexo;
//	}
//
//	public String getEstado() {
//		return estado;
//	}
//
//	public void setEstado(String estado) {
//		this.estado = estado;
//	}
//
//	public String getCidade() {
//		return cidade;
//	}
//
//	public void setCidade(String cidade) {
//		this.cidade = cidade;
//	}
//
//	public String getBairro() {
//		return bairro;
//	}
//
//	public void setBairro(String bairro) {
//		this.bairro = bairro;
//	}
//
//	public String getRua() {
//		return rua;
//	}
//
//	public void setRua(String rua) {
//		this.rua = rua;
//	}
//
//	public String getNumero() {
//		return numero;
//	}
//
//	public void setNumero(String numero) {
//		this.numero = numero;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	@Transient
//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//
//
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(idCliente);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Cliente other = (Cliente) obj;
//		return Objects.equals(idCliente, other.idCliente);
//	}
//	
//	/*
//	 * @Transient public List<ClienteBicicleta> getListClienteBicicleta() { return
//	 * listClienteBicicleta; }
//	 * 
//	 * public void setListClienteBicicleta(List<ClienteBicicleta>
//	 * listClienteBicicleta) { this.listClienteBicicleta = listClienteBicicleta; }
//	 * 
//	 * public List<ClienteTelefone> getListClienteTelefone() { return
//	 * listClienteTelefone; }
//	 * 
//	 * public void setListClienteTelefone(List<ClienteTelefone> listClienteTelefone)
//	 * { this.listClienteTelefone = listClienteTelefone; }
//	 */
//
//	//ENSINANDO O JAVA A IMPRIMIR O LUGAR CERTO DO CLIENTE , SERA IMPRESSO CONFORME CONFIGURAR NA LINHA 159
//	
//	/*
//	 * @Override public String toString() { String saida = idCliente + " - " + cpf +
//	 * " - " + nome + " - " + cidade + " - " + email; return saida; }
//	 */
//	
//	
//	
//	
//}
//
