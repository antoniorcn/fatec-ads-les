package edu.chain;
public class ProcessoTriangulo extends Processo {

	@Override
	public void executar(ProblemaArea p) {
		System.out.println("Executando processo Triangulo");
		if ("triangulo".equals(p.getTipo())) { 
			System.out.println("Processo Triangulo sabe resolver este problema");
			float area = p.getBase() * p.getAltura() / 2;
			System.out.println("Area do triangulo = " + area);
		} else { 
			super.executar(p);
		}
	}

}
