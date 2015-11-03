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

	@Override
	public void inserir(Produto p) {
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(
					"INSERT INTO PRODUTO(CODBARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGEMLUCRO) VALUES (?, ?, ?, ?, ?)");

			ps.setInt(1, p.getCodbarra());
			ps.setString(2, p.getCategoria());
			ps.setString(3, p.getDescricao());
			ps.setString(4, p.getUnidade());
			ps.setBigDecimal(5, p.getCusto());
			ps.setBigDecimal(6, p.getMargemlucro());

			ps.executeUpdate();

			ps.close();

			JOptionPane.showMessageDialog(null, "Produto: " + p.getDescricao() + "inserido com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Produto p) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(
					"UPDATE PRODUTO SET CODBARRA = ?,CATEGORIA = ?,DESCRICAO = ?,UNIDADE = ?, CUSTO = ?, MARGEMLUCRO = ?  WHERE IDCOD_P ="
							+ p.getIdcod());

			ps.setInt(1, p.getCodbarra());
			ps.setString(2, p.getCategoria());
			ps.setString(3, p.getDescricao());
			ps.setString(4, p.getUnidade());
			ps.setBigDecimal(5, p.getCusto());

			ps.setBigDecimal(8, p.getMargemlucro());

			ps.executeUpdate();

			ps.close();

			JOptionPane.showMessageDialog(null, "Produto" + p.getDescricao() + "alterado com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(int id_p) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("DELETE FROM PRODUTO WHERE IDCOD_C =" + id_p);

			ps.executeUpdate();

			ps.close();

			JOptionPane.showMessageDialog(null, "Produto exclu�do com Sucesso!!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public Produto buscar(int id_p) {
		Statement st = null;
		ResultSet rs = null;
		Produto p = null;
		try {
			st = conexao.createStatement();
			rs = st.executeQuery(
					"SELECT CODBARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGEMLUCRO FROM PRODUTO WHERE IDCOD_P ="
							+ id_p);
			rs.next();
			if (rs.getString("NOME") != null) {
				p = new Produto(id_p, rs.getInt("CODBARRA"), rs.getString("CATEGORIA"), rs.getString("DESCRICAO"),
						rs.getString("UNIDADE"), rs.getBigDecimal("CUSTO"), rs.getBigDecimal("MARGEMLUCRO"));
			}
			rs.close();
			st.close();
			return p;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao buscar o " + "Produto desejado!\n" + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Produto> listar() {

		Statement st = null;
		ResultSet rs = null;
		Produto p = null;

		ArrayList<Produto> lista = new ArrayList<Produto>();

		try {
			st = conexao.createStatement();
			rs = st.executeQuery(
					"SELECT IDCOD_P, CODBARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGEMLUCRO " + "FROM PRODUTO");
			while (rs.next()) {
				lista.add(p = new Produto(rs.getInt("IDCOD_P"), rs.getInt("CODBARRA"), rs.getString("CATEGORIA"),
						rs.getString("DESCRICAO"), rs.getString("UNIDADE"), rs.getBigDecimal("CUSTO"),
						rs.getBigDecimal("MARGEMLUCRO")));
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