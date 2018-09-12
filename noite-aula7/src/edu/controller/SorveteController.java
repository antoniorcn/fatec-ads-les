package edu.controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.entidade.Sorvete;
@WebServlet("/SorveteController")
public class SorveteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SorveteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
		.append("Para acessar utilize a pagina de <a href=\"./sorvete.jsp\">sorvete</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sorvete s = new Sorvete();
		s.setSabor(request.getParameter("txtSabor"));
		s.setPreco(Float.parseFloat(request.getParameter("txtPreco")));
		s.setTipo(request.getParameter("txtTipo"));
		s.setCobertura(request.getParameter("txtCobertura"));
		
		
		List<Sorvete> lista = (List<Sorvete>) getServletContext().getAttribute("LISTA");
		if (lista != null) { 
			lista.add( s );
			System.out.println( lista.size() );
		} else { 
			lista = new Vector<Sorvete>();
			getServletContext().setAttribute("LISTA", lista);
		}
	}

}
