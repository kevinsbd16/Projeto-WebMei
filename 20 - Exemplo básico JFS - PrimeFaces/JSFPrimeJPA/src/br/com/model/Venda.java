package br.com.model;

import java.util.Date;
import javax.persistence.*;

import com.sun.istack.NotNull;


@Entity
public class Venda {

	/* ====================================================================================================*/
	/* ====================================ATRIBUTOS DA CLASSE=============================================*/
	/* ====================================================================================================*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private double valor;
	@Temporal(TemporalType.DATE)
	private Date data;
	private String descricao;
	private String metodo;
	private Cliente cliente;
	private Usuario user;

	/* ====================================================================================================*/
	/* ====================================GETTERS E SETTERS===============================================*/
	/* ====================================================================================================*/

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
