package br.univel.cadastroCliente;

public enum Estado {

	AC("Acre"),
	AL("Alagoas"),
	AP("Amap�"),
	AM("Amazonia"),
	BA("Bahia"),
	CE("Cear�"),
	DF("Distrito Federal"),
	ES("Esp�rito Santo"),
	GO("Goi�s"),
	MA("Maranh�o"),
	MT("Mato Grosso"),
	MS("Mato Grosso do Sul"),
	MG("Minas Gerais"),
	PA("Par�"),
	PB("Paraiba"),
	PR("Paran�"),
	PE("Pernambuco"),
	PI("Piau�"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"),
	RO("Rond�nia"),
	RR("Roraima"),
	SC("Santa Catarina"),
	SP("S�o Paulo"),
	SE("Sergipe"),
	TO("Tocantins");

	//Vari�vel que retorna o nome do estado de determinada sigla
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
