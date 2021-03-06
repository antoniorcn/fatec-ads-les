package edu.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ESCOLA");
		EntityManager em = emf.createEntityManager();

		SalaAula s1 = new SalaAula();
		s1.setNumero("102");
		
		Aluno a1 = new Aluno();
		a1.setId(1);
		a1.setNome("Antonio Rodrigues");
		a1.setRa("123");
			
		Aluno a2 = new Aluno();
		a2.setId(2);
		a2.setNome("Maria DB");
		a2.setRa("234");
		
		s1.getAlunos().add(a1);
		s1.getAlunos().add(a2);
		
		em.getTransaction().begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(s1);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
