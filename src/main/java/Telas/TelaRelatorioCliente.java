package Telas;

import java.awt.BorderLayout;

import Relatorios.RelatorioCliente;

public class TelaRelatorioCliente extends MolduraAbstrata {

	
	public TelaRelatorioCliente() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new RelatorioCliente(), BorderLayout.CENTER);
	}
}
