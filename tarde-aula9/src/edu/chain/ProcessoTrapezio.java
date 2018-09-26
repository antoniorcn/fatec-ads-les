package edu.chain;
public class ProcessoTrapezio extends Processo {

	@Override
	public void executar(ProblemaArea p) {
		System.out.println("Executando processo Trapezio");
		if ("trapezio".equals(p.getTipo())) { 
			System.out.println("Processo Trapezio sabe resolver este problema");
			float area = p.getBase() * p.getAltura() * 2;
			System.out.println("Area do trapezio = " + area);
		} else { 
			super.executar(p);
		}


	}

}
