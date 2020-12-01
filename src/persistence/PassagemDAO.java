package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Passagem;

public class PassagemDAO implements IPassagemDAO {

	private Connection c;

	public PassagemDAO() throws SQLException {
		GenericDAO gDAO = GenericDAO.getInstance();
		c = gDAO.getConnection();
	}

	@Override
	public void inserirPassagem(Passagem p) throws SQLException {
		String sql = "INSERT INTO passagem (codigo, preco_total, portao, lugar, passagem_cpf, codigo_viagem, tipo_classe, tipo_viagem) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getCodigo());
		ps.setDouble(2, p.getPreco_Total());
		ps.setInt(3, p.getPortao());
		ps.setInt(4, p.getLugar());
		ps.setString(5, p.getCliente().getCpf());
		ps.setInt(6, p.getViagem().getCodigo());
		ps.setString(7, p.getClasse().getTipo());
		ps.setString(8, p.getTipo_viagem().getTipo());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizarPassagem(Passagem p) throws SQLException {

		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE passagem ");
		sql.append("SET codigo = ?, preco_total = ?, portao = ?, lugar = ?, cliente_cpf = ?, codigo_viagem = ?, tipo_classe = ?, tipo_viagem = ?, codigo_compra = ? ");
		sql.append("WHERE codigo = ?");

		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, p.getCodigo());
		ps.setDouble(2, p.getPreco_Total());
		ps.setInt(3, p.getPortao());
		ps.setInt(4, p.getLugar());
		ps.setString(5, p.getCliente().getCpf());
		ps.setInt(6, p.getViagem().getCodigo());
		ps.setString(7, p.getClasse().getTipo());
		ps.setString(8, p.getTipo_viagem().getTipo());
		ps.setInt(9, p.getCompra().getCodigo());

		ps.execute();
		ps.close();
	}

	@Override
	public Passagem buscarPassagem(Passagem p) throws SQLException {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.codigo AS codigo_passagem, p.preco_total, p.portao, p.lugar, ");
		sql.append("cl.preco AS classe_preco, cl.tipo AS classe_tipo, ");
		sql.append("t.preco AS tipo_viagem_preco, t.tipo AS tipo_viagem_tipo, ");
		sql.append("codigo_viagem, codigo_compra ");
		sql.append("FROM passagem p, cliente c, classe cl, tipo_viagem t ");
		sql.append("WHERE p.cliente_cpf = c.cpf ");
		sql.append("AND p.tipo_classe = cl.tipo ");
		sql.append("AND p.tipo_viagem = t.tipo ");
		sql.append("AND c.cpf = '?' ");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setString(1, p.getCliente().getCpf());
		
		ResultSet rs = ps.executeQuery();
		
		boolean verf = false;
		if(rs.next()) {
			
			//Passagem 
			p.setCodigo(rs.getInt("codigo_passagem"));
			p.setPreco_Total(rs.getDouble("preco_total"));
			p.setPortao(rs.getInt("portao"));
			p.setLugar(rs.getInt("lugar"));
			
			//Classe
			p.getClasse().setPreco(rs.getDouble("classe_preco"));
			p.getClasse().setTipo(rs.getString("classe_tipo"));
			
			//Tipo Viagem
			p.getTipo_viagem().setPreco(rs.getDouble("tipo_viagem_preco"));
			p.getTipo_viagem().setTipo(rs.getString("tipo_viagem_tipo"));
			
			ViagemDAO v = new ViagemDAO();
			p.getViagem().setCodigo(rs.getInt("codigo_viagem"));
			p.setViagem(v.buscarViagem(p.getViagem()));
			
			CompraDAO c = new CompraDAO();
			p.getCompra().setCodigo(rs.getInt("codigo_compra"));
			p.setCompra(c.buscarCompra(p.getCompra()));
			
			verf = true;
			
		}
		if (verf = false) {
			p = new Passagem();
		}
		ps.close();
		rs.close();
		return p;
	}

	@Override
	public List<Passagem> buscarPassagens(Passagem p) throws SQLException {
		
		List<Passagem> listaPassagens = new ArrayList<Passagem>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.codigo AS codigo_passagem, p.preco_total, p.portao, p.lugar, ");
		sql.append("cl.preco AS classe_preco, cl.tipo AS classe_tipo, ");
		sql.append("t.preco AS tipo_viagem_preco, t.tipo AS tipo_viagem_tipo, ");
		sql.append("codigo_viagem, codigo_compra ");
		sql.append("FROM passagem p, cliente c, classe cl, tipo_viagem t ");
		sql.append("WHERE p.cliente_cpf = c.cpf ");
		sql.append("AND p.tipo_classe = cl.tipo ");
		sql.append("AND p.tipo_viagem = t.tipo ");
		sql.append("AND c.cpf = '?' ");
		
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setString(1, p.getCliente().getCpf());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			//Passagem 
			p.setCodigo(rs.getInt("codigo_passagem"));
			p.setPreco_Total(rs.getDouble("preco_total"));
			p.setPortao(rs.getInt("portao"));
			p.setLugar(rs.getInt("lugar"));
			
			//Classe
			p.getClasse().setPreco(rs.getDouble("classe_preco"));
			p.getClasse().setTipo(rs.getString("classe_tipo"));
			
			//Tipo Viagem
			p.getTipo_viagem().setPreco(rs.getDouble("tipo_viagem_preco"));
			p.getTipo_viagem().setTipo(rs.getString("tipo_viagem_tipo"));
			
			ViagemDAO v = new ViagemDAO();
			p.getViagem().setCodigo(rs.getInt("codigo_viagem"));
			p.setViagem(v.buscarViagem(p.getViagem()));
			
			CompraDAO c = new CompraDAO();
			p.getCompra().setCodigo(rs.getInt("codigo_compra"));
			p.setCompra(c.buscarCompra(p.getCompra()));

			listaPassagens.add(p);
			
		}
		
		ps.close();
		rs.close();

		return listaPassagens;
	}
}
