package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Aviao;

public interface IAviaoDAO {

	public void inserirAviao (Aviao a) throws SQLException; 
	public Aviao buscarAviao(Aviao a) throws SQLException; 
	public List<Aviao> buscarAvioes() throws SQLException; 
	
}

