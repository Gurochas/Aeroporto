package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Aviao;

public class AviaoDAO implements IAviaoDAO {
	
	private Connection c;
	
	public AviaoDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gDAO = GenericDAO.getInstance();
		c = gDAO.getConnection();
	}

	@Override
	public void inserirAviao(Aviao a) throws SQLException {
		String sql = "INSERT INTO Aviao (codigo, empresa, modelo, qtd_lugares, preco, lugares) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, a.getCodigo());
		ps.setString(2, a.getEmpresa());
		ps.setString(3, a.getModelo());
		ps.setInt(5, a.getQtd_lugares());
		ps.setDouble(6, a.getPreco());
		ps.execute();
		ps.close();
	}


	@Override
	public Aviao buscarAviao(Aviao a) throws SQLException {
		
		String sql = "SELECT codigo, empresa, modelo, qtd_lugares, preco, lugares FROM Aviao WHERE codigo = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, a.getCodigo());
		
		boolean verf = false;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			a.setCodigo(rs.getInt("codigo"));
			a.setEmpresa(rs.getString("empresa"));
			a.setModelo(rs.getString("modelo"));
			a.setQtd_lugares(rs.getInt("qtd_lugares"));
			a.setPreco(rs.getDouble("preco"));
			verf = true;
		}
		
		if (verf = false) {
			a = new Aviao();
		}
		rs.close();
		ps.close();
		return a;
	}

	@Override
	public List<Aviao> buscarAvioes() throws SQLException {

		List<Aviao> listaAviao = new ArrayList<Aviao>();
		String sql = "SELECT codigo, empresa, modelo, qtd_lugares, preco, lugares FROM Aviao";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aviao a = new Aviao();
			a.setCodigo(rs.getInt("codigo"));
			a.setEmpresa(rs.getString("empresa"));
			a.setModelo(rs.getString("modelo"));
			a.setQtd_lugares(rs.getInt("qtd_lugares"));
			a.setPreco(rs.getDouble("preco"));
			
			listaAviao.add(a);
		}
		
		rs.close();
		ps.close();

		return listaAviao;
	}
}
