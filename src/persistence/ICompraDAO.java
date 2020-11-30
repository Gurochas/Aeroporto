package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Cliente;
import entity.Compra;

public interface ICompraDAO {
	
	public void inserirCompra (Compra c) throws SQLException; 
	public List<Compra> buscarComprasCliente(Cliente c) throws SQLException; 

}
