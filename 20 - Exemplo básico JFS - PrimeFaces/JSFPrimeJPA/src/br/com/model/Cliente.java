package br.com.model;


import javax.persistence.*;

@Entity
public class Cliente {

	/* ====================================================================================================*/
	/* ====================================ATRIBUTOS DA CLASSE=============================================*/
	/* ====================================================================================================*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
    private String nome;
	private String telefone;
    private String email;
    private Usuario user;

	/* ====================================================================================================*/
	/* =====================================GETTERS E SETTERS==============================================*/
	/* ====================================================================================================*/

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	

}
