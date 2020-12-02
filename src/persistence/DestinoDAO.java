package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Destino;

public class DestinoDAO implements IDestinoDAO{

private Connection c;
	
	public DestinoDAO() throws SQLException {
		GenericDAO gDAO = GenericDAO.getInstance();
		c = gDAO.getConnection();
	}
	
	
	@Override
	public void inserirDestino(Destino d) throws SQLException {
		String sql = "INSERT INTO Destino (destino, preco) VALUES (?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, d.getDestino());
		ps.setDouble(2, d.getPreco());
		ps.execute();
		ps.close();		
	}

	@Override
	public Destino buscarDestino(Destino d) throws SQLException {
		
		String sql = "SELECT codigo, destino, preco FROM destino WHERE codigo = '?'";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, d.getCodigo());
		
		boolean verf = false;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			d.setCodigo(rs.getInt("codigo"));
			d.setDestino(rs.getString("destino"));
			d.setPreco(rs.getDouble("preco"));
			verf = true;
		}
		
		if (verf = false) {
			d = new Destino();
		}
		rs.close();
		ps.close();
		return d;
	}

	@Override
	public List<Destino> buscarDestinos() throws SQLException {
		List<Destino> listaDestinos = new ArrayList<Destino>();
		String sql = "SELECT codigo, destino, preco FROM destino ORDER BY destino";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Destino d = new Destino();
			d.setCodigo(rs.getInt("codigo"));
			d.setDestino(rs.getString("destino"));
			d.setPreco(rs.getDouble("preco"));
			
			listaDestinos.add(d);
		}
		
		rs.close();
		ps.close();
		return listaDestinos;
		
	}

}
