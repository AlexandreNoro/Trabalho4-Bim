package Telas;

import java.awt.BorderLayout;

public class TelaCadastroUsuario extends MolduraAbstrata {

	// Construtor
	public TelaCadastroUsuario() {
		super();
	}

	// Metodo que chama Jpanel de cadastro solicitado
	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroUsuario(), BorderLayout.CENTER);
	}

}
