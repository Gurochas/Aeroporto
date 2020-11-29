package persistence;

import java.sql.SQLException;

import entity.Destino;

public interface IDestinoDAO {
	
	public void inserirDestino (Destino d) throws SQLException; 
	public void atualizarDestino(Destino d) throws SQLException; 
	public void excluirDestino(Destino d) throws SQLException; 
	public Destino buscarDestino(Destino d) throws SQLException; 

}
