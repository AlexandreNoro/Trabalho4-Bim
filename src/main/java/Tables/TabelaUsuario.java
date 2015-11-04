package Tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import AcessoAoBanco.UsuarioDaoAcesso;
import br.univel.cadastroCliente.Usuario;

public class TabelaUsuario extends AbstractTableModel {

	List<Usuario> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		
		return 4;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		Usuario user = lista.get(linha);
		switch (coluna) {
		case 0:
			return user.getId();
		case 1:
			return user.getIdCliente();
		case 2:
			return user.getCliente();
		case 3:
			return user.getSenha();

		default:
			return "Nao Existe";

		}

	}

	public String getColumnName(int coluna) {

		switch (coluna) {

		case 0:
			return "ID USUÁRIO";
		case 1:
			return "ID CLIENTE";
		case 2:
			return "USUÁRIO";
		case 3:
			return "SENHA";

		default:
			return "Nao Existe";
		}
	}

	public List<Usuario> listar() {
		UsuarioDaoAcesso user = new UsuarioDaoAcesso();
		return lista = user.listar();
	}

	public void addLista(List<Usuario> user) {
		this.lista = user;
		this.fireTableStructureChanged();
	}

	public void atualizaLista(int in, Usuario user) {
		this.lista.set(in, user);
		this.fireTableStructureChanged();
	}

	public void excluir(int in) {
		this.lista.remove(in);
		this.fireTableStructureChanged();
	}

}
