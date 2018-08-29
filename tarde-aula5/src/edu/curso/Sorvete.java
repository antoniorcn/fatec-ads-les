package edu.curso;

import java.io.Serializable;

public class Sorvete implements Serializable {
	private static final long serialVersionUID = -2296146498982884168L;
	private long id = 0;
	private String sabor = "Morango";
	private double preco = 5.0;
	private String tipo = "picole";
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
