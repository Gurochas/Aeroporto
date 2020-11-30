package persistence;

import java.sql.SQLException;

import entity.Viagem;

public interface IViagemDAO {
	
	public void inserirViagem (Viagem v) throws SQLException; 
	public Viagem buscarViagem(Viagem v) throws SQLException; 
	public Viagem buscarViagens() throws SQLException; 

}
