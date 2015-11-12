package Telas;

import java.awt.BorderLayout;

import Relatorios.RelatorioCliente;

public class TelaRelatorioCliente extends MolduraAbstrata {
	// Construtor
	public TelaRelatorioCliente() {
		super();
	}

	// Metodo que chama JPanel de relatorio solicitada
	@Override
	protected void configuraMiolo() {
		super.add(new RelatorioCliente(), BorderLayout.CENTER);
	}
}
