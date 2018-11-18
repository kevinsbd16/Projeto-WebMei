package br.com.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.model.Metodo;
import br.com.view.LoginView;

public class MetodoController {

	private static EntityManagerFactory manager = Persistence.createEntityManagerFactory("JSFPrimeJPA"); // nome do
																									// persistence-unit
																									// (persistence.xml)
	/* ====================================================================================================*/
	/* ====================================METODO PARA SALVAR==============================================*/
	/* ====================================================================================================*/
	
	public Metodo Salvar(Metodo metodo) {
		EntityManager entityManager = manager.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			if (metodo.getCod_tipopagamento() != 0) {
				metodo = entityManager.merge(metodo);

			} else {
				entityManager.persist(metodo);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return metodo;
	}
	/* ====================================================================================================*/
	/* ====================================METODO PARA EXCLUIR=============================================*/
	/* ====================================================================================================*/
	
	public void Excluir(int cod_tipopagamento) {
		EntityManager entityManager = manager.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Metodo m = entityManager.find(Metodo.class, cod_tipopagamento);
			System.out.println("Excluindo os dados de: " + m.getDescricao());
			entityManager.remove(m);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
	/* ====================================================================================================*/
	/* ====================================METODO PARA LISTAR==============================================*/
	/* ====================================================================================================*/
	
	public static List<Metodo> ListarMetodos(Metodo obj) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Metodo> query = entitymanager.createQuery("SELECT m FROM Metodo m where m.user.codigo ='" + cod +"'", Metodo.class);

		return query.getResultList();

	}
	
	public List<Metodo> ListarMetodo() {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Metodo> query = entitymanager.createQuery("SELECT m FROM Metodo m where m.user.codigo ='" + cod +"'", Metodo.class);

		return query.getResultList();

	}

}
