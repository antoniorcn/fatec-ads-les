package edu.curso;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, 
				HttpServletResponse response) {
		String user = request.getParameter("TXTUSER");
		String pass = request.getParameter("TXTPASS");
		String msg = null;
		HttpSession session = request.getSession();
		try {
			if ("convidado".equals(user) && "123456".equals(pass)) { 
				UserInfo userinfo = new UserInfo();
				userinfo.setProfile("user");
				userinfo.setNome("Antonio Rodrigues");
				userinfo.setLogado(true);
				session.setAttribute("LOGADO", userinfo);
				
//				RequestDispatcher rd = 
//						request.getRequestDispatcher("./index.jsp");
//				rd.forward(request, response);
				response.sendRedirect("./index.jsp");
			} else if ("admin".equals(user) && "password".equals(pass)) { 
				UserInfo userinfo = new UserInfo();
				userinfo.setProfile("admin");
				userinfo.setNome("Antonio Rodrigues");
				userinfo.setLogado(true);
				session.setAttribute("LOGADO", userinfo); 
				response.sendRedirect("./admin.jsp");
			} else { 
				msg = "Usuário ou senha incorretos";
				session.setAttribute("MENSAGEM", msg);
				session.setAttribute("LOGADO", null);
				response.sendRedirect("./login.jsp");
				
//				request.setAttribute("MENSAGEM", msg);
//				RequestDispatcher rd = 
//						request.getRequestDispatcher("./login.jsp");
//				rd.forward(request, response);
			}
		} catch (IOException e) {
			e.printStackTrace();
//		} catch (ServletException e) {
//			e.printStackTrace();
		}
	}

}
