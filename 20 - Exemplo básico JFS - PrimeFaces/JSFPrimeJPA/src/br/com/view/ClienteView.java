package br.com.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import br.com.controller.ClienteController;
import br.com.model.Cliente;
import br.com.model.Usuario;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "clienteView")
@ViewScoped
public class ClienteView {
	// -----------------------------------------------------------------------------------------------------------//
	// -----------------------------------------Atributos Get Set-------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------//

	private int codigo;
	private String nome;
	private String nomeF;
	private String telefone;
	private String email;
	private List<Cliente> listaCliente;
	private Cliente clienteSelect;
	private Usuario user;

	public Cliente getClienteSelect() {
		return clienteSelect;
	}

	public void setClienteSelect(Cliente clienteSelect) {
		this.clienteSelect = clienteSelect;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeF() {
		return nomeF;
	}

	public void setNomeF(String nomeF) {
		this.nomeF = nomeF;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

		if (this.nome == null || this.nome.trim().length() < 1) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo Nome!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		if (this.telefone == null || this.telefone.trim().length() < 1) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo Telefone!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;

		}

		else {

			Cliente c = new Cliente();
			c.setCodigo(this.codigo);
			c.setNome(this.nome);
			c.setEmail(this.email);
			c.setTelefone(this.telefone);
			c.setUser(LoginView.usuario);
			ClienteController cc = new ClienteController();
			cc.Salvar(c);
			this.codigo = 0;
			this.nome = "";
			this.telefone = "";
			this.email = "";
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", null);

		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void btnExcluirAction(ActionEvent actionEvent) {
		FacesMessage message = null;
		try {
			if (this.codigo != 0) {
				new ClienteController().Excluir(this.codigo);
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Excluido com sucesso!", null);
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, selecione um cliente!", null);
			}
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Não foi possivel excluir, este cliente possui pelo menos uma compra!", null);
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		this.codigo = 0;
		this.nome = "";
		this.telefone = "";
		this.email = "";
	}

	// -----------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------Métodos-------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------//

	public void selectClienteFromDialog(Cliente cliente) {
		PrimeFaces.current().dialog().closeDynamic(cliente);
	}

	{
		Cliente c = new Cliente();
		this.setListaCliente(new ClienteController().ListarCliente(c));
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("draggable", false);
		opcoes.put("contentHeight", 470);

		PrimeFaces.current().dialog().openDynamic("selecaoCliente", opcoes, null);
	}

	public void emDialogo(SelectEvent event) {
		Cliente cliente = (Cliente) event.getObject();
		this.codigo = cliente.getCodigo();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();

	}

	public void btnFiltrarAction(ActionEvent actionEvent) {

		// Cliente c = new Cliente();

		this.setListaCliente(new ClienteController().FiltrarC(nomeF));

	}

}