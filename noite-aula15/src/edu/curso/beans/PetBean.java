package edu.curso.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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
	
	public void validaDataNascimento(FacesContext ctx, UIComponent ui, Object obj) { 
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -7);
		Date d = (Date)obj;
		
		if (cal.getTimeInMillis() < d.getTime()) { 
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Data de nascimento incorreta", 
						"A data de nascimento deve ser inferior a 1 semana atrás");
			throw new ValidatorException(msg);
		}
	}
	
	public String adicionar() { 
		getPets().add(petAtual);		
		
		String msgTexto = String.format("Foram cadastrados %d animais \n", getPets().size());
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Animal " + petAtual.getNome() + " foi cadastrado com sucesso", 
					msgTexto);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		petAtual = new Pet();
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
