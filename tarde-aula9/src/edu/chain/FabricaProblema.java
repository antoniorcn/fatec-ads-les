package edu.chain;

public class FabricaProblema {
	public static void main(String[] args) {
		
		ProblemaArea p = new ProblemaArea();
		p.setTipo("triangulo");
		p.setAltura(10);
		p.setBase(15);
		
		Processo p1 = new ProcessoRetangulo();
		Processo p2 = new ProcessoTriangulo();
		Processo p3 = new ProcessoTrapezio();
		
		p1.setProximoProcesso(p3);
		p3.setProximoProcesso(p2);
		
		p1.executar(p);
	}
}
