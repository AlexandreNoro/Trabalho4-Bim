package Telas;

import java.awt.BorderLayout;
import Relatorios.RelatorioProduto;

public class TelaRelatorioProduto extends MolduraAbstrata {
	// Construtor
	public TelaRelatorioProduto() {
		super();
	}

	// Metodo que chama JPanel de relatorio solicitada
	@Override
	protected void configuraMiolo() {
		super.add(new RelatorioProduto(), BorderLayout.CENTER);
	}
}
