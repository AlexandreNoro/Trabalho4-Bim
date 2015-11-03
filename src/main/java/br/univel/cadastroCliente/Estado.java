package br.univel.cadastroCliente;

public enum Estado {

	PR("Paraná"), SP("São Paulo"), SC("Santa Catarina"), RJ("Rio de Janeiro"), RS("Rio Grande do Sul");

	//Variável que retorna o nome do estado de determinada sigla
	private String nome;

	//retorna o valor
	public String getNome() {
		return nome;
	}
	//Construtor da classe que recebe um tipo String
	private Estado(String nome) {
		this.nome = nome;
	}

	public Estado validar(Object obj) {
		if (obj.toString().equals(PR.nome))
			return Estado.PR;
		else if (obj.toString().equals(SP.nome))
			return Estado.SP;
		else if (obj.toString().equals(SC.nome))
			return Estado.SC;
		else if (obj.toString().equals(RJ.nome))
			return Estado.RJ;
		else if (obj.toString().equals(RS.nome))
			return Estado.RS;

		return null;

	}
}
