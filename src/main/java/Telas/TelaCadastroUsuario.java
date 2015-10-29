package Telas;

import java.awt.BorderLayout;

public class TelaCadastroUsuario extends MolduraAbstrata{

	public TelaCadastroUsuario() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroUsuario(), BorderLayout.CENTER);
	}

}
