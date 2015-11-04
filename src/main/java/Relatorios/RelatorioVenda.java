package Relatorios;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RelatorioVenda extends JPanel {
	private JTextField txf_cliente;
	private JTable tablevenda;

	/**
	 * Create the panel.
	 */
	public RelatorioVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 85, 0, 0, 85, 0, 88, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDia = new JLabel("Dia: ");
		lblDia.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.anchor = GridBagConstraints.EAST;
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 0;
		gbc_lblDia.gridy = 0;
		add(lblDia, gbc_lblDia);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		JLabel lblmes = new JLabel("M\u00EAs: ");
		lblmes.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblmes = new GridBagConstraints();
		gbc_lblmes.anchor = GridBagConstraints.EAST;
		gbc_lblmes.insets = new Insets(0, 0, 5, 5);
		gbc_lblmes.gridx = 3;
		gbc_lblmes.gridy = 0;
		add(lblmes, gbc_lblmes);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 0;
		add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblctgproduto = new JLabel("Categoria do Produto: ");
		lblctgproduto.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblctgproduto = new GridBagConstraints();
		gbc_lblctgproduto.anchor = GridBagConstraints.EAST;
		gbc_lblctgproduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblctgproduto.gridx = 5;
		gbc_lblctgproduto.gridy = 0;
		add(lblctgproduto, gbc_lblctgproduto);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 6;
		gbc_comboBox_2.gridy = 0;
		add(comboBox_2, gbc_comboBox_2);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 1;
		add(lblCliente, gbc_lblCliente);
		
		txf_cliente = new JTextField();
		GridBagConstraints gbc_txf_cliente = new GridBagConstraints();
		gbc_txf_cliente.gridwidth = 3;
		gbc_txf_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_txf_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_cliente.gridx = 1;
		gbc_txf_cliente.gridy = 1;
		add(txf_cliente, gbc_txf_cliente);
		txf_cliente.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltrar.gridx = 4;
		gbc_btnFiltrar.gridy = 1;
		add(btnFiltrar, gbc_btnFiltrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 5;
		gbc_btnAtualizar.gridy = 1;
		add(btnAtualizar, gbc_btnAtualizar);
		
		JButton btnGerarPdf = new JButton("Gerar PDF");
		btnGerarPdf.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnGerarPdf = new GridBagConstraints();
		gbc_btnGerarPdf.insets = new Insets(0, 0, 5, 0);
		gbc_btnGerarPdf.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGerarPdf.gridx = 6;
		gbc_btnGerarPdf.gridy = 1;
		add(btnGerarPdf, gbc_btnGerarPdf);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		tablevenda = new JTable();
		tablevenda.setFont(new Font("Consolas", Font.BOLD, 11));
		scrollPane.setViewportView(tablevenda);

	}

}
