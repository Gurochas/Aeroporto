package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Compra;
import entity.Login;

public class CompraDAO implements ICompraDAO {
	
	private Connection c;
	
	public CompraDAO() throws SQLException {
		GenericDAO gDAO = GenericDAO.getInstance();
		c = gDAO.getConnection();
	}

	@Override 
	public void inserirCompra(Compra co) throws SQLException {
		String sql = "INSERT INTO compra (codigo, data_compra, cpf_cliente) VALUES (?,?,?)"; 
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, co.getCodigo());
		ps.setDate(2, java.sql.Date.valueOf(co.getData_Compra()));
		ps.setString(3, co.getCliente().getCpf());
		ps.execute();
		ps.close();
	}

	@Override
	public Compra buscarCompra(Compra co) throws SQLException {
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT codigo, data_compra ");
		sql.append("FROM compra ");
		sql.append("WHERE codigo = ?");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, co.getCodigo());
		ResultSet rs = ps.executeQuery();
		
		boolean verf = false; 
		if (rs.next()) {
			co.setCodigo(rs.getInt("codigo"));
			co.setData_Compra(rs.getDate("data_compra").toLocalDate());
			verf = true;
		}
		
		if (verf = false) {
			co = new Compra();
		}
		
		rs.close();
		ps.close();
		
		return co;
	}
}