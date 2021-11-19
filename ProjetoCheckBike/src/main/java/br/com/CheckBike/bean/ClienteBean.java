package br.com.CheckBike.bean;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.CheckBike.dao.ClienteNovoDAO;
import br.com.CheckBike.domain.ClienteNovo;
import br.com.CheckBike.util.JSFUtil;

@ManagedBean(name = "MBCliente")
@ViewScoped
public class ClienteBean {

	private ClienteNovo clienteNovo = new ClienteNovo();

	private ClienteNovo clienteLogin = new ClienteNovo();

	public ClienteNovo getClienteNovo() {
		return clienteNovo;
	}

	public void setClienteNovo(ClienteNovo clienteNovo) {
		this.clienteNovo = clienteNovo;
	}

	public ClienteNovo getClienteLogin() {
		return clienteLogin;
	}

	public void setClienteLogin(ClienteNovo clienteLogin) {
		this.clienteLogin = clienteLogin;
	}

	public void novoCliente() {
		System.out.println("entou no metodo");
		try {
			ClienteNovoDAO dao = new ClienteNovoDAO();
			if (clienteNovo.getCpf() == null || clienteNovo.getCpf().equals("")) {
				throw new Exception("Insira o CPF");
			}
			dao.salvarTeste(clienteNovo);
			JSFUtil.adicionarMensagemSucesso("Cliente Salvo com Sucesso!!");
		} catch (Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	public void validacaoLogin() {
		ClienteNovoDAO dao3 = new ClienteNovoDAO();
		try {
			clienteLogin = dao3.loginValidar(clienteLogin);
			if (clienteLogin != null) {
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				try {
					ec.redirect(ec.getRequestContextPath() + "/faces/jsf/init.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Login Realizado com Sucesso!!");
			} else {
				System.out.println("n deu certo");
			}
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Login não foi realizado");
		}

	}
}
