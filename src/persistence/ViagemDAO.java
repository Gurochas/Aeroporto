package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cliente;
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
	public Viagem buscarViagem(Viagem v) throws SQLException, ClassNotFoundException {
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT v.codigo, v.data, v.hora, v.aviao_codigo, v.destino_codigo ");
		sql.append("FROM viagem v, passagem p, cliente c ");
		sql.append("WHERE p.cliente_cpf = c.cpf ");
		sql.append("AND p.codigo_viagem = v.codigo ");
		sql.append("AND p.codigo_viagem = ? ");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		
		ps.setInt(1, v.getCodigo());
		
		ResultSet rs = ps.executeQuery();
		
		boolean verf = false;
		if(rs.next()) {
			v.setCodigo(rs.getInt("codigo"));
			v.setData(rs.getDate("data").toLocalDate());
			v.setHora(rs.getDate("hora").toLocalDate());
			
			AviaoDAO a = new AviaoDAO();
			v.getAviao().setCodigo(rs.getInt("aviao_codigo"));
			v.setAviao(a.buscarAviao(v.getAviao()));
			
			DestinoDAO d = new DestinoDAO();
			v.getDestino().setCodigo(rs.getInt("destino_codigo"));
			v.setDestino(d.buscarDestino(v.getDestino()));
			verf = true;
			
		}
		if (verf = false) {
			v = new Viagem();
		}
		
		ps.close();
		rs.close();
		
		return v;
	}

	@Override
	public List<Viagem>buscarViagens() throws SQLException, ClassNotFoundException {
		List<Viagem> listaViagem = new ArrayList<Viagem>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT v.codigo, v.data, v.hora, v.aviao_codigo, v.destino_codigo ");
		sql.append("FROM viagem v, passagem p, cliente c ");
		sql.append("WHERE p.cliente_cpf = c.cpf ");
		sql.append("AND p.codigo_viagem = v.codigo ");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		
		AviaoDAO a = new AviaoDAO();
		DestinoDAO d = new DestinoDAO();
		while(rs.next()) {
			Viagem v = new Viagem();
			v.setCodigo(rs.getInt("codigo"));
			v.setData(rs.getDate("data").toLocalDate());
			v.setHora(rs.getDate("hora").toLocalDate());
			
			v.getAviao().setCodigo(rs.getInt("aviao_codigo"));
			v.setAviao(a.buscarAviao(v.getAviao()));
			
			
			v.getDestino().setCodigo(rs.getInt("destino_codigo"));
			v.setDestino(d.buscarDestino(v.getDestino()));
			
			listaViagem.add(v);
		}

		ps.close();
		rs.close();
		
		return listaViagem;
	}
	

}
