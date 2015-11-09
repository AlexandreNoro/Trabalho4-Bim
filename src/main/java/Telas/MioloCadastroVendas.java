package Telas;

/**
 * @author Alexandre Henrique Noro 4 de nov de 2015 - 21:19:19
 */
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import AcessoAoBanco.ClienteDaoAcesso;
import AcessoAoBanco.ProdutoDaoAcesso;
import AcessoAoBanco.VendaDaoAcesso;
import Tables.TabelaVendas;
import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Produto;
import br.univel.cadastroCliente.Vendas;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MioloCadastroVendas extends JPanel {
	private JTextField txf_codvenda;
	private JTextField txf_vlrtotal;
	private JTextField txf_vlrpago;
	private JTextField txf_troco;
	private JTextField txf_datacompra;
	private JTextField txf_horacompra;
	private JTable tablemiolovendas;

	private TabelaVendas tabelaVendas;
	private VendaDaoAcesso vda = new VendaDaoAcesso();
	private List<Vendas> listavendas = new ArrayList<>();
	protected int in = -1;

	private List<Cliente> listacliente = new ArrayList<Cliente>();
	private List<Produto> listaproduto = new ArrayList<Produto>();
	private JComboBox<String> cmbx_produto;
	private JComboBox<String> cmbx_cliente;

	/**
	 * Create the panel.
	 */
	public MioloCadastroVendas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 130, 130, 130, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lbl_codvenda = new JLabel("Codigo da Venda");
		lbl_codvenda.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_codvenda = new GridBagConstraints();
		gbc_lbl_codvenda.anchor = GridBagConstraints.EAST;
		gbc_lbl_codvenda.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_codvenda.gridx = 0;
		gbc_lbl_codvenda.gridy = 0;
		add(lbl_codvenda, gbc_lbl_codvenda);

		txf_codvenda = new JTextField();
		txf_codvenda.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txf_codvenda = new GridBagConstraints();
		gbc_txf_codvenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_codvenda.insets = new Insets(0, 0, 5, 5);
		gbc_txf_codvenda.gridx = 1;
		gbc_txf_codvenda.gridy = 0;
		add(txf_codvenda, gbc_txf_codvenda);
		txf_codvenda.setColumns(10);

		JLabel lbl_cliente = new JLabel("Cliente");
		lbl_cliente.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_cliente = new GridBagConstraints();
		gbc_lbl_cliente.anchor = GridBagConstraints.EAST;
		gbc_lbl_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_cliente.gridx = 0;
		gbc_lbl_cliente.gridy = 1;
		add(lbl_cliente, gbc_lbl_cliente);

		cmbx_cliente = new JComboBox();
		cmbx_cliente.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_cmbx_cliente = new GridBagConstraints();
		gbc_cmbx_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbx_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_cmbx_cliente.gridx = 1;
		gbc_cmbx_cliente.gridy = 1;
		add(cmbx_cliente, gbc_cmbx_cliente);

		JLabel lbl_produto = new JLabel("Produto");
		lbl_produto.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_produto = new GridBagConstraints();
		gbc_lbl_produto.anchor = GridBagConstraints.EAST;
		gbc_lbl_produto.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_produto.gridx = 0;
		gbc_lbl_produto.gridy = 2;
		add(lbl_produto, gbc_lbl_produto);

		cmbx_produto = new JComboBox();
		cmbx_produto.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_cmbx_produto = new GridBagConstraints();
		gbc_cmbx_produto.insets = new Insets(0, 0, 5, 5);
		gbc_cmbx_produto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbx_produto.gridx = 1;
		gbc_cmbx_produto.gridy = 2;
		add(cmbx_produto, gbc_cmbx_produto);

		JLabel lbl_vlrtotal = new JLabel("Valor Total");
		lbl_vlrtotal.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_vlrtotal = new GridBagConstraints();
		gbc_lbl_vlrtotal.anchor = GridBagConstraints.EAST;
		gbc_lbl_vlrtotal.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_vlrtotal.gridx = 0;
		gbc_lbl_vlrtotal.gridy = 3;
		add(lbl_vlrtotal, gbc_lbl_vlrtotal);

		txf_vlrtotal = new JTextField();
		txf_vlrtotal.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txf_vlrtotal = new GridBagConstraints();
		gbc_txf_vlrtotal.insets = new Insets(0, 0, 5, 5);
		gbc_txf_vlrtotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_vlrtotal.gridx = 1;
		gbc_txf_vlrtotal.gridy = 3;
		add(txf_vlrtotal, gbc_txf_vlrtotal);
		txf_vlrtotal.setColumns(10);

		JLabel lbl_vlrpago = new JLabel("Valor Pago");
		lbl_vlrpago.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_vlrpago = new GridBagConstraints();
		gbc_lbl_vlrpago.anchor = GridBagConstraints.EAST;
		gbc_lbl_vlrpago.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_vlrpago.gridx = 0;
		gbc_lbl_vlrpago.gridy = 4;
		add(lbl_vlrpago, gbc_lbl_vlrpago);

		txf_vlrpago = new JTextField();
		txf_vlrpago.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txf_vlrpago = new GridBagConstraints();
		gbc_txf_vlrpago.insets = new Insets(0, 0, 5, 5);
		gbc_txf_vlrpago.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_vlrpago.gridx = 1;
		gbc_txf_vlrpago.gridy = 4;
		add(txf_vlrpago, gbc_txf_vlrpago);
		txf_vlrpago.setColumns(10);

		JLabel lbl_troco = new JLabel("Troco");
		lbl_troco.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_troco = new GridBagConstraints();
		gbc_lbl_troco.anchor = GridBagConstraints.EAST;
		gbc_lbl_troco.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_troco.gridx = 0;
		gbc_lbl_troco.gridy = 5;
		add(lbl_troco, gbc_lbl_troco);

		txf_troco = new JTextField();
		txf_troco.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txf_troco = new GridBagConstraints();
		gbc_txf_troco.insets = new Insets(0, 0, 5, 5);
		gbc_txf_troco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_troco.gridx = 1;
		gbc_txf_troco.gridy = 5;
		add(txf_troco, gbc_txf_troco);
		txf_troco.setColumns(10);

		JLabel lbl_datacompra = new JLabel("Data da Compra");
		lbl_datacompra.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_datacompra = new GridBagConstraints();
		gbc_lbl_datacompra.anchor = GridBagConstraints.EAST;
		gbc_lbl_datacompra.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_datacompra.gridx = 0;
		gbc_lbl_datacompra.gridy = 6;
		add(lbl_datacompra, gbc_lbl_datacompra);

		txf_datacompra = new JTextField();
		txf_datacompra.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txf_datacompra = new GridBagConstraints();
		gbc_txf_datacompra.insets = new Insets(0, 0, 5, 5);
		gbc_txf_datacompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_datacompra.gridx = 1;
		gbc_txf_datacompra.gridy = 6;
		add(txf_datacompra, gbc_txf_datacompra);
		txf_datacompra.setColumns(10);

		JLabel lbl_horacompra = new JLabel("Hor\u00E1rio de compra");
		lbl_horacompra.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lbl_horacompra = new GridBagConstraints();
		gbc_lbl_horacompra.anchor = GridBagConstraints.EAST;
		gbc_lbl_horacompra.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_horacompra.gridx = 0;
		gbc_lbl_horacompra.gridy = 7;
		add(lbl_horacompra, gbc_lbl_horacompra);

		txf_horacompra = new JTextField();
		txf_horacompra.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txf_horacompra = new GridBagConstraints();
		gbc_txf_horacompra.insets = new Insets(0, 0, 5, 5);
		gbc_txf_horacompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_horacompra.gridx = 1;
		gbc_txf_horacompra.gridy = 7;
		add(txf_horacompra, gbc_txf_horacompra);
		txf_horacompra.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Gravar();

			}
		});
		btnGravar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnGravar = new GridBagConstraints();
		gbc_btnGravar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGravar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGravar.gridx = 1;
		gbc_btnGravar.gridy = 8;
		add(btnGravar, gbc_btnGravar);

		JButton btnEditar = new JButton("Alterar");
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Editar();

			}
		});
		btnEditar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditar.gridx = 2;
		gbc_btnEditar.gridy = 8;
		add(btnEditar, gbc_btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Excluir();

			}
		});
		btnExcluir.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 0);
		gbc_btnExcluir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 8;
		add(btnExcluir, gbc_btnExcluir);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		add(scrollPane, gbc_scrollPane);

		tablemiolovendas = new JTable();
		tablemiolovendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) {
					Vendas v = (Vendas) listavendas.get(tablemiolovendas.getSelectedRow());
					retornaVendas(v);
					in = tablemiolovendas.getSelectedRow();
				}
				
			}
		});
		tablemiolovendas.setFont(new Font("Consolas", Font.BOLD, 11));
		scrollPane.setViewportView(tablemiolovendas);

		listaVendas();
		
		mostraNosCombobox();
		
	}

	protected void Gravar() {
		Vendas v = new Vendas(listacliente.get(cmbx_cliente.getSelectedIndex() - 1).getId(),
				listaproduto.get(cmbx_produto.getSelectedIndex() - 1).getcod_p(),
				String.valueOf(cmbx_cliente.getSelectedItem()), String.valueOf(cmbx_produto.getSelectedItem()),
				BigDecimal.valueOf(Double.valueOf(txf_vlrtotal.getText())),
				BigDecimal.valueOf(Double.valueOf(txf_vlrpago.getText())),
				BigDecimal.valueOf(Double.valueOf(txf_troco.getText())), txf_datacompra.getText(),
				txf_horacompra.getText());

		vda.inserir(v);
		listavendas = vda.listar();
		tabelaVendas.addLista(listavendas);
		limpar();

	}

	protected void Editar() {

		if (in > -1) {
			Vendas v = new Vendas(Integer.parseInt(txf_codvenda.getText()),
					listacliente.get(cmbx_cliente.getSelectedIndex() - 1).getId(),
					listaproduto.get(cmbx_produto.getSelectedIndex() - 1).getcod_p(),
					String.valueOf(cmbx_cliente.getSelectedItem()), String.valueOf(cmbx_produto.getSelectedItem()),
					BigDecimal.valueOf(Double.valueOf(txf_vlrtotal.getText())),
					BigDecimal.valueOf(Double.valueOf(txf_vlrpago.getText())),
					BigDecimal.valueOf(Double.valueOf(txf_troco.getText())), txf_datacompra.getText(),
					txf_horacompra.getText());

			vda.inserir(v);
			listavendas = vda.listar();
			tabelaVendas.addLista(listavendas);
			limpar();
			in = -1;
		} else {
			JOptionPane.showMessageDialog(null, "Escolha a venda para excluir!!!");
		}

	}

	protected void Excluir() {

		vda.excluir(tablemiolovendas.getSelectedRow());
		tabelaVendas.excluir(tablemiolovendas.getSelectedRow());

	}

	private void limpar() {
		txf_codvenda.setText("");
		cmbx_cliente.setSelectedIndex(0);
		cmbx_produto.setSelectedIndex(0);
		txf_vlrtotal.setText("");
		txf_vlrpago.setText("");
		txf_troco.setText("");

	}

	public void retornaVendas(Vendas v) {

		txf_codvenda.setText(String.valueOf(v.getIdcod_venda()));
		cmbx_cliente.setSelectedItem(v.getCliente());
		cmbx_produto.setSelectedItem(v.getProduto());
		txf_vlrtotal.setText(String.valueOf(v.getVlrtotal()));
		txf_vlrpago.setText(String.valueOf(v.getVlrPago()));
		txf_troco.setText(String.valueOf(v.getTroco()));
		txf_datacompra.setText(v.getDatacompra());
		txf_horacompra.setText(v.getHoracompra());

	}
	
	private void mostraNosCombobox(){
		ClienteDaoAcesso cda = new ClienteDaoAcesso();
		listacliente = cda.listar();
		ProdutoDaoAcesso pda = new ProdutoDaoAcesso();
		listaproduto = pda.listar();
		int aux = 0;
		
		for (Cliente c : listacliente) {
			if (aux == 0) {
				aux = 1;
				cmbx_cliente.addItem("");
			}
			cmbx_cliente.addItem(c.getNome());
		}
		
		aux = 0;
		
		for(Produto p : listaproduto){
			if (aux == 0) {
				aux = 1;
				cmbx_produto.addItem("");
			}
			cmbx_produto.addItem(p.getDescricao());
		}
	}
	
	private void listaVendas() {

		new Thread(new Runnable() {

			public void run() {
				tabelaVendas = new TabelaVendas();
				listavendas = tabelaVendas.listar();
				tablemiolovendas.setModel(tabelaVendas);
			}
		}).start();
	}


}
