package Tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import AcessoAoBanco.ClienteDaoAcesso;
import AcessoAoBanco.ProdutoDaoAcesso;
import AcessoAoBanco.RelatorioDaoAcesso;
import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Produto;

public class TabelaProduto extends AbstractTableModel {

	List<Produto> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {

		return 7;
	}

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Produto p = lista.get(linha);
		switch (coluna) {
		case 0:
			return p.getcod_p();
		case 1:
			return p.getCodbarra();
		case 2:
			return p.getCategoria();
		case 3:
			return p.getDescricao();
		case 4:
			return p.getUnidade();
		case 5:
			return p.getCusto();
		case 6:
			return p.getMargemlucro();

		default:
			return "Nao Existe";

		}

	}

	public String getColumnName(int coluna) {

		switch (coluna) {

		case 0:
			return "CODIGO PRODUTO";
		case 1:
			return "COD_BARRA";
		case 2:
			return "CATEGORIA";
		case 3:
			return "DESCRICAO";
		case 4:
			return "UNIDADE";
		case 5:
			return "CUSTO";
		case 6:
			return "MARGEM DE LUCRO";

		default:
			return "Nao Existe";
		}
	}

	public List<Produto> listar() {
		ProdutoDaoAcesso pda = new ProdutoDaoAcesso();
		return lista = pda.listar();
	}

	public void addLista(List<Produto> p) {
		this.lista = p;
		this.fireTableStructureChanged();
	}

	public void atualizaLista(int in, Produto p) {
		this.lista.set(in, p);
		this.fireTableStructureChanged();
	}

	public void excluir(int in) {
		this.lista.remove(in);
		this.fireTableStructureChanged();
	}

	public List<Produto> mostraRelatorio(String mr) {
		RelatorioDaoAcesso rda = new RelatorioDaoAcesso();
		this.lista = rda.relatorioProduto(mr);
		this.fireTableDataChanged();
		return lista;
	}

}
