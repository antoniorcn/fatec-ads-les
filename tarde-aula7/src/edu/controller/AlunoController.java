package edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dao.AlunoDAO;
import edu.dao.AlunoDAOImpl;
import edu.dao.GenericDAOException;
import edu.entidade.Aluno;

@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlunoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
			.append("O acesso deve ser feito pelo formulario <a href=\"./aluno.jsp\">aluno</a> ")
			.append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aluno a = new Aluno();
		a.setNome(request.getParameter("alunoNome"));
		a.setRa(request.getParameter("alunoRA"));
		a.setCidade(request.getParameter("alunoCidade"));
//		String genero = request.getParameter("alunoGenero");
//		if ("masc".equals(genero)) { 
//			a.setGenero(true);
//		} else { 
//			a.setGenero(false);
//		}
		a.setGenero("masc".equals(request.getParameter("alunoGenero")));
		AlunoDAO aDao = new AlunoDAOImpl();
		try {
			aDao.adicionar(a);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
	}

}
