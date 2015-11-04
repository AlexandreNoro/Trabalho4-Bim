package Relatorios;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RelatorioProduto extends JPanel {
	private JTextField textField;
	private JTable tableproduto;

	/**
	 * Create the panel.
	 */
	public RelatorioProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 120, 80, 110, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro:");
		lblMargemDeLucro.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblMargemDeLucro = new GridBagConstraints();
		gbc_lblMargemDeLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMargemDeLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemDeLucro.gridx = 0;
		gbc_lblMargemDeLucro.gridy = 0;
		add(lblMargemDeLucro, gbc_lblMargemDeLucro);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.gridx = 2;
		gbc_lblCategoria.gridy = 0;
		add(lblCategoria, gbc_lblCategoria);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 1;
		add(btnFiltrar, gbc_btnFiltrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 2;
		gbc_btnAtualizar.gridy = 1;
		add(btnAtualizar, gbc_btnAtualizar);
		
		JButton btnGerarPdf = new JButton("Gerar PDF");
		btnGerarPdf.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnGerarPdf = new GridBagConstraints();
		gbc_btnGerarPdf.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGerarPdf.insets = new Insets(0, 0, 5, 0);
		gbc_btnGerarPdf.gridx = 3;
		gbc_btnGerarPdf.gridy = 1;
		add(btnGerarPdf, gbc_btnGerarPdf);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		tableproduto = new JTable();
		tableproduto.setFont(new Font("Consolas", Font.BOLD, 11));
		scrollPane.setViewportView(tableproduto);

	}

}
