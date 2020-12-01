package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Login;

public class LoginDAO implements ILoginDAO {
	
	private Connection c;
	
	public LoginDAO() throws SQLException {
		GenericDAO gDAO = GenericDAO.getInstance();
		c = gDAO.getConnection();
	}

	@Override
	public void inserirLogin(Login l) throws SQLException {
		String sql = "INSERT INTO usuario (usuario, senha, permissao) VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, l.getUser());
		ps.setString(2, l.getPass());
		ps.setInt(3, l.getPermission());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizarLogin(Login l) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE usuario ");
		sql.append("SET usuario = ?, senha = ?, permissao = ?");
		sql.append("WHERE usuario = ?");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setString(1, l.getUser());
		ps.setString(2, l.getPass());
		ps.setInt(3, l.getPermission());

		ps.execute();
		ps.close();
	}

	@Override
	public Login buscarLogin(Login l) throws SQLException {
		String sql = "SELECT cpf, nome, sobrenome, data_nasc, email, numero, logradouro, bairro, cep FROM cliente";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		boolean verf = false; 
		if (rs.next()) {
			l.setUser(rs.getString("usuario"));
			l.setPass(rs.getString("senha"));
			l.setPermission(rs.getInt("permissao"));
			verf = true;
		}
		
		if (verf = false) {
			l = new Login();
		}
		
		rs.close();
		ps.close();
		
		return l;
	}
	
	
	

}
