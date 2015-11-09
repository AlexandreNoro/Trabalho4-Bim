package AcessoAoBanco;

import java.util.List;

//Interface ClienteDao: Métodos CRUD para acesso ao banco
public interface AcessoDao<T> {

	public void inserir(T acesso);

	public void atualizar(T acesso);

	public void excluir(int acesso);

	public T buscar(int acesso);

	public List<T> listar();
}
