package edu.chain;

public class ProcessoTriangulo extends Processo {

	@Override
	public void executar(ProblemaArea p) {
		System.out.println("Processo Triangulo sendo executado");
		if ("triangulo".equals(p.getTipo())) { 
			float area = p.getBase() * p.getAltura() / 2;
			System.out.println("Area de triangulo calculada : " + area);
		} else { 
			System.out.println("Processo Triangulo não pode resolver o problema, direcionando...");
			super.executar(p);
		}
	}

}
