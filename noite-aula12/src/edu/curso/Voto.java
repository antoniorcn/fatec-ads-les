package edu.curso;

import java.io.Serializable;

public class Voto implements Serializable {
	
	private String linguagem;
	private int votos;
	
	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
}
