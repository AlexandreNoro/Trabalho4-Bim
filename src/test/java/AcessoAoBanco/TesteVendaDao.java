package AcessoAoBanco;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.univel.cadastroCliente.Vendas;

public class TesteVendaDao {

	@Test
	public void testInserir() {
		assertEquals("Erro ao inserir dados no banco", 1,
				new VendaDaoAcesso().inserir(new Vendas(1, 1, "teste", "teste", BigDecimal.valueOf(16.99),
						BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "17/11/2015", "20:54:20")));
		new ResetConexoesDao().reset("VENDA");

	}

	@Ignore
	public void testAtualizar() {

	}

	@Test
	public void testExcluir() {
		new VendaDaoAcesso().inserir(new Vendas(1, 1, "teste", "teste", BigDecimal.valueOf(16.99),
				BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "17/11/2015", "20:54:20"));
		assertEquals("Erro ao excluir histórico da venda", 1, new VendaDaoAcesso().excluir(1));
		new ResetConexoesDao().reset("VENDA");

	}

	@Test
	public void testBuscar() {
		new VendaDaoAcesso().inserir(new Vendas(1, 1, "teste", "teste", BigDecimal.valueOf(16.99),
				BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "17/11/2015", "20:54:20"));
		assertNotNull("Erro ao buscar Venda", new VendaDaoAcesso().buscar(1));
		new ResetConexoesDao().reset("VENDA");

	}

	@Test
	public void testListar() {
		new VendaDaoAcesso().inserir(new Vendas(1, 1, "teste", "teste", BigDecimal.valueOf(16.99),
				BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "17/11/2015", "20:54:20"));
		assertNotNull("Erro ao Listar Venda", new VendaDaoAcesso().listar());
		new ResetConexoesDao().reset("VENDA");

	}

	@Test
	public void testGetConexao() {
		assertNotNull("Erro ao retornar conexão", new ClienteDaoAcesso().getConexao());
	}

}
