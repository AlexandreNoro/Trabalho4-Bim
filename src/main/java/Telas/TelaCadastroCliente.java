package Telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroCliente extends MolduraAbstrata {
	// Construtor
	public TelaCadastroCliente() {
		super();
	}

	// Metodo que chama Jpanel de cadastro solicitado
	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroCliente(), BorderLayout.CENTER);
	}

}