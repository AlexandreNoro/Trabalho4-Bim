package AcessoAoBanco;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteConexaoDao {

	@Test
	public void testAbreConexao() {
		assertNotNull("Não foi possivel conectar ao Banco", ConectarBanco.getInstace().abreConexao());
		ConectarBanco.getInstace().fechaConexao();
		;

	}

	@Test
	public void testFechaConexao() {
		ConectarBanco.getInstace().abreConexao();
		assertTrue("Não foi possivel fechar conexao", ConectarBanco.getInstace().fechaConexao());

	}

}
