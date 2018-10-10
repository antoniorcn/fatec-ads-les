package edu.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteConsulta {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ESCOLA");
		EntityManager em = emf.createEntityManager();


//		TypedQuery<Aluno> qry = 
//		  em.createQuery("select a from Aluno a", Aluno.class);
//		
//		List<Aluno> alunos = qry.getResultList();
//
		
		TypedQuery<SalaAula> qry = 
		  em.createQuery("select s from SalaAula s join s.alunos a", SalaAula.class);
		
		List<SalaAula> salas = qry.getResultList();
		
		for (SalaAula s : salas) {
			System.out.println("Sala : " + s.getNumero());
			for (Aluno a : s.getAlunos()) { 
				System.out.println(a.getNome());
			}
		}
		
		em.close();
		emf.close();
	}

}
