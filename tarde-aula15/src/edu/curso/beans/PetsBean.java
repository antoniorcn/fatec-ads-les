package edu.curso.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import edu.curso.dao.DBConnection;
import edu.curso.entity.Pet;

@ManagedBean
@SessionScoped
public class PetsBean {
	private List<Pet> animais = new ArrayList<>();
	private List<Pet> animaisPesquisados = new ArrayList<>();
	private Pet animal = new Pet();
	private EntityManagerFactory emf;
	
	public PetsBean(){ 
		emf = DBConnection.getInstance().getEmf();
	}
	
	public String adicionar() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -7);
		FacesMessage msg = null;
		if (cal.getTimeInMillis() <= animal.getNascimento().getTime()) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Data de nascimento incorreta", 
					"A data de nascimento deve ser no minimo 7 dias anterior ao dia de hoje");
			FacesContext.getCurrentInstance().addMessage("form:txtNascimento", msg);
		} else { 
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(animal);
			em.getTransaction().commit();
			em.close();
			animal = new Pet();
			String msgDetail = String.format("Existem %d animais na lista\n", animais.size());
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Animal adicionado com sucesso", msgDetail);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return "";
	}
	public String pesquisar() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Pet> qry = em.createQuery("select p from Pet p where p.nome like :nome", Pet.class);
		qry.setParameter("nome", "%" + animal.getNome() + "%");
		animaisPesquisados = qry.getResultList();
		em.close();
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
