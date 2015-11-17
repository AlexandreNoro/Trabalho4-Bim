package AcessoAoBanco;

import static org.junit.Assert.*;

import org.junit.Test;

import br.univel.cadastroCliente.Usuario;

public class TesteUsuarioDao {

	@Test
	public void testInserir() {
		Usuario u = new Usuario();
		u.setId(2);
		u.setIdCliente(2);
		u.setCliente("teste");
		u.setSenha("teste");
		assertEquals("Erro ao inserir dados no banco", 1, new UsuarioDaoAcesso().inserir(u));
		new ResetConexoesDao().reset("USUARIO");
	}

	@Test
	public void testAtualizar() {
		Usuario u = new Usuario();
		u.setId(2);
		u.setIdCliente(2);
		u.setCliente("teste");
		u.setSenha("teste");
		new UsuarioDaoAcesso().inserir(u);
		u.setCliente("teste1");
		u.setSenha("teste1");
		assertEquals("Erro ao atualizar dados no banco", 1, new UsuarioDaoAcesso().atualizar(u));
		new ResetConexoesDao().reset("USUARIO");
	}

	@Test
	public void testExcluir() {
		Usuario u = new Usuario();
		u.setId(2);
		u.setIdCliente(2);
		u.setCliente("teste");
		u.setSenha("teste");
		new UsuarioDaoAcesso().inserir(u);
		assertEquals("Erro ao deletar dados no banco", 1, new UsuarioDaoAcesso().excluir(2));
		new ResetConexoesDao().reset("USUARIO");

	}

	@Test
	public void testBuscar() {
		assertNotNull("Erro ao buscar usuário", new UsuarioDaoAcesso().buscar(1));
	}

	@Test
	public void testListar() {
		assertNotNull("Erro ao listar usuário", new UsuarioDaoAcesso().listar());
	}

	@Test
	public void testGetConexao() {
		assertNotNull("Erro ao retornar conexão", new UsuarioDaoAcesso().getConexao());
	}

	@Test
	public void testTestar() {
		Usuario u = new Usuario();
		u.setId(2);
		u.setIdCliente(2);
		u.setCliente("teste");
		u.setSenha("teste");
		new UsuarioDaoAcesso().inserir(u);
		assertTrue("Erro ao deletar dados no banco", new UsuarioDaoAcesso().Testar("teste", "teste"));
		new ResetConexoesDao().reset("USUARIO");
	}

}
