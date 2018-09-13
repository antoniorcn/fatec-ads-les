package edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dao.GenericDAOException;
import edu.dao.SorveteDAO;
import edu.dao.SorveteDAOImpl;
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
		
		
		try {
			SorveteDAO sDao = new SorveteDAOImpl();
			sDao.adicionar( s );
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
		
//		List<Sorvete> lista = (List<Sorvete>) getServletContext().getAttribute("LISTA");
//		if (lista == null) { 
//			lista = new Vector<Sorvete>();
//			getServletContext().setAttribute("LISTA", lista);
//		}
//		lista.add( s );
//		System.out.println( lista.size() );
	}

}
