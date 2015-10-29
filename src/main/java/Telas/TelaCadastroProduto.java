package Telas;

import java.awt.BorderLayout;

public class TelaCadastroProduto extends MolduraAbstrata{

	
	public TelaCadastroProduto() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroProduto(), BorderLayout.CENTER);
	}

}
