package Telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class MioloCadastroProduto extends JPanel {
	private JTextField txfId;
	private JTextField txfCodigo;
	private JTextField txfCategoria;
	private JTextField txfDescricao;
	private JTextField txfUnidade;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public MioloCadastroProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 1;
		add(lblCodigo, gbc_lblCodigo);
		
		txfCodigo = new JTextField();
		GridBagConstraints gbc_txfCodigo = new GridBagConstraints();
		gbc_txfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_txfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCodigo.gridx = 1;
		gbc_txfCodigo.gridy = 1;
		add(txfCodigo, gbc_txfCodigo);
		txfCodigo.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 2;
		add(lblCategoria, gbc_lblCategoria);
		
		txfCategoria = new JTextField();
		GridBagConstraints gbc_txfCategoria = new GridBagConstraints();
		gbc_txfCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_txfCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCategoria.gridx = 1;
		gbc_txfCategoria.gridy = 2;
		add(txfCategoria, gbc_txfCategoria);
		txfCategoria.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao");
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.anchor = GridBagConstraints.EAST;
		gbc_lblDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescricao.gridx = 0;
		gbc_lblDescricao.gridy = 3;
		add(lblDescricao, gbc_lblDescricao);
		
		txfDescricao = new JTextField();
		GridBagConstraints gbc_txfDescricao = new GridBagConstraints();
		gbc_txfDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txfDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDescricao.gridx = 1;
		gbc_txfDescricao.gridy = 3;
		add(txfDescricao, gbc_txfDescricao);
		txfDescricao.setColumns(10);
		
		JLabel lblUnidade = new JLabel("Unidade");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.EAST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidade.gridx = 0;
		gbc_lblUnidade.gridy = 4;
		add(lblUnidade, gbc_lblUnidade);
		
		txfUnidade = new JTextField();
		GridBagConstraints gbc_txfUnidade = new GridBagConstraints();
		gbc_txfUnidade.insets = new Insets(0, 0, 5, 0);
		gbc_txfUnidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfUnidade.gridx = 1;
		gbc_txfUnidade.gridy = 4;
		add(txfUnidade, gbc_txfUnidade);
		txfUnidade.setColumns(10);
		
		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.EAST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 0;
		gbc_lblCusto.gridy = 5;
		add(lblCusto, gbc_lblCusto);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblMlucro = new JLabel("Lucro");
		GridBagConstraints gbc_lblMlucro = new GridBagConstraints();
		gbc_lblMlucro.anchor = GridBagConstraints.EAST;
		gbc_lblMlucro.insets = new Insets(0, 0, 0, 5);
		gbc_lblMlucro.gridx = 0;
		gbc_lblMlucro.gridy = 6;
		add(lblMlucro, gbc_lblMlucro);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 6;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

	}

}
