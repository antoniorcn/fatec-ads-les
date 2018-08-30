package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Tabuada")
public class Tabuada extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Tabuada() {
        super();
    }
	protected void doGet(HttpServletRequest request, 
				HttpServletResponse response) 
						throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String txtNum = request.getParameter("NUMERO");
		if (txtNum == null) { 
			txtNum = "7";
		}
		response.setContentType("text/html");
		int num = Integer.parseInt(txtNum);
		for (int i = 1; i <= 10; i++) { 
			out.println("<h3>" + num + " X " + 
							i + " = " + (num * i) + "</h3>");
		}
		out.println("<a href=\"./tabuada.jsp\">Voltar</a>");
		out.flush();
	}
}
