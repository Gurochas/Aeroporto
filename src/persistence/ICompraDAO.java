package persistence;

import java.sql.SQLException;

import entity.Compra;

public interface ICompraDAO {
	
	public void inserirCompra (Compra c) throws SQLException; 
	public void atualizarCompra(Compra c) throws SQLException; 
	public void excluirCompra(Compra c) throws SQLException; 
	public Compra buscarCompra(Compra c) throws SQLException; 

}
