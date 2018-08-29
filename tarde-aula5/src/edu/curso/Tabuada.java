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
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String textoDoNumero = request.getParameter("NUMERO");
		if(textoDoNumero == null) { 
			textoDoNumero = "7";
		}
		int num = Integer.parseInt(textoDoNumero);
		for (int i = 1; i <= 10; i++) { 
			out.println("<h3>" + num + " X " + i 
					+ " = " + (i * num) + "</h3>");
		}
		out.flush();
	}
}
