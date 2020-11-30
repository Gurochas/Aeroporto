package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.Compra;

public class CompraDAO implements ICompraDAO {
	
	private Connection c;
	
	public CompraDAO() throws ClassNotFoundException, SQLException {
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
}
