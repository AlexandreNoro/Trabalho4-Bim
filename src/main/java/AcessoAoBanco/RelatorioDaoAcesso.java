package AcessoAoBanco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Estado;
import br.univel.cadastroCliente.Genero;
import br.univel.cadastroCliente.Produto;
import br.univel.cadastroCliente.Vendas;

public class RelatorioDaoAcesso {

	private Connection conexao = ConectarBanco.getInstace().abreConexao();
	private Statement st = null;
	private ResultSet rs = null;

	// Metodo que faz o retorno de uma lista do relatório do Cliente
	public List<Cliente> relatorioCliente(String rltc) {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			st = conexao.createStatement();
			rs = st.executeQuery(rltc);
			while (rs.next()) {
				lista.add(new Cliente(rs.getInt("ID_C"), rs.getString("NOME"), rs.getString("TELEFONE"),
						rs.getString("ENDERECO"), rs.getString("CIDADE"),
						Estado.valueOf(Estado.class, rs.getString("ESTADO")), rs.getString("EMAIL"),
						Genero.valueOf(Genero.class, rs.getString("GENERO"))));
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

	// Metodo que faz o retorno de uma lista do relatório do Produto
	public List<Produto> relatorioProduto(String rltp) {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			st = conexao.createStatement();
			rs = st.executeQuery(rltp);
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

	// Metodo que faz o retorno de uma lista do relatório de Venda
	public List<Vendas> relatorioVendas(StringBuilder rltv) {
		List<Vendas> lista = new ArrayList<Vendas>();
		try {
			st = conexao.createStatement();
			rs = st.executeQuery(rltv.toString() + " UNION " + rltv.toString());
			while (rs.next()) {
				lista.add(new Vendas(rs.getInt("COD_V"), rs.getString("CLIENTE"), rs.getString("PRODUTO"),
						rs.getBigDecimal("VTOTAL"), rs.getBigDecimal("VPAGAMENTO"), rs.getBigDecimal("TROCO"),
						rs.getString("DATA"), rs.getString("HORA")));
			}
			rs.close();
			st.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Metodo que faz o retorno de uma lista do relatório da Categoria do
	// Produto
	public List<String> listarCategoriaProduto() {
		List<String> lista = new ArrayList<String>();
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT categoria FROM PRODUTO");
			while (rs.next()) {
				lista.add(rs.getString("categoria"));
			}
			rs.close();
			st.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Método que retorna a conexao
	public Connection getConexao() {
		return conexao;
	}
}
