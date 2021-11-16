package br.com.CheckBike.bean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.CheckBike.dao.ClienteNovoDAO;
import br.com.CheckBike.domain.ClienteNovo;
import br.com.CheckBike.util.JSFUtil;

@ManagedBean(name = "MBCliente")
@ViewScoped
public class ClienteBean {

	private ClienteNovo clienteNovo = new ClienteNovo();

	public ClienteNovo getClienteNovo() {
		return clienteNovo;
	}

	public void setClienteNovo(ClienteNovo clienteNovo) {
		this.clienteNovo = clienteNovo;
	}

	public void novoCliente() {
		System.out.println("entou no metodo");
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			ClienteNovoDAO dao = new ClienteNovoDAO();
			if (clienteNovo.getCpf() == null || clienteNovo.getCpf().equals("")) {
				throw new Exception("Insira o CPF");
			}
			dao.salvarTeste(clienteNovo);
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Produto cadastrado com sucesso!"));
			// JSFUtil.adicionarMensagemSucesso("Cliente Salvo com Sucesso!!");
		} catch (Exception ex) {
			ex.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", ex.getMessage()));

		}

	}
}
