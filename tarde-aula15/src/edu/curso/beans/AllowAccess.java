package edu.curso.beans;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
public class AllowAccess implements PhaseListener{
	private static final long serialVersionUID = 2516481390307358763L;

	@Override
	public void afterPhase(PhaseEvent e) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		UIViewRoot root = ctx.getViewRoot();
		String pagina = root.getViewId();
		Application app = ctx.getApplication();
		if (!"/login.xhtml".equals(pagina)) { 
			UserBean u = app.evaluateExpressionGet(ctx, "#{userBean}", UserBean.class);
			if (! u.getLogged()) {
				System.out.println("Usuário não está logado, "
						+ "redirecionando para a pagina de login");
				NavigationHandler nav = app.getNavigationHandler();
				nav.handleNavigation(ctx, "", "login?faces-redirect=true");
				ctx.renderResponse();
			}
			
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
