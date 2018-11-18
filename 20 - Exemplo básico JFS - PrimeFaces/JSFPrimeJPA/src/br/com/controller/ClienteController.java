package br.com.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import br.com.model.Cliente;
import br.com.view.LoginView;


public class ClienteController {
	

	private EntityManagerFactory manager = Persistence.createEntityManagerFactory("JSFPrimeJPA"); // nome do
																									// persistence-unit
	/* ====================================================================================================*/
	/* ====================================METODO PARA SALVAR==============================================*/
	/* ====================================================================================================*/
	public Cliente Salvar(Cliente cliente) {
		EntityManager entityManager = manager.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			if (cliente.getCodigo() != 0) {
				cliente = entityManager.merge(cliente);

			} else {
				entityManager.persist(cliente);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return cliente;
	}
	
	/* ====================================================================================================*/
	/* ====================================METODO PARA EXCLUIR=============================================*/
	/* ====================================================================================================*/
	public void Excluir(int codigo) {
		EntityManager entityManager = manager.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Cliente c = entityManager.find(Cliente.class, codigo);
			System.out.println("Excluindo os dados de: " + c.getNome());
			entityManager.remove(c);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
	/* ====================================================================================================*/
	/* ====================================METODO PARA LISTAR==============================================*/
	/* ====================================================================================================*/

	public List<Cliente> ListarCliente(Cliente obj) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Cliente> query = entitymanager.createQuery("SELECT c FROM Cliente c where c.user.codigo ='" + cod +"'", Cliente.class);

		return query.getResultList();

	}

	public List<Cliente> FiltrarC(String nome) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Cliente> query = entitymanager
				.createQuery("SELECT c FROM Cliente c WHERE c.nome like :nome and c.user.codigo ='" + cod +"'", Cliente.class)
				.setParameter("nome", "%" + nome + "%");

		return query.getResultList();

	}

}