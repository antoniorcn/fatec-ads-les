package edu.curso;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Authenticator")
public class AuthenticatorController extends HttpServlet {
	private static final long serialVersionUID = -5250452579844179902L;
	
	public void doGet(HttpServletRequest request, 
				HttpServletResponse response) {
		String user = request.getParameter("TXTUSER");
		String pass = request.getParameter("TXTPASS");
		HttpSession session = request.getSession();
		try {
			if ("convidado".equals(user) && "123456".equals(pass)) { 
				Boolean b = new Boolean(true);
				session.setAttribute("LOGADO", b);
				response.sendRedirect("./index.jsp");
			} else { 
				session.setAttribute("LOGADO", null);
				response.sendRedirect("./login.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
