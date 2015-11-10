package AcessoAoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import br.univel.cadastroCliente.Produto;

public class ProdutoDaoAcesso implements AcessoDao<Produto> {

	private Connection conexao = ConectarBanco.getInstace().abreConexao();

	public void inserir(Produto pd) {
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(
					"INSERT INTO PRODUTO (COD_BARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGE_LUCRO) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, pd.getCodbarra());
			ps.setString(2, pd.getCategoria());
			ps.setString(3, pd.getDescricao());
			ps.setString(4, pd.getUnidade());
			ps.setBigDecimal(5, pd.getCusto());
			ps.setBigDecimal(6, pd.getMargemlucro());
			ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Produto: " + pd.getDescricao() + " inserido com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizar(Produto p) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("UPDATE PRODUTO SET COD_BARRA = ?, CATEGORIA = ?, DESCRICAO = ?,"
					+ " UNIDADE = ?, CUSTO = ?, MARGE_LUCRO = ? WHERE COD_P = " + p.getcod_p());
			ps.setInt(1, p.getCodbarra());
			ps.setString(2, p.getCategoria());
			ps.setString(3, p.getDescricao());
			ps.setString(4, p.getUnidade());
			ps.setBigDecimal(5, p.getCusto());
			ps.setBigDecimal(6, p.getMargemlucro());
			ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Produto: " + p.getDescricao() + " alterado com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(int id_p) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("DELETE FROM PRODUTO WHERE COD_P =" + id_p);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Produto buscar(int id_p) {
		Statement st = null;
		ResultSet rs = null;
		Produto p = null;
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT COD_BARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGE_LUCRO "
					+ "FROM PRODUTO WHERE COD_P = " + id_p);
			rs.next();
			if (rs.getString("NOME") != null) {
				p = new Produto(id_p, rs.getInt("COD_BARRA"), rs.getString("CATEGORIA"), rs.getString("DESCRICAO"),
						rs.getString("UNIDADE"), rs.getBigDecimal("CUSTO"), rs.getBigDecimal("MARGE_LUCRO"));
			}
			rs.close();
			st.close();
			return p;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o Produto desejado!\n" + e.getMessage());
		}
		return null;
	}

	public List<Produto> listar() {

		Statement st = null;
		ResultSet rs = null;

		ArrayList<Produto> lista = new ArrayList<Produto>();

		try {
			st = conexao.createStatement();
			rs = st.executeQuery(
					"SELECT COD_P, COD_BARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGE_LUCRO " + "FROM PRODUTO");
			while (rs.next()) {
				lista.add(new Produto(rs.getInt("COD_P"), rs.getInt("COD_BARRA"), rs.getString("CATEGORIA"),
						rs.getString("DESCRICAO"), rs.getString("UNIDADE"), rs.getBigDecimal("CUSTO"),
						rs.getBigDecimal("MARGE_LUCRO")));
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
