package edu.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteUpdate {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ESCOLA");
		EntityManager em = emf.createEntityManager();

		Aluno a2 = em.getReference(Aluno.class, 2l);
		SalaAula s = em.getReference(SalaAula.class, 0l);
		em.getTransaction().begin();
		s.getAlunos().remove(a2);
		em.remove(a2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
