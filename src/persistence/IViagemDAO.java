package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Viagem;

public interface IViagemDAO {
	
	public void inserirViagem (Viagem v) throws SQLException; 
	public Viagem buscarViagem(Viagem v) throws SQLException, ClassNotFoundException; 
	public List<Viagem> buscarViagens() throws SQLException, ClassNotFoundException; 

}
