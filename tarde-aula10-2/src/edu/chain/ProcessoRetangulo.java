package edu.chain;
public class ProcessoRetangulo extends Processo {

	@Override
	public void executar(ProblemaArea p) {
		System.out.println("Executando processo Retangulo");
		if ("retangulo".equals(p.getTipo())) { 
			System.out.println("Processo Retangulo sabe resolver este problema");
			float area = p.getBase() * p.getAltura();
			System.out.println("Area do retangulo = " + area);
		} else { 
			super.executar(p);
		}

	}

}
