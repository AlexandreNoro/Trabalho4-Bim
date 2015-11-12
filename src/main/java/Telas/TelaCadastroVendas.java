package Telas;

import java.awt.BorderLayout;

public class TelaCadastroVendas extends MolduraAbstrata {

	// Construtor
	public TelaCadastroVendas() {
		super();
	}

	// Metodo que chama Jpanel de cadastro solicitado
	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroVendas(), BorderLayout.CENTER);
	}
}
