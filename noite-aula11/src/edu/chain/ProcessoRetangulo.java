package edu.chain;

public class ProcessoRetangulo extends Processo {

	@Override
	public void executar(ProblemaArea p) {
		System.out.println("Processo Retangulo sendo executado");
		if ("retangulo".equals(p.getTipo())) { 
			float area = p.getBase() * p.getAltura();
			System.out.println("Area de retangulo calculada : " + area);
		} else { 
			System.out.println("Processo Retangulo não pode resolver o problema, direcionando...");
			super.executar(p);
		}
	}

}
