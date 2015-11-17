package AcessoAoBanco;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import br.univel.cadastroCliente.Produto;

public class TesteProdutoDao {

	@Test
	public void testInserir() {
		assertEquals("Erro ao inserir dados no banco", 1, new ProdutoDaoAcesso().inserir(
				new Produto(1, 22, "GAME", "CORRIDA", "UNID", BigDecimal.valueOf(13.4), BigDecimal.valueOf(20.0))));
		new ResetConexoesDao().reset("PRODUTO");
	}

	@Test
	public void testAtualizar() {
		new ProdutoDaoAcesso().inserir(
				new Produto(1, 22, "GAME", "CORRIDA", "UNID", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0)));
		assertEquals("Erro ao inserir dados no banco", 1, new ProdutoDaoAcesso().atualizar(
				new Produto(1, 23, "GAME", "FUTEBOL", "UNID", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0))));
		new ResetConexoesDao().reset("PRODUTO");

	}

	@Test
	public void testExcluir() {
		new ProdutoDaoAcesso().inserir(
				new Produto(1, 23, "GAME", "FUTEBOL", "UNID", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0)));
		assertEquals("Erro ao inserir dados no banco", 1, new ProdutoDaoAcesso().excluir(1));
		new ResetConexoesDao().reset("PRODUTO");

	}

	@Test
	public void testBuscar() {
		new ProdutoDaoAcesso().inserir(
				new Produto(1, 23, "GAME", "FUTEBOL", "UNID", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0)));
		assertNotNull("Erro ao buscar Produto", new ProdutoDaoAcesso().buscar(1));
		new ResetConexoesDao().reset("PRODUTO");

	}

	@Test
	public void testListar() {
		new ProdutoDaoAcesso().inserir(
				new Produto(1, 23, "GAME", "FUTEBOL", "UNID", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0)));
		assertNotNull("Erro ao listar Produto", new ProdutoDaoAcesso().listar());
		new ResetConexoesDao().reset("PRODUTO");

	}

	@Test
	public void testGetConexao() {
		assertNotNull("Erro ao retornar conexão", new ProdutoDaoAcesso().getConexao());
	}

}
