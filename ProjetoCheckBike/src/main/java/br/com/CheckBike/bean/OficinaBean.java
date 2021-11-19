package br.com.CheckBike.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.CheckBike.dao.BicicletaDAO;
import br.com.CheckBike.dao.OficinaDAO;
import br.com.CheckBike.domain.BicicletaNova;
import br.com.CheckBike.domain.Oficina;
import br.com.CheckBike.util.JSFUtil;

@ManagedBean(name = "MBOficina")
@ViewScoped
public class OficinaBean {
	private ListDataModel<Oficina> oficinas;
	
	private Oficina oficinaSelecionada;

	OficinaDAO dao = new OficinaDAO();
	
	private Oficina oficina = new Oficina();
	
	
	public ListDataModel<Oficina> getOficinas() {
		return oficinas;
	}


	public void setOficinas(ListDataModel<Oficina> oficinas) {
		this.oficinas = oficinas;
	}


	public Oficina getOficinaSelecionada() {
		return oficinaSelecionada;
	}


	public void setOficinaSelecionada(Oficina oficinaSelecionada) {
		this.oficinaSelecionada = oficinaSelecionada;
	}
	

	public Oficina getOficina() {
		return oficina;
	}


	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}


	@PostConstruct
	public void prepararPesquisa() {
		try {
			OficinaDAO dao = new OficinaDAO();
			ArrayList<Oficina> lista = dao.listarOficina();
			oficinas = new ListDataModel<Oficina>(lista);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	public void deletarOficinaSlecionada() {
		try {
			dao.excluir(oficinaSelecionada);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void novaOficina() {
		System.out.println("entrou no metodo");
		//FacesContext context = FacesContext.getCurrentInstance();
		try {
			OficinaDAO dao3 = new OficinaDAO();
//		//	if (clienteNovo.getCpf() == null || clienteNovo.getCpf().equals("")) {
//				throw new Exception("Insira o CPF");
//			}
			dao3.salvar(oficina);
//			context.addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Produto cadastrado com sucesso!"));
			JSFUtil.adicionarMensagemSucesso("Oficina Salvo com Sucesso!!");
		} catch (Exception ex) {
			ex.printStackTrace();
			//context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", ex.getMessage()));
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
	
	public void editarOficina() {
		try {
			dao.editar(oficinaSelecionada);
			ArrayList<Oficina> listaOficinas = dao.listarOficina();
			oficinas = new ListDataModel<Oficina>(listaOficinas);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	

}
