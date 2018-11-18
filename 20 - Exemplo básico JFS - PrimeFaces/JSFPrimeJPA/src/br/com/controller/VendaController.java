package br.com.controller;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.model.Venda;
import br.com.view.LoginView;

public class VendaController {
	
	private EntityManagerFactory manager = Persistence.createEntityManagerFactory("JSFPrimeJPA"); // nome do
																									// persistence-unit
																									// (persistence.xml)
	
	/* ====================================================================================================*/
	/* ====================================METODO PARA SALVAR==============================================*/
	/* ====================================================================================================*/
	
	public Venda Salvar(Venda venda) {
		EntityManager entityManager = manager.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			if (venda.getCodigo() != 0) {
				venda = entityManager.merge(venda);

			} else {
				entityManager.persist(venda);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return venda;
	}
	
	/* ====================================================================================================*/
	/* ====================================METODO PARA EXCLUIR=============================================*/
	/* ====================================================================================================*/
	public void Excluir(int codigo) {
		EntityManager entityManager = manager.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Venda v = entityManager.find(Venda.class, codigo);
			System.out.println("Excluindo os dados de: " + v.getDescricao());
			entityManager.remove(v);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
	/* ====================================================================================================*/
	/* ==================================FILTROS COM PARÂMETROS============================================*/
	/* ====================================================================================================*/

	public List<Venda> Filtrar(String valorF, String mesF, String diaF) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("SELECT v from Venda v WHERE substring(v.data, 1, 4) ='" + valorF + "' AND substring(v.data, 6, 2) ='" +mesF+ "' AND substring(v.data, 9, 2) ='" +diaF+ "' and v.user.codigo ='" + cod +"'", Venda.class);
		    return query.getResultList();
		}
	
	public List<Venda> FiltrarMes(String valorF, String mesF) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("SELECT v from Venda v WHERE substring(v.data, 1, 4) ='" + valorF + "' AND substring(v.data, 6, 2) ='" +mesF+ "' and v.user.codigo ='" + cod +"'", Venda.class);
		    return query.getResultList();
		}
	
	public List<Venda> FiltrarAno(String valorF) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("SELECT v from Venda v WHERE substring(v.data, 1, 4) ='" + valorF + "' and v.user.codigo ='" + cod +"'", Venda.class);
		    return query.getResultList();
		}
		
	
	public List<Venda> FiltrarAtual() {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("SELECT v FROM Venda v WHERE v.data = CURRENT_DATE and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	
	/* ====================================================================================================*/
	/* ============================FILTROS COM SUM POR ANO E CADA MÊS======================================*/
	/* ====================================================================================================*/
	
	public List<Venda> RelatorioAnual(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	
	public List<Venda> RelatorioJaneiro(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '01' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	
	public List<Venda> RelatorioFevereiro(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '02' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	public List<Venda> RelatorioMarco(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '03' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	
	public List<Venda> RelatorioAbril(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '04' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	public List<Venda> RelatorioMaio(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '05' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	public List<Venda> RelatorioJunho(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '06' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	public List<Venda> RelatorioJulho(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '07' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	public List<Venda> RelatorioAgosto(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '08' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	public List<Venda> RelatorioSetembro(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '09' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	public List<Venda> RelatorioOutubro(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '10' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	public List<Venda> RelatorioNovembro(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '11' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	public List<Venda> RelatorioDezembro(String anoRelatorio) {
		
		int cod = LoginView.usuario.getCodigo();

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' and substring(v.data, 6, 2) = '12' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	
	public List<Venda> RelatorioAtual() {

		Calendar cal = Calendar.getInstance();
	    int ano = cal.get(Calendar.YEAR);
	    int cod = LoginView.usuario.getCodigo();
	    
		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select v from Venda v WHERE substring(v.data, 1, 4) ='" + ano + "' and v.user.codigo ='" + cod +"'", Venda.class);

		return query.getResultList();

	}
	
	public List<Venda> RelatorioGroup() {
		Calendar cal = Calendar.getInstance();
	    int ano = cal.get(Calendar.YEAR);

		EntityManager entitymanager = manager.createEntityManager();

		TypedQuery<Venda> query = entitymanager.createQuery("select sum(v.valor) from Venda v WHERE substring(v.data, 1, 4) ='" + ano + "' group by substring(v.data, 6, 2)", Venda.class);

		return query.getResultList();

	}
	/*public List<Venda[]> RelatoriodoAno(String anoRelatorio) {


		String jpql = "select NEW br.com.model.Venda (sum(v.valor)) from Venda v WHERE substring(v.data, 1, 4) = '" + anoRelatorio + "' group by substring(v.data, 6, 2)";
		Query query = ((EntityManager) manager).createQuery(jpql);
		List<Venda[]> resultado = (List<Venda[]>) query.getResultList();
		for (Venda[]) linha in resultado){
			double soma = (double) Venda[0];
		}
		
		/*("select v from Venda v WHERE substring(v.data, 1, 4) ='"+ anoRelatorio +"' group by substring(v.data, 6, 2)", Venda.class);*/
	/*} */
		
}
