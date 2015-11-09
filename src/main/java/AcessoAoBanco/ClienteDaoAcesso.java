package AcessoAoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Estado;
import br.univel.cadastroCliente.Genero;

public class ClienteDaoAcesso implements AcessoDao<Cliente> {

	private Connection conexao = ConectarBanco.getInstace().abreConexao();

	// Método inserir
	public void inserir(Cliente c) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("INSERT INTO CLIENTE (NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().name());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().name());
			ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Cliente: " + c.getNome() + "inserido com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Método atualizar
	public void atualizar(Cliente c) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("UPDATE CLIENTE SET NOME = ?,"
					+ " TELEFONE = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?,"
					+ " EMAIL = ?, GENERO = ? WHERE ID_C = " + c.getId());
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().name());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().name());
			ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Cliente" + c.getNome() + "alterado com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método excluir
	public void excluir(int id) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE ID_C =" + id);
			ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Cliente excluído com Sucesso!!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Método para buscar
	public Cliente buscar(int id) {

		Statement st = null;
		ResultSet rs = null;
		Cliente c = null;
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE WHERE ID_C = " + id);
			rs.next();
			if (rs.getString("NOME") != null) {
				c = new Cliente(rs.getString("NOME"), rs.getString("TELEFONE"),
						rs.getString("ENDERECO"), rs.getString("CIDADE"),
						Estado.valueOf(Estado.class, rs.getString("ESTADO")),
						rs.getString("EMAIL"), Genero.valueOf(Genero.class,
								rs.getString("GENERO")));
			}
			rs.close();
			st.close();
			return c;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao buscar o Cliente desejado!\n" + e.getMessage());
		}
		return null;
	}

	// Método para listar
	public List<Cliente> listar() {
		Statement st = null;
		ResultSet rs = null;

		List<Cliente>lista = new ArrayList<Cliente>();
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT ID_C, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE");
			while (rs.next()) {
				lista.add(new Cliente(rs.getInt("ID_C"), rs.getString("NOME"), rs
						.getString("TELEFONE"), rs.getString("ENDERECO"), rs
						.getString("CIDADE"), Estado.valueOf(Estado.class,
						rs.getString("ESTADO")), rs.getString("EMAIL"), Genero
						.valueOf(Genero.class, rs.getString("GENERO"))));
			}
			rs.close();
			st.close();
			if (lista != null)
				return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Connection getConexao() {
		return conexao;

	}

}
