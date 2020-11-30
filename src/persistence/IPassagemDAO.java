package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Passagem;

public interface IPassagemDAO {
	
	public void inserirPassagem (Passagem p) throws SQLException; 
	public void atualizarPassagem(Passagem p) throws SQLException; 
	public Passagem buscarPassagem(Passagem p) throws SQLException, ClassNotFoundException; 
	public List<Passagem> buscarPassagens(Passagem p) throws SQLException, ClassNotFoundException;

}
