package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cliente;
import entity.Compra;
import entity.Passagem;

public class PassagemDAO implements IPassagemDAO{

	private Connection c;
	
	public PassagemDAO() throws ClassNotFoundException, SQLException {
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
		String sql = "UPDATE cliente"
				+ " SET codigo = ?,  = ?, preco_total = ?, portao = ?, lugar = ?, passagem_cpf = ?, codigo_viagem = ?, tipo_classe = ?, tipo_viagem"
				+ " WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getCodigo());
		ps.setDouble(2, p.getPreco_Total());
		ps.setInt(3, p.getPortao());
		ps.setInt(4, p.getLugar());
		ps.setString(5, p.getCliente().getCpf());
		ps.setInt(6, p.getViagem().getCodigo());
		ps.setString(7, p.getClasse().getTipo());
		ps.setString(8, p.getTipo_viagem().getTipo());
		ps.setInt(9, p.getCodigo());
		
		ps.execute();
		ps.close();
	}

	@Override
	public Passagem buscarPassagem(Passagem p) throws SQLException {
		
		String sql = "SELECT codigo, preco_total, portao, lugar, passagem_cpf, codigo_viagem, tipo_classe, tipo_viagem FROM Passagem WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getCodigo());
		
		boolean verf = false;
		ResultSet rs = ps.executeQuery();
		
		p.get
		
		SELECT p.codigo AS codigo_passagem, p.preco_total, p.portao, p.lugar,
		cl.preco AS classe_preco, cl.tipo AS classe_tipo,
		t.preco AS tipo_viagem_preco, t.tipo AS tipo_viagem_tipo
		FROM passagem p, cliente c, classe cl, tipo_viagem t 
		WHERE p.cliente_cpf = c.cpf 
		AND p.tipo_classe = cl.tipo
		AND p.tipo_viagem = t.tipo
		AND c.cpf = '?'
		
		
		
		if(rs.next()) {
			p.setCodigo(rs.getInt("codigo"));
			p.setPreco_Total(rs.getDouble("precototal"));
			p.setPortao(rs.getInt("portao"));
			p.setLugar(rs.getInt("lugar"));
			p.set(rs.getString("email"));
			p.setNumero(rs.getInt("numero"));
			p.setLogradouro(rs.getString("logradouro"));
			p.setBairro(rs.getString("bairro"));
			p.setCep(rs.getString("cep"));
			verf = true;
		}
		
		if (verf = false) {
			p = new Passagem();
		}
		rs.close();
		ps.close();
		return p;
	}

	@Override
	public List<Passagem> buscarPassagens(Passagem p) throws SQLException {
		List<Compra> listaCompra = new ArrayList<Compra>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.codigo AS codigo_compra, p.tipo_classe AS classe, ");
		sql.append("p.data_compra AS data_compra, p.preco_total AS valor ");
		sql.append("FROM compra co, passagem c, passagem p ");
		sql.append("WHERE c.cpf = p.cpf_passagem ");
		sql.append("AND p.codigo = p.codigo_compra ");
		sql.append("AND c.cpf = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setString(1, p.getCpf());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Compra co = new Compra();
			p.setCodigo(rs.getInt("codigo_compra"));
			p.setData_Compra(rs.getDate("data_compra").toLocalDate());
			
			p.setPassagem(p);
			listaCompra.add(co);
		}
		rs.close();
		ps.close();
		return null;
}
	}
