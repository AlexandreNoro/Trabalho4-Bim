package AcessoAoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		
		
	}

	@Override
	public Produto buscar(int id_p) {
		
		return null;
	}

	@Override
	public List<Produto> listar() {
		
		return null;
	}



}
