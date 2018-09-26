package edu.entidade;

import java.io.Serializable;

public class Aluno implements Serializable {
	private static final long serialVersionUID = -6477226813592732715L;
	
	private long id;
	private String nome = "";
	private String ra = "";
	private String cidade = "";
	private boolean genero;
	
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
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public boolean isGenero() {
		return genero;
	}
	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() { 
		StringBuffer info = new StringBuffer();
		info.append(this.getId());
		info.append(":");
		info.append(this.getNome());
		info.append(" - ");
		info.append(this.getRa());
		return info.toString();
	}
}
