package AcessoAoBanco;

import static org.junit.Assert.*;

import org.junit.Test;

import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Estado;
import br.univel.cadastroCliente.Genero;
//Testes dos métodos da classe ClienteDaoAcesso com JUNIT
public class TesteClienteDao {

	@Test
	public void testInserir() {
		assertEquals("Erro ao inserir dados no banco", 1, new ClienteDaoAcesso().inserir(new Cliente("Noro",
				"04588179098", "Av. Curitiba", "Santa Helena", Estado.PR, "xando10.noro@gmail.com", Genero.M)));
		new ResetConexoesDao().reset("CLIENTE");
	}

	@Test
	public void testAtualizar() {
		new ClienteDaoAcesso().inserir(new Cliente("Henrique", "04588011001","Av. Argentina", "Santa Helena", Estado.PR, "java@univel.com",Genero.M));
		assertEquals("Erro ao atualizar dados no banco", 1, 
						new ClienteDaoAcesso()
							.atualizar(new Cliente(1, "Noro", "88179098","Rua Brasília", "Toledo", Estado.PR, "Alexandre@noro.com",Genero.M)));
		new ResetConexoesDao().reset("CLIENTE");

	}

	@Test
	public void testExcluir() {
		new ClienteDaoAcesso().inserir(new Cliente("Noro", "04588179098","Av.Curitiba", "Santa Helena", Estado.PR, "xando10.noro@gmail.com",Genero.M));
		assertEquals("Erro ao excluir cliente",1 , new ClienteDaoAcesso().excluir(1));
		new ResetConexoesDao().reset("CLIENTE");

	}

	@Test
	public void testBuscar() {
		new ClienteDaoAcesso().inserir(new Cliente("Noro", "04588179098","Av.Curitiba", "Santa Helena", Estado.PR, "xando10.noro@gmail.com",Genero.M));
		assertNotNull("Erro ao buscar Cliente", new ClienteDaoAcesso().buscar(1));
		new ResetConexoesDao().reset("CLIENTE");

	}

	@Test
	public void testListar() {
		new ClienteDaoAcesso().inserir(new Cliente("Noro", "04588179098","Av.Curitiba", "Santa Helena", Estado.PR, "xando10.noro@gmail.com",Genero.M));
		assertNotNull("Erro ao Listar Cliente", new ClienteDaoAcesso().listar());
		new ResetConexoesDao().reset("CLIENTE");

	}

	@Test
	public void testGetConexao() {
		assertNotNull("Erro ao retornar conexão", new ClienteDaoAcesso().getConexao());

	}

}
