package br.univel.cadastroCliente;

import java.math.BigDecimal;
import java.security.Timestamp;


//Classe Venda: Criado classe venda com valores necessários para venda.

public class Vendas {

	private BigDecimal vlrtotal;
	private BigDecimal troco;
	private Cliente cliente;
	private Produto produto;
	private Timestamp datacompra;
	private Timestamp horacompra;

	public BigDecimal getVlrtotal() {
		return vlrtotal;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public Timestamp getDatacompra() {
		return datacompra;
	}

	public Timestamp getHoracompra() {
		return horacompra;
	}

}
