package persistence;

import java.sql.SQLException;

import entity.Login;

public interface ILoginDAO {
	
	public void inserirLogin (Login l) throws SQLException; 
	public Login buscarLogin(Login l) throws SQLException; 
	public void excluiLogin(Login l) throws SQLException;

}
