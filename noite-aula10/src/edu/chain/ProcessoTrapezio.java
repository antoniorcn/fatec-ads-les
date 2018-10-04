package edu.chain;

public class ProcessoTrapezio extends Processo {

	@Override
	public void executar(ProblemaArea p) {
		System.out.println("Processo Trapezio sendo executado");
		if ("trapezio".equals(p.getTipo())) { 
			float area = p.getBase() * p.getAltura() * 2;
			System.out.println("Area de trapezio calculada : " + area);
		} else { 
			System.out.println("Processo Trapezio não pode resolver o problema, direcionando...");
			super.executar(p);
		}
			
	}

}
