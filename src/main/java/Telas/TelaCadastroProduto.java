package Telas;

import java.awt.BorderLayout;

public class TelaCadastroProduto extends MolduraAbstrata {

	// Construtor
	public TelaCadastroProduto() {
		super();
	}

	// Metodo que chama Jpanel de cadastro solicitado
	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroProduto(), BorderLayout.CENTER);
	}

}
