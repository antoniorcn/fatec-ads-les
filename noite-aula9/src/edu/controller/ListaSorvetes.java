package edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.dao.GenericDAOException;
import edu.dao.SorveteDAO;
import edu.dao.SorveteDAOImpl;
import edu.entidade.Sorvete;

/**
 * Servlet implementation class ListaSorvetes
 */
@WebServlet("/ListaSorvetes")
public class ListaSorvetes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListaSorvetes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SorveteDAO sDao = new SorveteDAOImpl();
			List<Sorvete> lista = sDao.presquisarPorSabor("");
			Gson gson = new Gson();
			String listaJSon = gson.toJson(lista);
			System.out.println(listaJSon);
			response.setContentType("application/json");
			response.getWriter().println(listaJSon);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
	}

}
