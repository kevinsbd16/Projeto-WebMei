package br.com.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.model.Usuario;


public class UsuarioController{
	
	private EntityManagerFactory manager = Persistence.createEntityManagerFactory("JSFPrimeJPA"); // nome do
	// persistence-unit
	// (persistence.xml)
	
	public void Salvar(Usuario obj) {
		EntityManager entitymanager = manager.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(obj);
		entitymanager.getTransaction().commit();
	}
	
}