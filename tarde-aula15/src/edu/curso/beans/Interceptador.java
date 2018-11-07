package edu.curso.beans;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Interceptador implements PhaseListener {
	private static final long serialVersionUID = -1035861734239774779L;

	@Override
	public void afterPhase(PhaseEvent e) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		UIViewRoot root = ctx.getViewRoot();
		String pagina = root.getViewId();
		System.out.printf("Depois da Fase %s\n", e.getPhaseId().getName());
		System.out.printf("View Root: %s     Pagina acessada: %s\n", root, pagina);		
	}

	@Override
	public void beforePhase(PhaseEvent e) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		UIViewRoot root = ctx.getViewRoot();
		System.out.printf("Antes da Fase %s\n", e.getPhaseId().getName());
		System.out.printf("View Root: %s  \n", root);		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
