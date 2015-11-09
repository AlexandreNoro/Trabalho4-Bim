package Tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import AcessoAoBanco.ClienteDaoAcesso;
import AcessoAoBanco.RelatorioDaoAcesso;
import AcessoAoBanco.VendaDaoAcesso;
import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Vendas;

public class TabelaVendas extends AbstractTableModel {

	List<Vendas> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {

		return 8;
	}

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		Vendas v = lista.get(linha);
		switch (coluna) {
		case 0:
			return v.getIdcod_venda();
		case 1:
			return v.getCliente();
		case 2:
			return v.getProduto();
		case 3:
			return v.getVlrtotal();
		case 4:
			return v.getVlrPago();
		case 5:
			return v.getTroco();
		case 6:
			return v.getDatacompra();
		case 7:
			return v.getHoracompra();

		default:
			return "Nao Existe";

		}
	}

	public String getColumnName(int coluna) {

		switch (coluna) {

		case 0:
			return "ID DA VENDA";
		case 1:
			return "CLIENTE";
		case 2:
			return "PRODUTO";
		case 3:
			return "VALOR TOTAL";
		case 4:
			return "VALOR DO PAGAMENTO";
		case 5:
			return "TROCO";
		case 6:
			return "DATA DA COMPRA";
		case 7:
			return "HORÁRIO DA COMPRA";

		default:
			return "Nao Existe";
		}
	}

	public List<Vendas> listar() {
		VendaDaoAcesso vda = new VendaDaoAcesso();
		return lista = vda.listar();
	}

	public void addLista(List<Vendas> v) {
		this.lista = v;
		this.fireTableStructureChanged();
	}

	public void atualizaLista(int in, Vendas v) {
		this.lista.set(in, v);
		this.fireTableStructureChanged();
	}

	public void excluir(int in) {
		this.lista.remove(in);
		this.fireTableStructureChanged();
	}

	public List<Vendas> mostraRelatorio(StringBuilder mr) {
		RelatorioDaoAcesso rda = new RelatorioDaoAcesso();
		this.lista = rda.relatorioVendas(mr);
		this.fireTableDataChanged();
		return lista;
	}

}
