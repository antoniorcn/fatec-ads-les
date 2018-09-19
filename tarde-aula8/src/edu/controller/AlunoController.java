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
				List<Aluno> lista = aDao.pesquisarPorNome("");
				session.setAttribute("ALUNOS", lista);
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
		} else if ("remover".equals(cmd)) {
			String id  = request.getParameter("alunoId");
			try {
				aDao.remover( Long.parseLong(id) );
				List<Aluno> lista = aDao.pesquisarPorNome("");
				session.setAttribute("ALUNOS", lista);
				msg = "Aluno com id " + id + " foi removido";
			} catch (NumberFormatException | GenericDAOException e) {
				msg = "Erro ao remover o aluno com id " + id;
				e.printStackTrace();
			}
		} else if ("atualizar".equals(cmd)) {
			String id  = request.getParameter("alunoId");
			try {
				Aluno a = aDao.pesquisarPorId( Long.parseLong(id) );
				session.setAttribute("ALUNO_ATUAL", a);
				msg = "Aluno com id " + id + " foi carregado";
			} catch (NumberFormatException | GenericDAOException e) {
				msg = "Erro ao carregar o aluno com id " + id;
				e.printStackTrace();
			}
		} else if ("salvar".equals(cmd)) {
			String id  = request.getParameter("alunoId");
			try {
				Aluno a = new Aluno();
				a.setNome(request.getParameter("alunoNome"));
				a.setRa(request.getParameter("alunoRA"));
				a.setCidade(request.getParameter("alunoCidade"));
				a.setGenero("masc".equals(request.getParameter("alunoGenero")));
				aDao.salvar( Long.parseLong(id), a);
				msg = "Aluno com id " + id + " foi atualizado no banco de dados";
				List<Aluno> lista = aDao.pesquisarPorNome("");
				session.setAttribute("ALUNOS", lista);
			} catch (NumberFormatException | GenericDAOException e) {
				msg = "Erro ao atualizar o aluno com id " + id;
				e.printStackTrace();
			}
		}				
		session.setAttribute("MENSAGEM", msg);		
		response.sendRedirect("./alunos.jsp");
	}

}
