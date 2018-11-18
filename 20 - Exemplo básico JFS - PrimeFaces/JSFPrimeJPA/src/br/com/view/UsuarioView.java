package br.com.view;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;

import br.com.controller.UsuarioController;
import br.com.model.Usuario;

@ManagedBean(name = "usuarioView")
@ViewScoped
public class UsuarioView {

	private String nome;
	private String cnpj;
	private String email;
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public void btnSalvarAction(ActionEvent actionEvent) {

		FacesMessage message = null;

		if (this.nome == null || this.nome.trim().length() < 3) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo Nome!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;

		}

		if (this.cnpj == null) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo CNPJ!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;

		}

		if (this.email == null || this.email.trim().length() < 11) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo Email!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		if (this.senha == null) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo Senha!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		if (this.senha.trim().length() < 8) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Por favor, insira uma senha de no mínimo 8 digitos!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		else {

			Usuario usuario = new Usuario();

			usuario.setNome(this.nome);
			usuario.setCnpj(this.cnpj);
			usuario.setEmail(this.email);
			usuario.setSenha(this.senha);
			UsuarioController uc = new UsuarioController();
			uc.Salvar(usuario);

			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", null);

		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("draggable", false);
		opcoes.put("contentHeight", 470);

		PrimeFaces.current().dialog().openDynamic("dadosUsuario", opcoes, null);
	}
}