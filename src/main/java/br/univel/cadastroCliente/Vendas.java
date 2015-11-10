package br.univel.cadastroCliente;

import java.math.BigDecimal;

public class Vendas {
	private int cod_v;
	private int id_c;
	private int cod_p;
	private String cliente;
	private String produto;
	private BigDecimal vTotal;
	private BigDecimal vPago;
	private BigDecimal troco;
	private String data;
	private String hora;

	public Vendas() {
	}

	// Métodos geters e seters
	public int getCod_v() {
		return cod_v;
	}

	public int getId_c() {
		return id_c;
	}

	public int getCod_p() {
		return cod_p;
	}

	public String getCliente() {
		return cliente;
	}

	public String getProduto() {
		return produto;
	}

	public BigDecimal getvTotal() {
		return vTotal;
	}

	public BigDecimal getvPago() {
		return vPago;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public Vendas(int cod_v, int id_c, int cod_p, String cliente, String produto, BigDecimal vTotal, BigDecimal vPago,
			BigDecimal troco, String data, String hora) {
		this.cod_v = cod_v;
		this.id_c = id_c;
		this.cliente = cliente;
		this.produto = produto;
		this.vTotal = vTotal;
		this.vPago = vPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;
	}

	public Vendas(int id_c, int cod_p, String cliente, String produto, BigDecimal vTotal, BigDecimal vPago,
			BigDecimal troco, String data, String hora) {
		this.id_c = id_c;
		this.cod_p = cod_p;
		this.cliente = cliente;
		this.produto = produto;
		this.vTotal = vTotal;
		this.vPago = vPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;

	}

	public Vendas(int cod_v, String cliente, String produto, BigDecimal vTotal, BigDecimal vPago, BigDecimal troco,
			String data, String hora) {
		this.cod_v = cod_v;
		this.cliente = cliente;
		this.produto = produto;
		this.vTotal = vTotal;
		this.vPago = vPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;
	}

}