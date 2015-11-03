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

	@Override
	public void inserir(Vendas v) {

		PreparedStatement ps;

		try {
			ps = conexao.prepareStatement("INSERT INTO VENDA (IDCOD_C, CLIENTE, IDCOD_P,"
					+ " PRODUTO, VLRTOTAL, VLRPAGO, TROCO, DATACOMPRA, HORACOMPRA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, v.getIdcod_c());
			ps.setString(2, v.getCliente());
			ps.setInt(3, v.getIdcod_preco());
			ps.setString(4, v.getProduto());
			ps.setBigDecimal(5, v.getVlrtotal());
			ps.setBigDecimal(6, v.getVlrPago());
			ps.setBigDecimal(7, v.getTroco());
			ps.setString(8, v.getDatacompra());
			ps.setString(9, v.getHoracompra());
			ps.executeUpdate();
			ps.close();
			if (v.getIdcod_venda() == 0) {
				JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "Venda Atualizada com Sucesso");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Vendas v) {

	}

	@Override
	public void excluir(int idcod_v) {

		PreparedStatement ps;

		try {
			ps = conexao.prepareStatement("DELETE FROM VENDA WHERE IDCOD_VENDA =" + idcod_v);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Requisição de venda excluida com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Vendas buscar(int idcod_v) {

		Statement st = null;
		ResultSet rs = null;
		Vendas v = null;

		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT IDCOD_C, CLIENTE, IDCOD_P," + "PRODUTO, VLRTOTAL, VLRPAGO, TROCO, DATACOMPRA, HORACOMPRA"
					+ "FROM VENDA WHERE IDCOD_VENDA = " + idcod_v);
			rs.next();
			if (rs.getString("CLIENTE") != null) {
				v = new Vendas(rs.getInt("IDCOD_C"), rs.getInt("IDCOD_P"), rs.getString("CLIENTE"),
						rs.getString("PRODUTO"), rs.getBigDecimal("VLRTOTAL"), rs.getBigDecimal("VLRPAGO"),
						rs.getBigDecimal("TROCO"), rs.getString("DATACOMPRA"), rs.getString("HORACOMPRA"));
			}
			rs.close();
			st.close();
			return v;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Vendas> listar() {

		Statement st = null;
		ResultSet rs = null;
		Vendas v = null;

		ArrayList<Vendas> lista = new ArrayList<Vendas>();

		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT IDCOD_VENDA, IDCOD_C, CLIENTE, IDCOD_P,"
					+ "PRODUTO, VLRTOTAL, VLRPAGO, TROCO, DATACOMPRA, HORACOMPRA FROM VENDA");
			while (rs.next()) {
				lista.add(v = new Vendas(rs.getInt("IDCOD_VENDAS"), rs.getInt("IDCOD_C"), rs.getInt("IDCOD_P"),
						rs.getString("CLIENTE"), rs.getString("PRODUTO"), rs.getBigDecimal("VLRTOTAL"),
						rs.getBigDecimal("VLRPAGO"), rs.getBigDecimal("TROCO"), rs.getString("DATACOMPRA"),
						rs.getString("HORACOMPRA")));
			}
			rs.close();
			st.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
