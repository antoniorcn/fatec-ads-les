package edu.curso;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/authenticator")
public class AuthenticaController extends HttpServlet{
	private static final long serialVersionUID = 1467997972749933840L;
	public void doGet(HttpServletRequest request,
					HttpServletResponse response) {
		String txtUser = request.getParameter("TXTUSER");
		String txtPassword = request.getParameter("TXTPASSWORD");
		
		if ("admin".equals(txtUser) && 
				"password".equals(txtPassword)) { 
			HttpSession session = request.getSession();
			session.setAttribute(
					"LOGADO", new Boolean(true));
		}
	}

}