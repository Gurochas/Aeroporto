package persistence;

import java.sql.SQLException;

import entity.Compra;

public interface ICompraDAO {
	
	public void inserirCompra (Compra co) throws SQLException; 
}
