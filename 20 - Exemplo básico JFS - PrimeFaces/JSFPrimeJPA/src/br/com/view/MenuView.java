package br.com.view;
 
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

 
@ManagedBean(name = "menuView")
public class MenuView {
     
	public void btnRedirectListaVendaAction(ActionEvent actionEvent) {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listaVenda.xhtml");
		} catch (IOException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro no processamento. \n" + e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void btnRedirectPaginaVendaAction(ActionEvent actionEvent) {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("dadosVenda.xhtml");
		} catch (IOException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro no processamento. \n" + e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void btnRedirectPaginaInicialAction(ActionEvent actionEvent) {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("inicialVenda.xhtml");
		} catch (IOException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro no processamento. \n" + e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void btnRedirectRelatorioVendaAction(ActionEvent actionEvent) {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("relatorioVenda.xhtml");
		} catch (IOException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro no processamento. \n" + e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	public void btnRedirectDadosClienteAction(ActionEvent actionEvent) {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("dadosCliente.xhtml");
		} catch (IOException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro no processamento. \n" + e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	public void btnRedirectLoginAction(ActionEvent actionEvent) {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("loginVenda.xhtml");
		} catch (IOException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro no processamento. \n" + e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void btnRedirectMetodoAction(ActionEvent actionEvent) {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("dadoMetodo.xhtml");
		} catch (IOException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro no processamento. \n" + e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
}