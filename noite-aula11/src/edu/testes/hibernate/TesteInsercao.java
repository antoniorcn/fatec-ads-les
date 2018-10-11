package edu.testes.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.entidade.Loja;
import edu.entidade.Sorvete;

public class TesteInsercao {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("SORVETES");
		EntityManager em = emf.createEntityManager();
		
		
		Sorvete s1 = new Sorvete();
		s1.setId(1);
		s1.setSabor("Morango selvagem");
		s1.setPreco(12.0f);
		s1.setTipo("massa");
		s1.setCobertura("morango");
		
		Sorvete s2 = new Sorvete();
		s2.setId(2);
		s2.setSabor("Chocolate Belga");
		s2.setPreco(12.0f);
		s2.setTipo("massa");
		s2.setCobertura("chocolate");
		
		Sorvete s3 = new Sorvete();
		s3.setId(3);
		s3.setSabor("Carioca");
		s3.setPreco(12.0f);
		s3.setTipo("massa");
		s3.setCobertura("chocolate");
		
				
		Loja l1 = new Loja();
		l1.setNome("Americanas");
		l1.setId(1);
		l1.getSorvetes().add(s1);
		l1.getSorvetes().add(s2);
		
		Loja l2 = new Loja();
		l2.setNome("Carrefour");
		l2.setId(2);
		l2.getSorvetes().add(s2);
		l2.getSorvetes().add(s3);
		
		
		
		em.getTransaction().begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(l1);
		em.persist(l2);
		em.getTransaction().commit();
		
		em.close();

	}

}
