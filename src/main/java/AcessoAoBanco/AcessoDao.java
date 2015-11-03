package AcessoAoBanco;

import java.util.List;

import br.univel.cadastroCliente.Cliente;

//Interface ClienteDao: Métodos CRUD para acesso ao banco
public interface AcessoDao<A> {

	public void inserir(A acesso);

	public void atualizar(A acesso);

	public void excluir(int acesso);

	public A buscar(int acesso);

	public List<A> listar();
}
