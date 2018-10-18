package edu.curso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class VotacaoMB implements Serializable {
	private List<Voto> votos = new ArrayList<>();
	private String linguagem;

	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	
	public List<Voto> getVotos() {
		return votos;
	}
	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
	public String votar() { 
		Voto v = new Voto();
		v.setLinguagem(linguagem);
		v.setVotos(1);
		votos.add(v);
		return "";
	}

}
