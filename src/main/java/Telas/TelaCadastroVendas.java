package Telas;

import java.awt.BorderLayout;

public class TelaCadastroVendas extends MolduraAbstrata {

	public TelaCadastroVendas() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroVendas(), BorderLayout.CENTER);
	}
}
