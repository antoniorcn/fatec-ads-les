package edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String cmd = request.getParameter("cmd");
		String msg = null;
		AlunoDAO aDao = new AlunoDAOImpl();
		HttpSession session = request.getSession();
		if ("adicionar".equals(cmd)) {
			Aluno a = new Aluno();
			a.setNome(request.getParameter("alunoNome"));
			a.setRa(request.getParameter("alunoRA"));
			a.setCidade(request.getParameter("alunoCidade"));
			a.setGenero("masc".equals(request.getParameter("alunoGenero")));
			try {
				aDao.adicionar(a);
				msg = "Aluno adicionado com sucesso";
			} catch (GenericDAOException e) {
				e.printStackTrace();
			}
			
		} else if ("pesquisar".equals(cmd)) {
			try {
				List<Aluno> lista = aDao.pesquisarPorNome(
					request.getParameter("alunoNome"));
				session.setAttribute("ALUNOS", lista);
				msg = "Foram encontrados " + 
							lista.size() + " alunos";
			} catch (GenericDAOException e) {
				e.printStackTrace();
			}
			
		}
		session.setAttribute("MENSAGEM", msg);		
		response.sendRedirect("./alunos.jsp");
	}

}
