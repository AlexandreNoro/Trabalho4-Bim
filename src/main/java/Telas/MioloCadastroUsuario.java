package Telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MioloCadastroUsuario extends JPanel {
	private JTextField txfId;
	private JTextField txfIdcliente;
	private JTextField txf_cliente;
	private JTextField txf_senha;
	private JButton btnGravar;
	private JButton btnEditar;
	private JButton btnDeletar;
	private JScrollPane scrollPane;
	private JTable tablemiolousuario;

	/**
	 * Create the panel.
	 */
	public MioloCadastroUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 150, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txfId = new JTextField();
		txfId.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfId = new GridBagConstraints();
		gbc_txfId.insets = new Insets(0, 0, 5, 5);
		gbc_txfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfId.gridx = 1;
		gbc_txfId.gridy = 0;
		add(txfId, gbc_txfId);
		txfId.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblIdCliente = new GridBagConstraints();
		gbc_lblIdCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdCliente.gridx = 0;
		gbc_lblIdCliente.gridy = 1;
		add(lblIdCliente, gbc_lblIdCliente);
		
		txfIdcliente = new JTextField();
		txfIdcliente.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfIdcliente = new GridBagConstraints();
		gbc_txfIdcliente.insets = new Insets(0, 0, 5, 5);
		gbc_txfIdcliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfIdcliente.gridx = 1;
		gbc_txfIdcliente.gridy = 1;
		add(txfIdcliente, gbc_txfIdcliente);
		txfIdcliente.setColumns(10);
		
		JLabel lbl_cliente = new JLabel("Cliente");
		lbl_cliente.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_cliente = new GridBagConstraints();
		gbc_lbl_cliente.anchor = GridBagConstraints.EAST;
		gbc_lbl_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_cliente.gridx = 0;
		gbc_lbl_cliente.gridy = 2;
		add(lbl_cliente, gbc_lbl_cliente);
		
		txf_cliente = new JTextField();
		txf_cliente.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txf_cliente = new GridBagConstraints();
		gbc_txf_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_txf_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_cliente.gridx = 1;
		gbc_txf_cliente.gridy = 2;
		add(txf_cliente, gbc_txf_cliente);
		txf_cliente.setColumns(10);
		
		JLabel lbl_senha = new JLabel("Senha");
		lbl_senha.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_senha = new GridBagConstraints();
		gbc_lbl_senha.anchor = GridBagConstraints.EAST;
		gbc_lbl_senha.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_senha.gridx = 0;
		gbc_lbl_senha.gridy = 3;
		add(lbl_senha, gbc_lbl_senha);
		
		txf_senha = new JTextField();
		txf_senha.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txf_senha = new GridBagConstraints();
		gbc_txf_senha.insets = new Insets(0, 0, 5, 5);
		gbc_txf_senha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_senha.gridx = 1;
		gbc_txf_senha.gridy = 3;
		add(txf_senha, gbc_txf_senha);
		txf_senha.setColumns(10);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnGravar = new GridBagConstraints();
		gbc_btnGravar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGravar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGravar.gridx = 2;
		gbc_btnGravar.gridy = 4;
		add(btnGravar, gbc_btnGravar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditar.gridx = 3;
		gbc_btnEditar.gridy = 4;
		add(btnEditar, gbc_btnEditar);
		
		btnDeletar = new JButton("Excluir");
		btnDeletar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnDeletar = new GridBagConstraints();
		gbc_btnDeletar.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeletar.gridx = 4;
		gbc_btnDeletar.gridy = 4;
		add(btnDeletar, gbc_btnDeletar);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
		
		tablemiolousuario = new JTable();
		tablemiolousuario.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		scrollPane.setViewportView(tablemiolousuario);

	}

}
