package edu.curso.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.curso.entity.Pet;

@ManagedBean
@SessionScoped
public class PetBean {
	private List<Pet> pets = new ArrayList<>();
	private List<Pet> petsEncontrados = new ArrayList<>();
	private Pet petAtual = new Pet();
	
	
	public PetBean() { 
		petAtual.setNascimento(new Date());
	}
	
	public String adicionar() { 
		getPets().add(petAtual);
		petAtual = new Pet();
		System.out.printf("Foram cadastrados %d animais \n", getPets().size());
		return "";
	}
	
	public String pesquisar() { 
		getPetsEncontrados().clear();
		for (Pet p : pets) { 
			if (p.getNome().contains(petAtual.getNome())) { 
				getPetsEncontrados().add(p);
			}
		}
		System.out.printf("Foram encontrados %d animais\n", petsEncontrados.size());
		return "";
	}

	public Pet getPetAtual() {
		return petAtual;
	}
	public void setPetAtual(Pet petAtual) {
		this.petAtual = petAtual;
	}

	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public List<Pet> getPetsEncontrados() {
		return petsEncontrados;
	}
	public void setPetsEncontrados(List<Pet> petsEncontrados) {
		this.petsEncontrados = petsEncontrados;
	}
}
