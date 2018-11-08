package edu.curso.beans;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autenticacao implements PhaseListener {
	private static final long serialVersionUID = -3400028311559742853L;
	@Override
	public void afterPhase(PhaseEvent e) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Application app = ctx.getApplication();
		UIViewRoot root = ctx.getViewRoot();
		String pagina = root.getViewId();
		System.out.println("Pagina acessada : " + pagina);
		if (!"/login.xhtml".equals(pagina)) { 
			UserBean u = app.evaluateExpressionGet(ctx, 
					"#{userBean}", UserBean.class);
			if (! u.isLogged()) { 
				FacesMessage msg = 
						new FacesMessage("É preciso logar primeiro antes de acessar o sistema");
				ctx.getExternalContext().getFlash().setKeepMessages(true);
				ctx.addMessage(null, msg);
				NavigationHandler nav = app.getNavigationHandler();
				nav.handleNavigation(ctx, "", "login?faces-redirect=true");
				ctx.renderResponse();
			}
		}
	}
	@Override
	public void beforePhase(PhaseEvent e) {
	}
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}	
}
