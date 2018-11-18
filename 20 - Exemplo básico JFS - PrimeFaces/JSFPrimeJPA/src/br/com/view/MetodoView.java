package br.com.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import br.com.controller.MetodoController;
import br.com.model.Metodo;
import br.com.model.Usuario;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "metodoView")
@ViewScoped
public class MetodoView {
	// -----------------------------------------------------------------------------------------------------------//
	// -----------------------------------------Atributos Get
	// Set-------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------//
	private int cod_tipopagamento;
	private String descricao;
	private List<Metodo> listaMetodo;
	private Usuario user;

	public int getCod_tipopagamento() {
		return cod_tipopagamento;
	}

	public void setCod_tipopagamento(int cod_tipopagamento) {
		this.cod_tipopagamento = cod_tipopagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Metodo> getListaMetodo() {
		return listaMetodo;
	}

	public void setListaMetodo(List<Metodo> listaMetodo) {
		this.listaMetodo = listaMetodo;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	// -----------------------------------------------------------------------------------------------------------//
	// ----------------------------------------------Botões-------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------//
	public void btnSalvarAction(ActionEvent actionEvent) {

		FacesMessage message = null;

		if (LoginView.usuario == null || LoginView.usuario.getNome() == null || LoginView.usuario.getNome() == "") {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, faça login como um usuario!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		if (this.descricao == null || this.descricao.trim().length() < 1) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo Descrição!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		else {

			Metodo metodo = new Metodo();
			metodo.setCod_tipopagamento(this.cod_tipopagamento);
			metodo.setDescricao(this.descricao);
			metodo.setUser(LoginView.usuario);
			MetodoController mc = new MetodoController();
			mc.Salvar(metodo);
			this.descricao = "";
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", null);

		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void btnExcluirAction(ActionEvent actionEvent) {
		FacesMessage message = null;
		try {
			if (this.cod_tipopagamento != 0) {
				new MetodoController().Excluir(this.cod_tipopagamento);
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Excluido com sucesso!", null);
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, selecione um metodo!", null);
			}
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Não foi possivel excluir!", null);
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		this.cod_tipopagamento = 0;
	}

	// -----------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------Métodos-------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------//

	public void recarregar() {
		this.setListaMetodo(new MetodoController().ListarMetodo());
	}

	{
		this.setListaMetodo(new MetodoController().ListarMetodo());
	}

	public void selectMetodoFromDialog(Metodo metodo) {
		PrimeFaces.current().dialog().closeDynamic(metodo);
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("draggable", false);
		opcoes.put("contentHeight", 470);

		PrimeFaces.current().dialog().openDynamic("selecaoMetodo", opcoes, null);
	}

	public void emDialogo(SelectEvent event) {
		Metodo metodo = (Metodo) event.getObject();
		this.descricao = metodo.getDescricao();
		this.cod_tipopagamento = metodo.getCod_tipopagamento();

	}
}