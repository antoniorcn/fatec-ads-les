package edu.entidade;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Loja {
	
	private long id;
	private String nome;
	private Set<Sorvete> sorvetes = new HashSet<>();
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ManyToMany
	public Set<Sorvete> getSorvetes() {
		return sorvetes;
	}
	public void setSorvetes(Set<Sorvete> sorvetes) {
		this.sorvetes = sorvetes;
	}
}
