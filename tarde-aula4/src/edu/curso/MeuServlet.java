package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/meuservlet")
public class MeuServlet extends HttpServlet {
	@Override
	public void destroy() {
		System.out.println("Instância sendo destruida");
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public String getServletInfo() {
		return null;
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Foi criada uma instância do servlet");
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter(); 
		res.setContentType("text/html");
		out.println("<h1>Codigo do servlet sendo executado</h1>");
		out.println("<h2>Voce acessou pela URL " + req.getRequestURL() + "</h2>");
		Calendar cal = Calendar.getInstance();
		out.println(cal.getTime());
		out.flush();
 	}

}
