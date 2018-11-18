package br.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Metodo {

	/* ====================================================================================================*/
	/* ===================================ATRIBUTOS DA CLASSE==============================================*/
	/* ====================================================================================================*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_tipopagamento;
    private String descricao;
    private Usuario user;
    
	/* ====================================================================================================*/
	/* ====================================GETTERS E SETTERS===============================================*/
	/* ====================================================================================================*/
    
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
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}


}
