package edu.curso;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/authenticator")
public class AuthenticaController extends HttpServlet{
	private static final long serialVersionUID = 1467997972749933840L;
	public void doPost(HttpServletRequest request,
					HttpServletResponse response) {
		String txtUser = request.getParameter("TXTUSER");
		String txtPassword = request.getParameter("TXTPASSWORD");
		String pagina = "./login.jsp";
		UserInfo userInfo = null;
		String mensagem = null;
		if ("admin".equals(txtUser) && 
				"password".equals(txtPassword)) {
			userInfo = new UserInfo();
			userInfo.setNome("Antonio Rodrigues");
			userInfo.setLogado(true);
			userInfo.setProfile("admin");
			pagina = "./admin.jsp";
		} else if ("guest".equals(txtUser) && 
				"password".equals(txtPassword)) {
			userInfo = new UserInfo();
			userInfo.setNome("Antonio Rodrigues");
			userInfo.setLogado(true);
			userInfo.setProfile("user");
			pagina = "./index.jsp";
		} else { 
			mensagem = "Usuário ou senha incorretos";
		}
		HttpSession session = request.getSession();
		session.setAttribute(
				"LOGADO", userInfo);
		session.setAttribute(
				"MENSAGEM", mensagem);		
		try {
//			response.sendRedirect(pagina);
			RequestDispatcher rd = 
					request.getRequestDispatcher(pagina);
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}		
	}

}