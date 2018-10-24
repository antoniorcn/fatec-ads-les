package edu.curso.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.curso.entity.Pet;

@ManagedBean
@SessionScoped
public class PetsBean {
	private List<Pet> animais = new ArrayList<>();
	private List<Pet> animaisPesquisados = new ArrayList<>();
	private Pet animal = new Pet();
	public String adicionar() { 
		animais.add(animal);
		animal = new Pet();
		System.out.printf("Existem %d animais na lista\n", animais.size());
		return "";
	}
	public String pesquisar() { 
		animaisPesquisados.clear();
		for (Pet p : animais) { 
			if (p.getNome().contains(animal.getNome())) { 
				animaisPesquisados.add(p);
			}
		}
		return "";
	}

	public Pet getAnimal() {
		return animal;
	}
	public void setAnimal(Pet animal) {
		this.animal = animal;
	}
	
	public List<Pet> getAnimais() {
		return animais;
	}
	public void setAnimais(List<Pet> animais) {
		this.animais = animais;
	}

	public List<Pet> getAnimaisPesquisados() {
		return animaisPesquisados;
	}
	public void setAnimaisPesquisados(List<Pet> animaisPesquisados) {
		this.animaisPesquisados = animaisPesquisados;
	}
}
