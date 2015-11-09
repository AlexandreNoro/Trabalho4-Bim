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
	
	public void inserir(Vendas v) {

		PreparedStatement ps;

		try {
			ps = conexao.prepareStatement("INSERT INTO VENDA (ID_C, CLIENTE, COD_P,"
					+ " PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, v.getIdcod_c());
			ps.setString(2, v.getCliente());
			ps.setInt(3, v.getcod_p());
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

	public void atualizar(Vendas v) {

	}

	public void excluir(int idcod_v) {

		PreparedStatement ps;

		try {
			ps = conexao.prepareStatement("DELETE FROM VENDA WHERE COD_V =" + idcod_v);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Requisição de venda excluida com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Vendas buscar(int idcod_v) {

		Statement st = null;
		ResultSet rs = null;
		Vendas v = null;

		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT ID_C, CLIENTE, COD_P,"
					+ "PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA"
					+ "FROM venda WHERE COD_V = " + idcod_v);
			rs.next();
			if (rs.getString("CLIENTE") != null) {
				v = new Vendas(rs.getInt("ID_C"),
						rs.getInt("COD_P"),
						rs.getString("CLIENTE"),
						rs.getString("PRODUTO"),
						rs.getBigDecimal("VTOTAL"),
						rs.getBigDecimal("VPAGAMENTO"),
						rs.getBigDecimal("TROCO"),
						rs.getString("DATA"),
						rs.getString("HORA"));
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
				lista.add(new Vendas(rs.getInt("COD_V"),
						rs.getInt("ID_C"),
						rs.getInt("COD_P"),
						rs.getString("CLIENTE"),
						rs.getString("PRODUTO"),
						rs.getBigDecimal("VTOTAL"),
						rs.getBigDecimal("VPAGAMENTO"),
						rs.getBigDecimal("TROCO"),
						rs.getString("DATA"),
						rs.getString("HORA")));
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
