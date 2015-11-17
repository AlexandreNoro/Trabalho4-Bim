package AcessoAoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.cadastroCliente.Vendas;

public class VendaDaoAcesso implements AcessoDao<Vendas> {

	private Connection conexao = ConectarBanco.getInstace().abreConexao();

	public int inserir(Vendas v) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("INSERT INTO VENDA (ID_C, CLIENTE, COD_P,"
					+ " PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, v.getId_c());
			ps.setString(2, v.getCliente());
			ps.setInt(3, v.getCod_p());
			ps.setString(4, v.getProduto());
			ps.setBigDecimal(5, v.getvTotal());
			ps.setBigDecimal(6, v.getvPago());
			ps.setBigDecimal(7, v.getTroco());
			ps.setString(8, v.getData());
			ps.setString(9, v.getHora());
			int res = ps.executeUpdate();
			ps.close();
			if (v.getCod_v() == 0) {
				JOptionPane.showMessageDialog(null, "Produto " + v.getProduto() + " vendido com Sucesso");
				return res;
			} else {
				JOptionPane.showMessageDialog(null, "Venda Atualizada com Sucesso");
				return res;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public int atualizar(Vendas v) {
		return 0;
	}

	public int excluir(int idcod_v) {

		PreparedStatement ps;

		try {
			ps = conexao.prepareStatement("DELETE FROM VENDA WHERE COD_V =" + idcod_v);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Requisição de venda excluida com sucesso");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public Vendas buscar(int idcod_v) {

		Statement st = null;
		ResultSet rs = null;
		Vendas v = null;

		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT ID_C, CLIENTE, COD_P," + "PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA "
					+ "FROM venda WHERE COD_V = " + idcod_v);
			rs.next();
			if (rs.getString("ID_C") != null) {
				v = new Vendas(rs.getInt("ID_C"), rs.getInt("COD_P"), rs.getString("CLIENTE"), rs.getString("PRODUTO"),
						rs.getBigDecimal("VTOTAL"), rs.getBigDecimal("VPAGAMENTO"), rs.getBigDecimal("TROCO"),
						rs.getString("DATA"), rs.getString("HORA"));
			}
			rs.close();
			st.close();
			return v;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Vendas> listar() {

		Statement st = null;
		ResultSet rs = null;

		List<Vendas> lista = new ArrayList<Vendas>();
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT COD_V, ID_C, CLIENTE, COD_P,"
					+ "PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA FROM VENDA");
			while (rs.next()) {
				lista.add(new Vendas(rs.getInt("COD_V"), rs.getInt("ID_C"), rs.getInt("COD_P"), rs.getString("CLIENTE"),
						rs.getString("PRODUTO"), rs.getBigDecimal("VTOTAL"), rs.getBigDecimal("VPAGAMENTO"),
						rs.getBigDecimal("TROCO"), rs.getString("DATA"), rs.getString("HORA")));
			}
			rs.close();
			st.close();
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
