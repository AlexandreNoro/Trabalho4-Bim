package Telas;

import java.awt.BorderLayout;

import Relatorios.RelatorioProduto;
import Relatorios.RelatorioVenda;

public class TelaRelatorioVenda extends MolduraAbstrata {

	public TelaRelatorioVenda() {
		super();
	}
	
	@Override
	protected void configuraMiolo() {
		super.add(new RelatorioVenda(), BorderLayout.CENTER);
	}

}
