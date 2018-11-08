package edu.curso.beans;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Interceptador implements PhaseListener{
	private static final long serialVersionUID = -1035861734239774779L;
	@Override
	public void afterPhase(PhaseEvent e) {
		System.out.printf("Depois da fase %s \n", e.getPhaseId().getName());
	}
	@Override
	public void beforePhase(PhaseEvent e) {
		System.out.printf("Antes da fase %s \n", e.getPhaseId().getName());
	}
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
