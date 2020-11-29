package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
	
    private Connection c;
    
    private static final String hostName = "192.168.99.100";
    private static final String dbName = "aeroporto";
    private static final String USER = "sa";
    private static final String PASS = "SqlServer19";
    
    

    public GenericDao(Connection c) {
    	
	}



	public Connection getConnection () throws ClassNotFoundException, SQLException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        
        c = DriverManager.getConnection(
                String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;", hostName, dbName, USER, PASS));
        
        return c;
    }
}