package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Viagem;

public class ViagemDAO implements IViagemDAO{
	
	private Connection c;
	
	public ViagemDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gDAO = GenericDAO.getInstance();
		c = gDAO.getConnection();
	}

	@Override
	public void inserirViagem(Viagem v) throws SQLException {
		String sql = "INSERT INTO viente (codigo, data, hora, aviao_codigo, destino_codigo) VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, v.getCodigo());
		ps.setDate(2, java.sql.Date.valueOf(v.getData()));
		ps.setDate(3, java.sql.Date.valueOf(v.getHora()));
		ps.setInt(4, v.getAviao().getCodigo());
		ps.setInt(5, v.getDestino().getCodigo());
		ps.execute();
		ps.close();
	}

	@Override
	public Viagem buscarViagem(Viagem v) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viagem buscarViagens() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
