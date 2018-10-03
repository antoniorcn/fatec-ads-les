package edu.chain;

public abstract class Processo {
	
	private Processo proximoProcesso;

	public Processo getProximoProcesso() {
		return proximoProcesso;
	}

	public void setProximoProcesso(Processo proximoProcesso) {
		this.proximoProcesso = proximoProcesso;
	}
	
	
	public void executar(ProblemaArea p) { 
		if (getProximoProcesso() != null){
			System.out.println("Não sei resolver, passando para o proximo processo");
			getProximoProcesso().executar(p);
		} else {
			System.out.println("Problema não foi resolvido acabou a cadeia de responsabilidade");
		}
	}

}
