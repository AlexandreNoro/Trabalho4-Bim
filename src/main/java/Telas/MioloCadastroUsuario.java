package Telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class MioloCadastroUsuario extends JPanel {
	private JTextField txfId;
	private JTextField txfIdcliente;
	private JTextField txf_cliente;
	private JTextField txf_senha;

	/**
	 * Create the panel.
	 */
	public MioloCadastroUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txfId = new JTextField();
		GridBagConstraints gbc_txfId = new GridBagConstraints();
		gbc_txfId.insets = new Insets(0, 0, 5, 0);
		gbc_txfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfId.gridx = 1;
		gbc_txfId.gridy = 0;
		add(txfId, gbc_txfId);
		txfId.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		GridBagConstraints gbc_lblIdCliente = new GridBagConstraints();
		gbc_lblIdCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdCliente.gridx = 0;
		gbc_lblIdCliente.gridy = 1;
		add(lblIdCliente, gbc_lblIdCliente);
		
		txfIdcliente = new JTextField();
		GridBagConstraints gbc_txfIdcliente = new GridBagConstraints();
		gbc_txfIdcliente.insets = new Insets(0, 0, 5, 0);
		gbc_txfIdcliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfIdcliente.gridx = 1;
		gbc_txfIdcliente.gridy = 1;
		add(txfIdcliente, gbc_txfIdcliente);
		txfIdcliente.setColumns(10);
		
		JLabel lbl_cliente = new JLabel("Cliente");
		GridBagConstraints gbc_lbl_cliente = new GridBagConstraints();
		gbc_lbl_cliente.anchor = GridBagConstraints.EAST;
		gbc_lbl_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_cliente.gridx = 0;
		gbc_lbl_cliente.gridy = 2;
		add(lbl_cliente, gbc_lbl_cliente);
		
		txf_cliente = new JTextField();
		GridBagConstraints gbc_txf_cliente = new GridBagConstraints();
		gbc_txf_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_txf_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_cliente.gridx = 1;
		gbc_txf_cliente.gridy = 2;
		add(txf_cliente, gbc_txf_cliente);
		txf_cliente.setColumns(10);
		
		JLabel lbl_senha = new JLabel("Senha");
		GridBagConstraints gbc_lbl_senha = new GridBagConstraints();
		gbc_lbl_senha.anchor = GridBagConstraints.EAST;
		gbc_lbl_senha.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_senha.gridx = 0;
		gbc_lbl_senha.gridy = 3;
		add(lbl_senha, gbc_lbl_senha);
		
		txf_senha = new JTextField();
		GridBagConstraints gbc_txf_senha = new GridBagConstraints();
		gbc_txf_senha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_senha.gridx = 1;
		gbc_txf_senha.gridy = 3;
		add(txf_senha, gbc_txf_senha);
		txf_senha.setColumns(10);

	}

}
