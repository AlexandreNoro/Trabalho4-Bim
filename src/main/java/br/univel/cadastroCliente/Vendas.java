package br.univel.cadastroCliente;

import java.math.BigDecimal;

//Classe Venda: Criado classe venda com valores necessários para venda.

public class Vendas {

	private BigDecimal vlrtotal;
	private BigDecimal troco;
	private BigDecimal vlrPago;
	private String cliente;
	private String produto;
	private int idcod_venda;
	private int idcod_c;
	private int idcod_preco;
	private String datacompra;
	private String horacompra;

	// Getters da classe

	public BigDecimal getVlrtotal() {
		return vlrtotal;
	}

	public BigDecimal getTroco() {
		return troco;
	}


	public BigDecimal getVlrPago() {
		return vlrPago;
	}


	public String getCliente() {
		return cliente;
	}


	public String getProduto() {
		return produto;
	}


	public int getIdcod_venda() {
		return idcod_venda;
	}


	public int getIdcod_c() {
		return idcod_c;
	}

	public int getIdcod_preco() {
		return idcod_preco;
	}


	public String getDatacompra() {
		return datacompra;
	}


	public String getHoracompra() {
		return horacompra;
	}

	//Contrutores da classe venda
	public Vendas(BigDecimal vlrtotal, BigDecimal troco, BigDecimal vlrPago, String cliente, String produto,
			int idcod_venda, int idcod_compra, int idcod_preco, String datacompra, String horacompra) {

		super();
		this.vlrtotal = vlrtotal;
		this.troco = troco;
		this.vlrPago = vlrPago;
		this.cliente = cliente;
		this.produto = produto;
		this.idcod_venda = idcod_venda;
		this.idcod_c = idcod_c;
		this.idcod_preco = idcod_preco;
		this.datacompra = datacompra;
		this.horacompra = horacompra;
	}

	public Vendas(int idcod_venda) {
		super();
		this.idcod_venda = idcod_venda;
	}

	public String toString() {
		return "Vendas[ " + this.vlrtotal + ", " + this.troco + ", " + this.vlrPago + ", " + this.cliente + ", "
				+ this.produto + ", " + this.idcod_venda + ", " + this.idcod_c + ", " + this.idcod_preco + ","
				+ this.datacompra + ", " + this.horacompra + "] \n";
	}

}
