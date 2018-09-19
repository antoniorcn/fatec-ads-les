package edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.entidade.Aluno;

public class AlunoDAOImpl implements AlunoDAO {
	
	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/alunos";
	private Connection con;

	public AlunoDAOImpl() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(
					JDBC_URL, "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionar(Aluno a) throws GenericDAOException { 
		String sql = "INSERT INTO aluno "
				+ "(id, ra, nome, cidade, genero) VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setLong(1, 0);
			pstm.setString(2, a.getRa());
			pstm.setString(3, a.getNome());
			pstm.setString(4, a.getCidade());
			pstm.setBoolean(5, a.isGenero());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
	}
	
	@Override
	public List<Aluno> pesquisarPorNome(String nome) throws GenericDAOException { 
		String sql = "SELECT * FROM aluno WHERE nome like ?";
		List<Aluno> alunos = new ArrayList<>();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, "%" + nome + "%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getLong("id"));
				a.setRa(rs.getString("ra"));
				a.setNome(rs.getString("nome"));
				a.setCidade(rs.getString("cidade"));
				a.setGenero(rs.getBoolean("genero"));
				alunos.add(a);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return alunos;
	}

}
