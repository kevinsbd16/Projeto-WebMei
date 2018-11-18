package br.com.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.com.controller.MetodoController;
import br.com.controller.VendaController;
import br.com.model.Cliente;
import br.com.model.Metodo;
import br.com.model.Usuario;
import br.com.model.Venda;
import br.com.view.VendaView;

@ManagedBean(name = "vendaView")
@SessionScoped
public class VendaView {
	// -----------------------------------------------------------------------------------------------------------//
	// -----------------------------------------Atributos Get Set-------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------//
	private int codigo;
	private double valor;
	private Date data;
	private String descricao;
	private String metodo;
	private Cliente cliente;
	private Usuario user;
	private Venda venda;
	private List<Venda> listaVenda;
	private String valorF;
	private String diaF;
	private String mesF;
	private String anoRelatorio;
	private double soma;
	double[] somas = new double[13];

	private List<Venda> relatorioAtual;
	private List<Venda> relatorio;
	private List<Venda> relatorioJaneiro;
	private List<Venda> relatorioFevereiro;
	private List<Venda> relatorioMarco;
	private List<Venda> relatorioAbril;
	private List<Venda> relatorioMaio;
	private List<Venda> relatorioJunho;
	private List<Venda> relatorioJulho;
	private List<Venda> relatorioAgosto;
	private List<Venda> relatorioSetembro;
	private List<Venda> relatorioOutubro;
	private List<Venda> relatorioNovembro;
	private List<Venda> relatorioDezembro;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDiaF() {
		return diaF;
	}

	public void setDiaF(String diaF) {
		this.diaF = diaF;
	}

	public String getMesF() {
		return mesF;
	}

	public void setMesF(String mesF) {
		this.mesF = mesF;
	}

	public String getmesF() {
		return diaF;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public Venda getVenda() {
		if (venda == null) {
			venda = new Venda();
		}
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public String getValorF() {
		return valorF;
	}

	public void setValorF(String valorF) {
		this.valorF = valorF;
	}

	public Cliente getCliente() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {

	}

	public List<SelectItem> getMetodoSelect() {

		Metodo m1 = new Metodo();
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Metodo> metodoSelect = MetodoController.ListarMetodos(m1);
		for (Metodo category : metodoSelect) {
			items.add(new SelectItem(category.getDescricao()));
		}
		return items;

	}

	public String getAnoRelatorio() {
		return anoRelatorio;
	}

	public void setAnoRelatorio(String anoRelatorio) {
		this.anoRelatorio = anoRelatorio;
	}

	public double getSoma() {
		return soma;
	}

	public void setSoma(double soma) {
		this.soma = soma;
	}

	public double[] getSomas() {
		return somas;
	}

	public void setSoma(double[] somas) {
		this.somas = somas;
	}

	public Usuario getUser() {
		if (user == null) {
			user = new Usuario();
		}
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public void setRelatorioAtual(List<Venda> relatorioAtual) {
		this.relatorioAtual = relatorioAtual;
	}

	public void setRelatorio(List<Venda> relatorio) {
		this.relatorio = relatorio;
	}

	public void setRelatorioJaneiro(List<Venda> relatorioJaneiro) {
		this.relatorioJaneiro = relatorioJaneiro;
	}

	public void setRelatorioFevereiro(List<Venda> relatorioFevereiro) {
		this.relatorioFevereiro = relatorioFevereiro;
	}

	public void setRelatorioMarco(List<Venda> relatorioMarco) {
		this.relatorioMarco = relatorioMarco;
	}

	public void setRelatorioAbril(List<Venda> relatorioAbril) {
		this.relatorioAbril = relatorioAbril;
	}

	public void setRelatorioMaio(List<Venda> relatorioMaio) {
		this.relatorioMaio = relatorioMaio;
	}

	public void setRelatorioJunho(List<Venda> relatorioJunho) {
		this.relatorioJunho = relatorioJunho;
	}

	public void setRelatorioJulho(List<Venda> relatorioJulho) {
		this.relatorioJulho = relatorioJulho;
	}

	public void setRelatorioAgosto(List<Venda> relatorioAgosto) {
		this.relatorioAgosto = relatorioAgosto;
	}

	public void setRelatorioSetembro(List<Venda> relatorioSetembro) {
		this.relatorioSetembro = relatorioSetembro;
	}

	public void setRelatorioOutubro(List<Venda> relatorioOutubro) {
		this.relatorioOutubro = relatorioOutubro;
	}

	public void setRelatorioNovembro(List<Venda> relatorioNovembro) {
		this.relatorioNovembro = relatorioNovembro;
	}

	public void setRelatorioDezembro(List<Venda> relatorioDezembro) {
		this.relatorioDezembro = relatorioDezembro;
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

		if (this.cliente.getNome() == null || this.cliente.getNome() == "") {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, selecione um cliente!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		if (this.descricao == null || this.descricao.trim().length() < 1) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo Descrição!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;

		}

		if (this.valor == 0) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, insira um valor!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		if (this.data == null) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo Data!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;

		}

		if (this.metodo == null || this.metodo.trim().length() < 1) {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo Método de pagamento!",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		else {

			Venda venda = new Venda();
			venda.setCodigo(this.codigo);
			venda.setCliente(this.cliente);
			venda.setData(this.data);
			venda.setDescricao(this.descricao);
			venda.setValor(this.valor);
			venda.setMetodo(this.metodo);
			venda.setUser(LoginView.usuario);
			VendaController vc = new VendaController();
			vc.Salvar(venda);
			this.cliente = null;
			this.descricao = "";
			this.valor = 0;
			this.data = null;
			this.metodo = "";

			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", null);

		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void btnExcluirAction(ActionEvent actionEvent) {
		FacesMessage message = null;
		try {
			if (this.codigo != 0) {
				new VendaController().Excluir(this.codigo);
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Excluido com sucesso!", null);
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, selecione uma venda!", null);
			}
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Não foi possivel excluir, este cliente possui pelo menos uma compra!", null);
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		this.codigo = 0;
		this.descricao = "";
		this.valor = 0;
		this.data = null;
		this.metodo = "";
		this.cliente = null;
	}

	public void btnFiltrarAction(ActionEvent actionEvent) {

		Venda v = new Venda();
		FacesMessage message = null;

		if (LoginView.usuario == null || LoginView.usuario.getNome() == null || LoginView.usuario.getNome() == "") {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, faça login como um usuario!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		if (diaF.isEmpty() && mesF.isEmpty() && valorF != "") {
			this.setListaVenda(new VendaController().FiltrarAno(valorF));
		}

		if (diaF.isEmpty() && mesF != "" && valorF != "") {
			this.setListaVenda(new VendaController().FiltrarMes(valorF, mesF));
		}
		if (valorF != "" && mesF != "" && diaF != "") {
			this.setListaVenda(new VendaController().Filtrar(valorF, mesF, diaF));
		}
		if (valorF == "" && mesF == "" && diaF == "") {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha os campos com a data desejada!",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}
		this.diaF = null;
		this.mesF = null;
		this.valorF = null;

	}

	public void btnFiltrarAtualAction(ActionEvent actionEvent) {
		
		FacesMessage message = null;
		
		if (LoginView.usuario == null || LoginView.usuario.getNome() == null || LoginView.usuario.getNome() == "") {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, faça login como um usuario!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		Venda v = new Venda();

		this.setListaVenda(new VendaController().FiltrarAtual());

	}

	public void btnFiltrarAnoRelatorio(ActionEvent actionEvent) {

		FacesMessage message = null;

		if (LoginView.usuario == null || LoginView.usuario.getNome() == null || LoginView.usuario.getNome() == "") {

			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, faça login como um usuario!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		if (this.anoRelatorio == "0" || this.anoRelatorio == null) {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, preencha o campo ano!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

		else {
			Venda v = new Venda();

			this.setRelatorio(new VendaController().RelatorioAnual(this.anoRelatorio));
			this.somas[0] = 0;
			for (Venda v2 : relatorio) {
				somas[0] += v2.getValor();
			}

			this.setRelatorioJaneiro(new VendaController().RelatorioJaneiro(this.anoRelatorio));
			this.somas[1] = 0;
			for (Venda v3 : relatorioJaneiro) {
				somas[1] += v3.getValor();
			}

			this.setRelatorioFevereiro(new VendaController().RelatorioFevereiro(this.anoRelatorio));
			this.somas[2] = 0;
			for (Venda v4 : relatorioFevereiro) {
				somas[2] += v4.getValor();
			}

			this.setRelatorioMarco(new VendaController().RelatorioMarco(this.anoRelatorio));
			this.somas[3] = 0;
			for (Venda v5 : relatorioMarco) {
				somas[3] += v5.getValor();
			}

			this.setRelatorioAbril(new VendaController().RelatorioAbril(this.anoRelatorio));
			this.somas[4] = 0;
			for (Venda v6 : relatorioAbril) {
				somas[4] += v6.getValor();
			}

			this.setRelatorioMaio(new VendaController().RelatorioMaio(this.anoRelatorio));
			this.somas[5] = 0;
			for (Venda v7 : relatorioMaio) {
				somas[5] += v7.getValor();
			}

			this.setRelatorioJunho(new VendaController().RelatorioJunho(this.anoRelatorio));
			this.somas[6] = 0;
			for (Venda v8 : relatorioJunho) {
				somas[6] += v8.getValor();
			}

			this.setRelatorioJulho(new VendaController().RelatorioJulho(this.anoRelatorio));
			this.somas[7] = 0;
			for (Venda v9 : relatorioJulho) {
				somas[7] += v9.getValor();
			}

			this.setRelatorioAgosto(new VendaController().RelatorioAgosto(this.anoRelatorio));
			this.somas[8] = 0;
			for (Venda v10 : relatorioAgosto) {
				somas[8] += v10.getValor();
			}

			this.setRelatorioSetembro(new VendaController().RelatorioSetembro(this.anoRelatorio));
			this.somas[9] = 0;
			for (Venda v11 : relatorioSetembro) {
				somas[9] += v11.getValor();
			}

			this.setRelatorioOutubro(new VendaController().RelatorioOutubro(this.anoRelatorio));
			this.somas[10] = 0;
			for (Venda v12 : relatorioOutubro) {
				somas[10] += v12.getValor();
			}

			this.setRelatorioNovembro(new VendaController().RelatorioNovembro(this.anoRelatorio));
			this.somas[11] = 0;
			for (Venda v13 : relatorioNovembro) {
				somas[11] += v13.getValor();
			}

			this.setRelatorioDezembro(new VendaController().RelatorioDezembro(this.anoRelatorio));
			this.somas[12] = 0;
			for (Venda v14 : relatorioDezembro) {
				somas[12] += v14.getValor();
			}

		}
	}

	{

		Venda v = new Venda();

		this.setRelatorioAtual(new VendaController().RelatorioAtual());
		this.soma = 0;
		for (Venda v2 : relatorioAtual) {
			soma += v2.getValor();
		}
	}

	// -----------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------Métodos-------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------//

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("draggable", false);
		opcoes.put("contentHeight", 470);

		PrimeFaces.current().dialog().openDynamic("selecaoCliente", opcoes, null);
	}

	public void abrirDialogoVenda() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("draggable", false);
		opcoes.put("contentHeight", 470);

		PrimeFaces.current().dialog().openDynamic("selecaoVenda", opcoes, null);
	}

	public void emDialogo(SelectEvent event) {
		Cliente cliente = (Cliente) event.getObject();
		this.cliente = cliente;

	}

	public void emVenda(SelectEvent event) {
		Venda venda = (Venda) event.getObject();
		this.codigo = venda.getCodigo();
		this.cliente = venda.getCliente();
		this.descricao = venda.getDescricao();
		this.valor = venda.getValor();
		this.data = venda.getData();
		this.metodo = venda.getMetodo();

	}

	public void selectVendaFromDialog(Venda venda) {
		PrimeFaces.current().dialog().closeDynamic(venda);
	}

}
