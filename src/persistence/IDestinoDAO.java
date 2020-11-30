package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Destino;

public interface IDestinoDAO {
	
	public void inserirDestino (Destino d) throws SQLException; 
	public Destino buscarDestino(Destino d) throws SQLException; 
	public List<Destino> buscarDestinos() throws SQLException; 
	
}
