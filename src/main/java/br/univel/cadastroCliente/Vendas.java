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
	private int idcod_compra;
	private int idcod_preco;
	private String datacompra;
	private String horacompra;

	// Getters e Setters da classe

	public BigDecimal getVlrtotal() {
		return vlrtotal;
	}

	public void setVlrtotal(BigDecimal vlrtotal) {
		this.vlrtotal = vlrtotal;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public BigDecimal getVlrPago() {
		return vlrPago;
	}

	public void setVlrPago(BigDecimal vlrPago) {
		this.vlrPago = vlrPago;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getIdcod_venda() {
		return idcod_venda;
	}

	public void setIdcod_venda(int idcod_venda) {
		this.idcod_venda = idcod_venda;
	}

	public int getIdcod_compra() {
		return idcod_compra;
	}

	public void setIdcod_compra(int idcod_compra) {
		this.idcod_compra = idcod_compra;
	}

	public int getIdcod_preco() {
		return idcod_preco;
	}

	public void setIdcod_preco(int idcod_preco) {
		this.idcod_preco = idcod_preco;
	}

	public String getDatacompra() {
		return datacompra;
	}

	public void setDatacompra(String datacompra) {
		this.datacompra = datacompra;
	}

	public String getHoracompra() {
		return horacompra;
	}

	public void setHoracompra(String horacompra) {
		this.horacompra = horacompra;
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
		this.idcod_compra = idcod_compra;
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
				+ this.produto + ", " + this.idcod_venda + ", " + this.idcod_compra + ", " + this.idcod_preco + ","
				+ this.datacompra + ", " + this.horacompra + "] \n";
	}

}
