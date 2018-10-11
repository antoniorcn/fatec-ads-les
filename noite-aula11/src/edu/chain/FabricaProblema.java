package edu.chain;

public class FabricaProblema {
	
	public FabricaProblema() { 
		ProblemaArea prob = new ProblemaArea();
		prob.setAltura(15);
		prob.setBase(20);
		prob.setTipo("circulo");
		
		Processo processoA = new ProcessoRetangulo();
		Processo processoB = new ProcessoTriangulo();
		Processo processoC = new ProcessoTrapezio();
		
		processoB.setProximo(processoC);
		processoC.setProximo(processoA);
		
		processoB.executar( prob );
	}
	
	public static void main(String[] args) {
		new FabricaProblema();
	}

}
