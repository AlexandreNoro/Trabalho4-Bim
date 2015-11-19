package br.univel.cadastroCliente;

public enum Genero {

	M("Masculino"), F("Feminino");

	// Variável que retorna o genero de determinado letra
	private String nome;

	// retorna o valor
	public String getNome() {
		return nome;
	}

	// Construtor da classe que recebe um tipo String
	private Genero(String nome) {
		this.nome = nome;
	}

}
