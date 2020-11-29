package persistence;

import java.sql.SQLException;

import entity.Cliente;

public interface IClienteDAO {
	
	public void inserirCliente (Cliente cl) throws SQLException; 
	public void atualizarCliente(Cliente cl) throws SQLException; 
	public void excluirCliente(Cliente cl) throws SQLException; 
	public Cliente buscarCliente(Cliente cl) throws SQLException; 

}
