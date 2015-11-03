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
	@Override
	public void inserir(Cliente c) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(
					"INSERT INTO CLIENTE(NOME,ENDERECO,TELEFONE,CIDADE,ESTADO,GENERO,EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, c.getNome());
			ps.setString(2, c.getEndereco());
			ps.setString(3, c.getTelefone());
			ps.setString(4, c.getCidade());
			ps.setObject(5, c.getEstado().getNome());
			ps.setObject(6, c.getGenero().getNome());
			ps.setString(7, c.getEmail());

			ps.executeUpdate();

			ps.close();

			JOptionPane.showInternalMessageDialog(null, "Cliente: " + c.getNome() + "inserido com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Método atualizar
	@Override
	public void atualizar(Cliente c) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(
					"UPDATE CLIENTE SET NOME = ?,ENDERECO = ?,TELEFONE = ?,ESTADO = ?,GENERO = ?, EMAIL = ?  WHERE IDCOD_C ="
							+ c.getId());

			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome() + "");
			ps.setString(3, c.getEndereco() + "");
			ps.setString(4, c.getTelefone() + "");
			ps.setString(5, c.getCidade() + "");
			ps.setObject(6, c.getEstado().name() + "");
			ps.setObject(7, c.getGenero().name() + "");
			ps.setString(8, c.getEmail() + "");

			ps.executeUpdate();

			ps.close();

			JOptionPane.showMessageDialog(null, "Cliente" + c.getNome() + "alterado com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método excluir
	@Override
	public void excluir(int id) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE IDCOD_C =" + id);

			ps.executeUpdate();

			ps.close();

			JOptionPane.showMessageDialog(null, "Cliente excluído com Sucesso!!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Método para buscar
	@Override
	public Cliente buscar(int id) {

		Statement st = null;
		ResultSet rs = null;
		Cliente c = null;
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE WHERE IDCOD_C = " + id);
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
	@Override
	public List<Cliente> listar() {

		Cliente c = null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT IDCOD_C, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE");
			while (rs.next()) {
				lista.add(c = new Cliente(rs.getInt("IDCOD_C"), rs.getString("NOME"), rs
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
