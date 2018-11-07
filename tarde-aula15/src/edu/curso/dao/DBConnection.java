package edu.curso.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {
	
	private static DBConnection instancia = null;
	private EntityManagerFactory emf;
	
	private DBConnection() { 
		emf = Persistence.createEntityManagerFactory("PETS");
	}
	
	public static DBConnection getInstance() { 
		if (instancia == null) { 
			instancia = new DBConnection();
		}
		return instancia;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}
}
