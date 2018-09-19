package edu.entidade;

import java.io.Serializable;

public class Sorvete implements Serializable {
	private static final long serialVersionUID = 6295997158682583939L;
	
	private long id;
	private String sabor = "";
	private float preco;
	private String tipo = "";
	private String cobertura = "";
	
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
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getCobertura() {
		return cobertura;
	}
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
	
	@Override
	public String toString() { 
		StringBuffer s = new StringBuffer();
		s.append("Id:");
		s.append(this.getId());
		s.append("\tSabor:");
		s.append(this.getSabor());
		s.append("\tTipo:");
		s.append(this.getTipo());
		return s.toString();
	}
}
