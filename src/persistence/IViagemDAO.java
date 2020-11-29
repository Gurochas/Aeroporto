package persistence;

import java.sql.SQLException;

import entity.Viagem;

public interface IViagemDAO {
	
	public void inserirViagem (Viagem v) throws SQLException; 
	public void atualizarViagem(Viagem v) throws SQLException; 
	public void excluirViagem(Viagem v) throws SQLException; 
	public Viagem buscarViagem(Viagem v) throws SQLException; 

}
