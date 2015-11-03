package br.univel.cadastroCliente;

public enum Genero {

	M("Masculino"), F("Feminino"), G("Gay");

	//Variável que retorna o genero de determinado letra
	private String nome;
	
	//retorna o valor
	public String getNome() {
		return nome;
	}
	//Construtor da classe que recebe um tipo String
	private Genero(String nome) {
		this.nome = nome;
	}
	
	//Método que valida os generos
	public Genero validar(Object obj) {
		if (obj.toString().equals(M.nome))
			return Genero.M;
		else if (obj.toString().equals(F.nome))
			return Genero.F;
		else if (obj.toString().equals(G.nome))
			return Genero.G;

		return null;

	}

}
