package persistence;

import java.sql.SQLException;

import entity.Passagem;

public interface IPassagemDAO {
	
	public void inserirPassagem (Passagem p) throws SQLException; 
	public void atualizarPassagem(Passagem p) throws SQLException; 
	public Passagem buscarPassagem(Passagem p) throws SQLException; 

}
