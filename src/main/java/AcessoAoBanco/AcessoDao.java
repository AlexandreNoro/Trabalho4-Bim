package AcessoAoBanco;

import java.util.List;

//Interface ClienteDao: Métodos CRUD para acesso ao banco
public interface AcessoDao<T> {

	public int inserir(T acesso);

	public int atualizar(T acesso);

	public int excluir(int acesso);

	public T buscar(int acesso);

	public List<T> listar();
}
