package br.com.view;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.controller.LoginController;
import br.com.model.Usuario;

@ManagedBean(name = "loginView")
@ApplicationScoped
public class LoginView {
	// atributos
	private LoginController loginController = new LoginController();
	public static Usuario usuario = new Usuario();
	
	// get set
	

	// Limpar o usuario logado ao sair do sistema
	public void sairLogin() {

		usuario = new Usuario();

		try {

			FacesContext.getCurrentInstance().getExternalContext().redirect("loginVenda.xhtml");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Login
	public void Validar() {

		try {

			usuario = loginController.validaUsuario(usuario.getEmail(), usuario.getSenha());

			if (usuario == null) {
				usuario = new Usuario();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));

			} else {
				
				FacesContext.getCurrentInstance().getExternalContext().redirect("inicialVenda.xhtml");
				
			}
		} catch (Exception e) {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro no processamento. \n" + e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		LoginView.usuario = usuario;
	}
	

}