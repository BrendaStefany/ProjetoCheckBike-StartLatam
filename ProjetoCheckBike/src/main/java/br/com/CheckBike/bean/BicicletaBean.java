package br.com.CheckBike.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import br.com.CheckBike.dao.BicicletaDAO;

import br.com.CheckBike.domain.BicicletaNova;

import br.com.CheckBike.util.JSFUtil;


@ManagedBean (name="MBBicicleta")
@ViewScoped
public class BicicletaBean {

	private ListDataModel<BicicletaNova> bicicletas;
	
	private BicicletaNova bicicletaNova = new BicicletaNova();
	
	BicicletaDAO dao2 = new BicicletaDAO();
	
	private BicicletaNova bicicletaSelecionada;

	public ListDataModel<BicicletaNova> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(ListDataModel<BicicletaNova> bicicletas) {
		this.bicicletas = bicicletas;
	}

	public BicicletaNova getBicicletaNova() {
		return bicicletaNova;
	}

	public void setBicicletaNova(BicicletaNova bicicletaNova) {
		this.bicicletaNova = bicicletaNova;
	}


	public BicicletaNova getBicicletaSelecionada() {
		return bicicletaSelecionada;
	}

	public void setBicicletaSelecionada(BicicletaNova bicicletaSelecionada) {
		this.bicicletaSelecionada = bicicletaSelecionada;
	}

	@PostConstruct
	public void prepararPesquisaBicicleta() {
		try {
			ArrayList<BicicletaNova> listaBicicletas = dao2.listarBicicleta();
			bicicletas = new ListDataModel<BicicletaNova>(listaBicicletas);
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	
	
//	public void prepararPesquisaBicicleta() {
//		try {
//			ArrayList<BicicletaNova> listaBici = dao.listarBicicleta();
//			bicicletas = new ListDataModel<BicicletaNova>(listaBici);
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
//	
//	public void CarregarListagem() {
//		try {
//			System.out.println("entou no metodo");
//			bicicletas = bicicletaDAO.salvarBicicleta();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			JSFUtil.adicionarMensagemErro(ex.getMessage());
//		}
//	}
//	
	public void novaBicicleta() {
		System.out.println("entrou no metodo");
		//FacesContext context = FacesContext.getCurrentInstance();
		try {
			BicicletaDAO dao = new BicicletaDAO();
//		//	if (clienteNovo.getCpf() == null || clienteNovo.getCpf().equals("")) {
//				throw new Exception("Insira o CPF");
//			}
			dao.salvarBicicleta(bicicletaNova);
//			context.addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Produto cadastrado com sucesso!"));
			JSFUtil.adicionarMensagemSucesso("Bicicleta Salvo com Sucesso!!");
		} catch (Exception ex) {
			ex.printStackTrace();
			//context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", ex.getMessage()));
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
	
	public void deletarBicicletaSelecionada() {
		try {
			dao2.excluir(bicicletaSelecionada);
			JSFUtil.adicionarMensagemSucesso("Bicicleta Excluída com Sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
//	public void prepararEditar() {
//		try {
//			
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
	
	public void editarBicicleta() {
		try {
			dao2.editar(bicicletaSelecionada);
			ArrayList<BicicletaNova> listaBicicletas = dao2.listarBicicleta();
			bicicletas = new ListDataModel<BicicletaNova>(listaBicicletas);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
