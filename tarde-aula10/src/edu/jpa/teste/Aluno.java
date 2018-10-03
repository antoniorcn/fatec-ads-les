package edu.jpa.teste;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Aluno {
	
	private long id;
	private String ra;
	private String nome;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
