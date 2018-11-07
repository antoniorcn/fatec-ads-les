package edu.curso.dao;

import java.util.List;

import edu.curso.entity.Pet;

public interface PetDAO {
	
	void adicionar(Pet p);
	void remover(Pet p);
	List<Pet> pesquisarPorNome(String nome);

}
