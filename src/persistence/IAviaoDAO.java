package persistence;

import java.sql.SQLException;

import entity.Aviao;

public interface IAviaoDAO {

	public void inserirAviao (Aviao a) throws SQLException; 
	public void atualizarAviao(Aviao a) throws SQLException; 
	public void excluirAviao(Aviao a) throws SQLException; 
	public Aviao buscarAviao(Aviao a) throws SQLException; 
	
}
