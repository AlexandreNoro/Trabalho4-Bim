package br.univel.cadastroCliente;

import java.math.BigDecimal;

public class Produto {

	private int cod_p;
	private int codbarra;
	private String categoria;
	private String descricao;
	private String unidade;
	private BigDecimal custo;
	private BigDecimal margemlucro;

	// Getters e Setters dos atributos
	public int getcod_p() {
		return cod_p;
	}

	public void setcod_p(int cod_p) {
		this.cod_p = cod_p;
	}

	public int getCodbarra() {
		return codbarra;
	}

	public void setCodbarra(int codbarra) {
		this.codbarra = codbarra;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getMargemlucro() {
		return margemlucro;
	}

	public void setMargemlucro(BigDecimal margemlucro) {
		this.margemlucro = margemlucro;
	}

	public Produto() {
	}

	public Produto(int cod_p, int codBarra, String categoria, String descricao, String unidade, BigDecimal custo,
			BigDecimal margenLucro) {
		this.cod_p = cod_p;
		this.codbarra = codBarra;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.margemlucro = margenLucro;
	}

	public Produto(int codBarra, String categoria, String descricao, String unidade, BigDecimal custo,
			BigDecimal margenLucro) {
		this.codbarra = codBarra;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.margemlucro = margenLucro;
	}

}
