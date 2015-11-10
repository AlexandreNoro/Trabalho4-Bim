package br.univel.cadastroCliente;

public enum Estado {

	AC("Acre"),
	AL("Alagoas"),
	AP("Amapá"),
	AM("Amazonia"),
	BA("Bahia"),
	CE("Ceará"),
	DF("Distrito Federal"),
	ES("Espírito Santo"),
	GO("Goiás"),
	MA("Maranhão"),
	MT("Mato Grosso"),
	MS("Mato Grosso do Sul"),
	MG("Minas Gerais"),
	PA("Pará"),
	PB("Paraiba"),
	PR("Paraná"),
	PE("Pernambuco"),
	PI("Piauí"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"),
	RO("Rondônia"),
	RR("Roraima"),
	SC("Santa Catarina"),
	SP("São Paulo"),
	SE("Sergipe"),
	TO("Tocantins");

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

	public static String validar(String estado) {
		for(Estado e: Estado.values()){
			if(e.getNome().equals(estado)){
				return e.name();
			}
		}
		return "";
	}
}
