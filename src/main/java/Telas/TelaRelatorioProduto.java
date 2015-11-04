package Telas;

import java.awt.BorderLayout;
import Relatorios.RelatorioProduto;

public class TelaRelatorioProduto extends MolduraAbstrata {

	
	public TelaRelatorioProduto() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new RelatorioProduto(), BorderLayout.CENTER);
	}
}
