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
	
	public AviaoDAO() throws SQLException {
		GenericDAO gDAO = GenericDAO.getInstance();
		c = gDAO.getConnection();
	}

	@Override
	public void inserirAviao(Aviao a) throws SQLException {
		String sql = "INSERT INTO aviao (empresa, modelo, qtd_lugares, preco) VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getEmpresa());
		ps.setString(2, a.getModelo());
		ps.setInt(3, a.getQtd_lugares());
		ps.setDouble(4, a.getPreco());
		ps.execute();
		ps.close();
	}


	@Override
	public Aviao buscarAviao(Aviao a) throws SQLException {
		
		String sql = "SELECT codigo, empresa, modelo, qtd_lugares, preco FROM aviao WHERE codigo = ?";
		
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
		String sql = "SELECT codigo, empresa, modelo, qtd_lugares, preco, qtd_lugares FROM aviao ORDER BY empresa";
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
