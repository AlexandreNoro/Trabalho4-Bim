package AcessoAoBanco;

import java.util.List;

import br.univel.cadastroCliente.Cliente;

//Interface ClienteDao: Métodos CRUD para acesso ao banco
public interface ClienteDao {

	public void inserir(Cliente c);

	public void atualizar(Cliente c);

	public void excluir(int id);

	public Cliente buscar(int id);

	public List<Cliente> listar();
}
