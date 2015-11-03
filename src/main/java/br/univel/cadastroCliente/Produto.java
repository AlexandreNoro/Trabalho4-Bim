package br.univel.cadastroCliente;

import java.math.BigDecimal;

public class Produto {

	private int idcod;
	private int codbarra;
	private String categoria;
	private String descricao;
	private String unidade;
	private BigDecimal custo;
	private BigDecimal margemlucro;

	//Getters e Setters dos atributos
	public int getId() {
		return idcod;
	}

	public void setId(int idcod) {
		this.idcod = idcod;
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

}
