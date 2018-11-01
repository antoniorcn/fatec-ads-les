package edu.curso.entity;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.Length;

public class Pet {
	
	private long id;
	@Length(min=4, max=100, message="O nome do animal precisa ter entre 4 e 100 caracteres")
	private String nome;
	private Date nascimento;
	@DecimalMax(value="50.0", message="Peso nao pode ultrapassar 50 kilos")
	@DecimalMin(value="0.1", message="Peso nao pode ser inferior a 100 gramas")
	private float peso;
	
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
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
}
