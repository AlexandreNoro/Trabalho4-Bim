package Telas;

import java.awt.BorderLayout;

import Relatorios.RelatorioProduto;
import Relatorios.RelatorioVenda;

public class TelaRelatorioVenda extends MolduraAbstrata {
	// Construtor
	public TelaRelatorioVenda() {
		super();
	}

	// Metodo que chama JPanel de relatorio solicitada
	@Override
	protected void configuraMiolo() {
		super.add(new RelatorioVenda(), BorderLayout.CENTER);
	}

}
