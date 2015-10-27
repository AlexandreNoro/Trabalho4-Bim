package br.univel.cadastroCliente;

public enum Genero {

	M("Masculino"), F("Feminino"), G("Gay");

	private String nome;

	public String getNome() {
		return nome;
	}

	private Genero(String nome) {
		this.nome = nome;
	}

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
