package edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.entidade.Sorvete;

public class SorveteDAOImpl implements SorveteDAO {

	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/sorveteria";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;

	public SorveteDAOImpl() throws GenericDAOException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e) {
			throw new GenericDAOException( e );
		}
	}

	@Override
	public void adicionar(Sorvete s) throws GenericDAOException {
		String sql = "INSERT INTO sorvetes (id, sabor, tipo, cobertura, preco, imagem) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, 0);
			pstmt.setString(2, s.getSabor());
			pstmt.setString(3, s.getTipo());
			pstmt.setString(4, s.getCobertura());
			pstmt.setFloat(5, s.getPreco());
			pstmt.setString(6, s.getImagem());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
	}

	@Override
	public List<Sorvete> presquisarPorSabor(String sabor) throws GenericDAOException {
		List<Sorvete> lista = new ArrayList<>();
		String sql = "SELECT * FROM sorvetes WHERE sabor like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + sabor + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) { 
				Sorvete s = new Sorvete();
				s.setId(rs.getLong("id"));
				s.setSabor(rs.getString("sabor"));
				s.setTipo(rs.getString("tipo"));
				s.setCobertura(rs.getString("cobertura"));
				s.setPreco(rs.getFloat("preco"));
				s.setImagem(rs.getString("imagem"));
				lista.add( s );
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return lista;
	}

	@Override
	public void remover(long id) throws GenericDAOException {
		String sql = "DELETE FROM sorvetes WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
	}

	@Override
	public Sorvete pesquisarPorId(long id) throws GenericDAOException {
		Sorvete s = new Sorvete();
		String sql = "SELECT * FROM sorvetes WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				s.setId(rs.getLong("id"));
				s.setSabor(rs.getString("sabor"));
				s.setTipo(rs.getString("tipo"));
				s.setCobertura(rs.getString("cobertura"));
				s.setPreco(rs.getFloat("preco"));
				s.setImagem(rs.getString("imagem"));
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return s;
	}

	@Override
	public void salvar(long id, Sorvete s) throws GenericDAOException {
		String sql = "UPDATE sorvetes SET sabor = ?, tipo = ?, cobertura = ?, preco = ?, imagem = ? "
				+ "WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getSabor());
			pstmt.setString(2, s.getTipo());
			pstmt.setString(3, s.getCobertura());
			pstmt.setFloat(4, s.getPreco());
			pstmt.setString(5, s.getImagem());
			pstmt.setLong(6, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
	}

}
