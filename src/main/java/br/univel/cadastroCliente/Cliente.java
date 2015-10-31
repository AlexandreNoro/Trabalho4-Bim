package br.univel.cadastroCliente;


public class Cliente {

	private int id;
	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private Estado estado;
	private Genero genero;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Cliente(int id, String nome, String endereco, String telefone, String cidade, Estado uf, Genero gn,
			String email) {

		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cidade = cidade;
		this.estado = uf;
		this.genero = gn;
		this.email = email;
	}

	public Cliente(int id) {
		super();
		this.id = id;
	}

	public String toString() {
		return "Cliente[ " + this.nome + ", " + this.endereco + ", " + this.telefone + ", " + this.cidade + ", "
				+ this.estado.getNome() + ", " + this.genero.getNome() + ", " + this.email + "] \n";
	}

}
