package edu.teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.enterprise.context.RequestScoped;

@Named
public class VotacaoMB {
	
	private  Map<String, Integer> votacoes = new HashMap<>();

	private String linguagem;

	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	
	public List<Entry<String, Integer>> getVotacoes() {
		return new ArrayList<Entry<String, Integer>>(votacoes.entrySet());
	}

	
	public String vote() {
		System.out.println("Votado em " + linguagem);
		Integer votos = votacoes.get(linguagem);
		if (votos == null) { 
			votos = 0;
		}
		votacoes.put(linguagem, votos + 1);
		return "votacao";
	}
}
