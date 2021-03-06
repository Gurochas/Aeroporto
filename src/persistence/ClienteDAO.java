package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cliente;
import entity.Login;

public class ClienteDAO implements IClienteDAO {
	
	private Connection c;
	
	public ClienteDAO() throws SQLException {
		GenericDAO gDAO = GenericDAO.getInstance();
		c = gDAO.getConnection();
	}

	@Override
	public void inserirCliente(Cliente cl) throws SQLException {
		String sql = "INSERT INTO cliente (cpf, nome, sobrenome, data_nasc, email, numero, logradouro, bairro, cep) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cl.getCpf());
		ps.setString(2, cl.getNome());
		ps.setString(3, cl.getSobrenome());
		ps.setDate(4, java.sql.Date.valueOf(cl.getData_Nasc()));
		ps.setString(5, cl.getEmail());
		ps.setInt(6, cl.getNumero());
		ps.setString(7, cl.getLogradouro());
		ps.setString(8, cl.getBairro());
		ps.setString(9, cl.getCep());
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizarCliente(Cliente cl) throws SQLException {
		String sql = "UPDATE cliente"
				+ " SET cpf = ?, nome = ?, sobrenome = ?, data_nasc = ?, email = ?, numero = ?, logradouro = ?, bairro = ?, cep = ?"
				+ " WHERE cpf = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cl.getCpf());
		ps.setString(2, cl.getNome());
		ps.setString(3, cl.getSobrenome());
		ps.setDate(4, java.sql.Date.valueOf(cl.getData_Nasc()));
		ps.setString(5, cl.getEmail());
		ps.setInt(6, cl.getNumero());
		ps.setString(7, cl.getLogradouro());
		ps.setString(8, cl.getBairro());
		ps.setString(9, cl.getCep());
		ps.setString(10, cl.getCpf());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluirCliente(Cliente cl) throws SQLException {
		String sql = "DELETE cliente WHERE cpf = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cl.getCpf());
		ps.execute();
		ps.close();
	}

	@Override
	public Cliente buscarCliente(Cliente cl) throws SQLException {
		
		String sql = "SELECT cpf, nome, sobrenome, data_nasc, email, numero, logradouro, bairro, cep FROM cliente WHERE email = ? ";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cl.getEmail());
		ResultSet rs = ps.executeQuery();
		
		boolean verf = false;
		if(rs.next()) {
			cl.setCpf(rs.getString("cpf"));
			cl.setNome(rs.getString("nome"));
			cl.setSobrenome(rs.getString("sobrenome"));
			cl.setData_Nasc(rs.getDate("data_nasc").toLocalDate());
			cl.setEmail(rs.getString("email"));
			cl.setNumero(rs.getInt("numero"));
			cl.setLogradouro(rs.getString("logradouro"));
			cl.setBairro(rs.getString("bairro"));
			cl.setCep(rs.getString("cep"));
			
			LoginDAO loginDAO = new LoginDAO();
			cl.setLogin(new Login());
			cl.getLogin().setUser(rs.getString("email"));
			cl.setLogin(loginDAO.buscarLogin(cl.getLogin()));
			
			verf = true;
		}
		
		if (!verf) {
			cl = null;
		}
		rs.close();
		ps.close();
		return cl;
	}

	@Override
	public List<Cliente> buscarClientes() throws SQLException {

		List<Cliente> listaCliente = new ArrayList<Cliente>();
		String sql = "SELECT cpf, nome, sobrenome, data_nasc, email, numero, logradouro, bairro, cep FROM cliente";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		LoginDAO loginDAO = new LoginDAO();
		
		while (rs.next()) {
			Cliente cl = new Cliente();
			cl.setCpf(rs.getString("cpf"));
			cl.setNome(rs.getString("nome"));
			cl.setSobrenome(rs.getString("sobrenome"));
			cl.setData_Nasc(rs.getDate("nascimento").toLocalDate());
			cl.setEmail(rs.getString("email"));
			cl.setNumero(rs.getInt("numero"));
			cl.setLogradouro(rs.getString("logradouro"));
			cl.setBairro(rs.getString("bairro"));
			cl.setCep(rs.getString("cep"));
			
			cl.setLogin(new Login());
			cl.getLogin().setUser(rs.getString("email"));
			cl.setLogin(loginDAO.buscarLogin(cl.getLogin()));
			
			listaCliente.add(cl);
		}
		
		rs.close();
		ps.close();

		return listaCliente;
	}

}
