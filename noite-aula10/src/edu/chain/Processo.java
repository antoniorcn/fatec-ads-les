package edu.chain;

public abstract class Processo {
	
	private Processo proximo;
	
	public void executar(ProblemaArea p) { 
		if (getProximo() != null) { 
			getProximo().executar(p);
		} else { 
			System.out.println("Problema não pode ser resolvido cadeia encerrada");
		}
	}

	public Processo getProximo() {
		return proximo;
	}
	public void setProximo(Processo proximo) {
		this.proximo = proximo;
	}

}
