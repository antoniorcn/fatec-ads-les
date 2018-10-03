package edu.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteDelete {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ESCOLA");
		EntityManager em = emf.createEntityManager();

		Aluno a2 = em.getReference(Aluno.class, 2l);
		
		em.getTransaction().begin();
		a2.setNome("Maria aparecida");
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
