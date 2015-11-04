package Telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MioloCadastroVendas extends JPanel {
	private JTextField txf_codvenda;
	private JTextField txf_vlrtotal;
	private JTextField txf_vlrpago;
	private JTextField txf_troco;
	private JTextField txf_datacompra;
	private JTextField txf_horacompra;

	/**
	 * Create the panel.
	 */
	public MioloCadastroVendas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lbl_codvenda = new JLabel("Codigo da Venda");
		GridBagConstraints gbc_lbl_codvenda = new GridBagConstraints();
		gbc_lbl_codvenda.anchor = GridBagConstraints.EAST;
		gbc_lbl_codvenda.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_codvenda.gridx = 0;
		gbc_lbl_codvenda.gridy = 0;
		add(lbl_codvenda, gbc_lbl_codvenda);
		
		txf_codvenda = new JTextField();
		GridBagConstraints gbc_txf_codvenda = new GridBagConstraints();
		gbc_txf_codvenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_codvenda.insets = new Insets(0, 0, 5, 0);
		gbc_txf_codvenda.gridx = 1;
		gbc_txf_codvenda.gridy = 0;
		add(txf_codvenda, gbc_txf_codvenda);
		txf_codvenda.setColumns(10);
		
		JLabel lbl_cliente = new JLabel("Cliente");
		GridBagConstraints gbc_lbl_cliente = new GridBagConstraints();
		gbc_lbl_cliente.anchor = GridBagConstraints.EAST;
		gbc_lbl_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_cliente.gridx = 0;
		gbc_lbl_cliente.gridy = 1;
		add(lbl_cliente, gbc_lbl_cliente);
		
		JComboBox cmbx_cliente = new JComboBox();
		GridBagConstraints gbc_cmbx_cliente = new GridBagConstraints();
		gbc_cmbx_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_cmbx_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbx_cliente.gridx = 1;
		gbc_cmbx_cliente.gridy = 1;
		add(cmbx_cliente, gbc_cmbx_cliente);
		
		JLabel lbl_produto = new JLabel("Produto");
		GridBagConstraints gbc_lbl_produto = new GridBagConstraints();
		gbc_lbl_produto.anchor = GridBagConstraints.EAST;
		gbc_lbl_produto.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_produto.gridx = 0;
		gbc_lbl_produto.gridy = 2;
		add(lbl_produto, gbc_lbl_produto);
		
		JComboBox cmbx_produto = new JComboBox();
		GridBagConstraints gbc_cmbx_produto = new GridBagConstraints();
		gbc_cmbx_produto.insets = new Insets(0, 0, 5, 0);
		gbc_cmbx_produto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbx_produto.gridx = 1;
		gbc_cmbx_produto.gridy = 2;
		add(cmbx_produto, gbc_cmbx_produto);
		
		JLabel lbl_vlrtotal = new JLabel("Valor Total");
		GridBagConstraints gbc_lbl_vlrtotal = new GridBagConstraints();
		gbc_lbl_vlrtotal.anchor = GridBagConstraints.EAST;
		gbc_lbl_vlrtotal.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_vlrtotal.gridx = 0;
		gbc_lbl_vlrtotal.gridy = 3;
		add(lbl_vlrtotal, gbc_lbl_vlrtotal);
		
		txf_vlrtotal = new JTextField();
		GridBagConstraints gbc_txf_vlrtotal = new GridBagConstraints();
		gbc_txf_vlrtotal.insets = new Insets(0, 0, 5, 0);
		gbc_txf_vlrtotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_vlrtotal.gridx = 1;
		gbc_txf_vlrtotal.gridy = 3;
		add(txf_vlrtotal, gbc_txf_vlrtotal);
		txf_vlrtotal.setColumns(10);
		
		JLabel lbl_vlrpago = new JLabel("Valor Pago");
		GridBagConstraints gbc_lbl_vlrpago = new GridBagConstraints();
		gbc_lbl_vlrpago.anchor = GridBagConstraints.EAST;
		gbc_lbl_vlrpago.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_vlrpago.gridx = 0;
		gbc_lbl_vlrpago.gridy = 4;
		add(lbl_vlrpago, gbc_lbl_vlrpago);
		
		txf_vlrpago = new JTextField();
		GridBagConstraints gbc_txf_vlrpago = new GridBagConstraints();
		gbc_txf_vlrpago.insets = new Insets(0, 0, 5, 0);
		gbc_txf_vlrpago.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_vlrpago.gridx = 1;
		gbc_txf_vlrpago.gridy = 4;
		add(txf_vlrpago, gbc_txf_vlrpago);
		txf_vlrpago.setColumns(10);
		
		JLabel lbl_troco = new JLabel("Troco");
		GridBagConstraints gbc_lbl_troco = new GridBagConstraints();
		gbc_lbl_troco.anchor = GridBagConstraints.EAST;
		gbc_lbl_troco.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_troco.gridx = 0;
		gbc_lbl_troco.gridy = 5;
		add(lbl_troco, gbc_lbl_troco);
		
		txf_troco = new JTextField();
		GridBagConstraints gbc_txf_troco = new GridBagConstraints();
		gbc_txf_troco.insets = new Insets(0, 0, 5, 0);
		gbc_txf_troco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_troco.gridx = 1;
		gbc_txf_troco.gridy = 5;
		add(txf_troco, gbc_txf_troco);
		txf_troco.setColumns(10);
		
		JLabel lbl_datacompra = new JLabel("Data da Compra");
		GridBagConstraints gbc_lbl_datacompra = new GridBagConstraints();
		gbc_lbl_datacompra.anchor = GridBagConstraints.EAST;
		gbc_lbl_datacompra.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_datacompra.gridx = 0;
		gbc_lbl_datacompra.gridy = 6;
		add(lbl_datacompra, gbc_lbl_datacompra);
		
		txf_datacompra = new JTextField();
		GridBagConstraints gbc_txf_datacompra = new GridBagConstraints();
		gbc_txf_datacompra.insets = new Insets(0, 0, 5, 0);
		gbc_txf_datacompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_datacompra.gridx = 1;
		gbc_txf_datacompra.gridy = 6;
		add(txf_datacompra, gbc_txf_datacompra);
		txf_datacompra.setColumns(10);
		
		JLabel lbl_horacompra = new JLabel("Hor\u00E1rio de compra");
		GridBagConstraints gbc_lbl_horacompra = new GridBagConstraints();
		gbc_lbl_horacompra.anchor = GridBagConstraints.EAST;
		gbc_lbl_horacompra.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_horacompra.gridx = 0;
		gbc_lbl_horacompra.gridy = 7;
		add(lbl_horacompra, gbc_lbl_horacompra);
		
		txf_horacompra = new JTextField();
		GridBagConstraints gbc_txf_horacompra = new GridBagConstraints();
		gbc_txf_horacompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_horacompra.gridx = 1;
		gbc_txf_horacompra.gridy = 7;
		add(txf_horacompra, gbc_txf_horacompra);
		txf_horacompra.setColumns(10);

	}

}
