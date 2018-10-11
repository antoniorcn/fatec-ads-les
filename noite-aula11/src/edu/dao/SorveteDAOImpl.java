package edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.entidade.Sorvete;

public class SorveteDAOImpl implements SorveteDAO {
//	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:54748/sorveteria";
//	private static final String JDBC_USER = "azure";
//	private static final String JDBC_PASS = "6#vWHD_$";
	private EntityManagerFactory emf;

	public SorveteDAOImpl() throws GenericDAOException {
		emf = Persistence.createEntityManagerFactory("SORVETES");
	}

	@Override
	public void adicionar(Sorvete s) throws GenericDAOException {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			throw new GenericDAOException( e );
		}
	}

	@Override
	public List<Sorvete> presquisarPorSabor(String sabor) throws GenericDAOException {
		List<Sorvete> lista = new ArrayList<>();
		String hql = "select s from Sorvete s where s.sabor like :sabor_sorvete";
		try {
			EntityManager em = emf.createEntityManager();
			TypedQuery<Sorvete> qry = em.createQuery(hql, Sorvete.class);
			qry.setParameter("sabor_sorvete", "%" + sabor + "%");
			lista = qry.getResultList();
			em.close();
			
		} catch (Exception e) {
			throw new GenericDAOException( e );
		}
		return lista;
	}

	@Override
	public void remover(long id) throws GenericDAOException {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Sorvete s = em.find(Sorvete.class, id);
			em.remove( s );
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			throw new GenericDAOException( e );
		}
	}

	@Override
	public Sorvete pesquisarPorId(long id) throws GenericDAOException {
		Sorvete s = new Sorvete();
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			s = em.find(Sorvete.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			throw new GenericDAOException( e );
		}
		return s;
	}

	@Override
	public void salvar(long id, Sorvete s) throws GenericDAOException {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			s.setId(id);
			em.merge(s);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			throw new GenericDAOException( e );
		}
	}

}
