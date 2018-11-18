package br.com.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.model.Usuario;

public class LoginController {

	private EntityManagerFactory manager = Persistence.createEntityManagerFactory("JSFPrimeJPA"); // nome do
	// persistence-unit
	// (persistence.xml)

	// metodo de validar login

	public Usuario validaUsuario(String email, String senha) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JSFPrimeJPA");
		EntityManager em = factory.createEntityManager();

		try {
			Usuario usuario = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.email = :email and u.senha = :senha")
					.setParameter("email", email).setParameter("senha", senha).getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}

}