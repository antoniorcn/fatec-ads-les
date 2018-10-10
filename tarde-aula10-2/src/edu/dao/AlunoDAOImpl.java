package edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.entidade.Aluno;

public class AlunoDAOImpl implements AlunoDAO {
	
	private Connection con;
	private EntityManagerFactory emf;

	public AlunoDAOImpl() { 
		emf = Persistence.createEntityManagerFactory("ESCOLA");
	}
	
	@Override
	public void adicionar(Aluno a) throws GenericDAOException { 
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void remover(long id) throws GenericDAOException { 
		EntityManager em = emf.createEntityManager();
		Aluno a = em.find(Aluno.class, id);
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
		em.close();
	}	
	
	@Override
	public List<Aluno> pesquisarPorNome(String nome) throws GenericDAOException { 
		String sql = "select a from Aluno a where a.nome like :nome_aluno";
		List<Aluno> alunos = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		TypedQuery<Aluno> tpdQry = em.createQuery(sql, Aluno.class);
		tpdQry.setParameter("nome_aluno", "%" + nome + "%");
		alunos = tpdQry.getResultList();
		em.close();
		return alunos;
	}

	@Override
	public Aluno pesquisarPorId(long id) throws GenericDAOException {
		EntityManager em = emf.createEntityManager();
		Aluno a = em.find(Aluno.class, id);
		em.close();
		return a;
	}

	@Override
	public void salvar(long id, Aluno a) throws GenericDAOException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		a.setId(id);
		em.merge(a);
		em.getTransaction().commit();
		em.close();
	}

}
