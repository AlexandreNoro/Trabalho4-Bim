package AcessoAoBanco;

import static org.junit.Assert.*;

import org.junit.Test;
//Testes dos m�todos da classe ConectarBanco com JUNIT
public class TesteConexaoDao {

	@Test
	public void testAbreConexao() {
		assertNotNull("N�o foi possivel conectar ao Banco", ConectarBanco.getInstace().abreConexao());
		ConectarBanco.getInstace().fechaConexao();
		;

	}

	@Test
	public void testFechaConexao() {
		ConectarBanco.getInstace().abreConexao();
		assertTrue("N�o foi possivel fechar conexao", ConectarBanco.getInstace().fechaConexao());

	}

}
