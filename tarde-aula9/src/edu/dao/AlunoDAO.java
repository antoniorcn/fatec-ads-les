package edu.dao;

import java.util.List;

import edu.entidade.Aluno;

public interface AlunoDAO {
	void adicionar(Aluno a) throws GenericDAOException;
	List<Aluno> pesquisarPorNome(String nome) throws GenericDAOException;
	void remover(long id) throws GenericDAOException;
	Aluno pesquisarPorId(long id) throws GenericDAOException;
	void salvar(long id, Aluno a) throws GenericDAOException;
}
