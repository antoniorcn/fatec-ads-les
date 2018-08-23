package edu.curso;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MeuServlet")
public class MeuServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req,
			HttpServletResponse res){ 
		System.out.println("Servlet executado");
	}
	
}
