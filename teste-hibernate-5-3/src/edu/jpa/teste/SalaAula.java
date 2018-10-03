package edu.jpa.teste;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class SalaAula {
	
	private long id;
	private String numero;
	private Set<Aluno> alunos = new HashSet<>();
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length=10)
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@ManyToMany
	public Set<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
}
