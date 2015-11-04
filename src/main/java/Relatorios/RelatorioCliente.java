package Relatorios;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RelatorioCliente extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public RelatorioCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 95, 0, 129, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblFiltrarPorEstado = new JLabel("Filtrar por Estado:");
		lblFiltrarPorEstado.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblFiltrarPorEstado = new GridBagConstraints();
		gbc_lblFiltrarPorEstado.anchor = GridBagConstraints.EAST;
		gbc_lblFiltrarPorEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrarPorEstado.gridx = 0;
		gbc_lblFiltrarPorEstado.gridy = 0;
		add(lblFiltrarPorEstado, gbc_lblFiltrarPorEstado);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		JLabel lblFiltrarPorCidade = new JLabel("Filtrar por Cidade:");
		lblFiltrarPorCidade.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblFiltrarPorCidade = new GridBagConstraints();
		gbc_lblFiltrarPorCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrarPorCidade.anchor = GridBagConstraints.EAST;
		gbc_lblFiltrarPorCidade.gridx = 2;
		gbc_lblFiltrarPorCidade.gridy = 0;
		add(lblFiltrarPorCidade, gbc_lblFiltrarPorCidade);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 0;
		add(comboBox_1, gbc_comboBox_1);
		
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
		gbc_btnGerarPdf.insets = new Insets(0, 0, 5, 0);
		gbc_btnGerarPdf.fill = GridBagConstraints.HORIZONTAL;
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
		
		table = new JTable();
		table.setFont(new Font("Consolas", Font.BOLD, 11));
		scrollPane.setViewportView(table);

	}

}
