package Tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import AcessoAoBanco.ClienteDaoAcesso;
import AcessoAoBanco.RelatorioDaoAcesso;
import br.univel.cadastroCliente.Cliente;

public class TabelaCliente extends AbstractTableModel {

	List<Cliente> lista = new ArrayList<>();

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
		Cliente c = lista.get(linha);
		switch (coluna) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getTelefone();
		case 3:
			return c.getEndereco();
		case 4:
			return c.getCidade();
		case 5:
			return c.getEstado().getNome();
		case 6:
			return c.getGenero();
		case 7:
			return c.getEmail();

		default:
			return "Nao Existe";

		}

	}

	public String getColumnName(int coluna) {

		switch (coluna) {

		case 0:
			return "ID";
		case 1:
			return "NOME";
		case 2:
			return "TELEFONE";
		case 3:
			return "ENDEREÇO";
		case 4:
			return "CIDADE";
		case 5:
			return "ESTADO";
		case 6:
			return "GÊNERO";
		case 7:
			return "E-MAIL";

		default:
			return "Nao Existe";
		}
	}

	public List<Cliente> listar() {
		ClienteDaoAcesso c = new ClienteDaoAcesso();
		return lista = c.listar();
	}

	public void addLista(List<Cliente> c) {
		this.lista = c;
		this.fireTableStructureChanged();
	}

	public void atualizaLista(int in, Cliente c) {
		this.lista.set(in, c);
		this.fireTableStructureChanged();
	}

	public void excluir(int in) {
		this.lista.remove(in);
		this.fireTableStructureChanged();
	}

	public List<Cliente> mostraRelatorio(String mr) {
		RelatorioDaoAcesso rda = new RelatorioDaoAcesso();
		this.lista = rda.relatorioCliente(mr);
		this.fireTableDataChanged();
		return lista;
	}
}
