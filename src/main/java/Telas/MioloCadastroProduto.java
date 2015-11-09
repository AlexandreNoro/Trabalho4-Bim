package Telas;

/**
 * @author Alexandre Henrique Noro 4 de nov de 2015 - 19:13:36
 */
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import AcessoAoBanco.ProdutoDaoAcesso;
import Tables.TabelaProduto;
import br.univel.cadastroCliente.Produto;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

public class MioloCadastroProduto extends JPanel {
	private JTextField txfId;
	private JTextField txfCodigo;
	private JTextField txfCategoria;
	private JTextField txfDescricao;
	private JTextField txfUnidade;
	private JTextField txfcusto;
	private JTextField txflucro;
	private JButton btnGravar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JScrollPane scrollPane;
	private JTable tablemioloproduto;

	private TabelaProduto tabelaProduto;
	private ProdutoDaoAcesso pda = new ProdutoDaoAcesso();
	private List<Produto> listaproduto = new ArrayList<>();
	private int in = -1;

	/**
	 * Create the panel.
	 */
	public MioloCadastroProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 150, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 1;
		add(lblCodigo, gbc_lblCodigo);

		txfCodigo = new JTextField();
		txfCodigo.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfCodigo = new GridBagConstraints();
		gbc_txfCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_txfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCodigo.gridx = 1;
		gbc_txfCodigo.gridy = 1;
		add(txfCodigo, gbc_txfCodigo);
		txfCodigo.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 2;
		add(lblCategoria, gbc_lblCategoria);

		txfCategoria = new JTextField();
		txfCategoria.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfCategoria = new GridBagConstraints();
		gbc_txfCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_txfCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCategoria.gridx = 1;
		gbc_txfCategoria.gridy = 2;
		add(txfCategoria, gbc_txfCategoria);
		txfCategoria.setColumns(10);

		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.anchor = GridBagConstraints.EAST;
		gbc_lblDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescricao.gridx = 0;
		gbc_lblDescricao.gridy = 3;
		add(lblDescricao, gbc_lblDescricao);

		txfDescricao = new JTextField();
		txfDescricao.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfDescricao = new GridBagConstraints();
		gbc_txfDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_txfDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDescricao.gridx = 1;
		gbc_txfDescricao.gridy = 3;
		add(txfDescricao, gbc_txfDescricao);
		txfDescricao.setColumns(10);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.EAST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidade.gridx = 0;
		gbc_lblUnidade.gridy = 4;
		add(lblUnidade, gbc_lblUnidade);

		txfUnidade = new JTextField();
		txfUnidade.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfUnidade = new GridBagConstraints();
		gbc_txfUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_txfUnidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfUnidade.gridx = 1;
		gbc_txfUnidade.gridy = 4;
		add(txfUnidade, gbc_txfUnidade);
		txfUnidade.setColumns(10);

		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.EAST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 0;
		gbc_lblCusto.gridy = 5;
		add(lblCusto, gbc_lblCusto);

		txfcusto = new JTextField();
		txfcusto.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfcusto = new GridBagConstraints();
		gbc_txfcusto.insets = new Insets(0, 0, 5, 5);
		gbc_txfcusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfcusto.gridx = 1;
		gbc_txfcusto.gridy = 5;
		add(txfcusto, gbc_txfcusto);
		txfcusto.setColumns(10);

		JLabel lblMlucro = new JLabel("Lucro");
		lblMlucro.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblMlucro = new GridBagConstraints();
		gbc_lblMlucro.anchor = GridBagConstraints.EAST;
		gbc_lblMlucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMlucro.gridx = 0;
		gbc_lblMlucro.gridy = 6;
		add(lblMlucro, gbc_lblMlucro);

		txflucro = new JTextField();
		txflucro.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txflucro = new GridBagConstraints();
		gbc_txflucro.insets = new Insets(0, 0, 5, 5);
		gbc_txflucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txflucro.gridx = 1;
		gbc_txflucro.gridy = 6;
		add(txflucro, gbc_txflucro);
		txflucro.setColumns(10);

		btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Gravar();

			}
		});
		btnGravar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnGravar = new GridBagConstraints();
		gbc_btnGravar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGravar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGravar.gridx = 2;
		gbc_btnGravar.gridy = 7;
		add(btnGravar, gbc_btnGravar);

		btnEditar = new JButton("Alterar");
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
		gbc_btnEditar.gridx = 3;
		gbc_btnEditar.gridy = 7;
		add(btnEditar, gbc_btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Excluir();

			}
		});
		btnExcluir.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 0);
		gbc_btnExcluir.gridx = 4;
		gbc_btnExcluir.gridy = 7;
		add(btnExcluir, gbc_btnExcluir);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);

		tablemioloproduto = new JTable();
		tablemioloproduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) {
					Produto p = (Produto) listaproduto.get(tablemioloproduto.getSelectedRow());
					retornaProduto(p);
					in = tablemioloproduto.getSelectedRow();
				}

			}
		});

		tablemioloproduto.setFont(new Font("Consolas", Font.BOLD, 11));
		scrollPane.setViewportView(tablemioloproduto);

		listaProduto();
	}

	private void listaProduto() {
		new Thread(new Runnable() {

			public void run() {
				tabelaProduto = new TabelaProduto();
				listaproduto = tabelaProduto.listar();
				tablemioloproduto.setModel(tabelaProduto);
			}
		}).start();

	}

	protected void Gravar() {

		Produto p = new Produto(Integer.parseInt(txfCodigo.getText()), txfCategoria.getText(), txfDescricao.getText(),
				txfUnidade.getText(), BigDecimal.valueOf(Double.parseDouble(txfcusto.getText())),
				BigDecimal.valueOf(Double.parseDouble(txflucro.getText())));

		pda.inserir(p);
		listaproduto = pda.listar();
		tabelaProduto.addLista(listaproduto);
		limpar();

	}

	protected void Editar() {

		if (in > -1) {
			Produto p = new Produto(Integer.parseInt(txfId.getText()), Integer.parseInt(txfCodigo.getText()),
					txfCategoria.getText(), txfDescricao.getText(), txfUnidade.getText(),
					BigDecimal.valueOf(Double.parseDouble(txfcusto.getText())),
					BigDecimal.valueOf(Double.parseDouble(txflucro.getText())));

			pda.atualizar(p);
			tabelaProduto.atualizaLista(in, p);
			limpar();
			in = -1;
		} else {
			JOptionPane.showMessageDialog(null, "Escolha o produto que deseja modificar!!!");
		}

	}

	protected void Excluir() {

		pda.excluir(tablemioloproduto.getSelectedRow());
		tabelaProduto.excluir(tablemioloproduto.getSelectedRow());

	}

	private void limpar() {

		txfId.setText("");
		txfCodigo.setText("");
		txfCategoria.setText("");
		txfDescricao.setText("");
		txfcusto.setText("");
		txflucro.setText("");
	}

	public void retornaProduto(Produto p) {
		txfId.setText(String.valueOf(p.getcod_p()));
		txfCodigo.setText(String.valueOf(p.getCodbarra()));
		txfCategoria.setText(p.getCategoria());
		txfDescricao.setText(p.getDescricao());
		txfUnidade.setText(p.getUnidade());
		txfcusto.setText(String.valueOf(p.getCusto()));
		txfUnidade.setText(String.valueOf(p.getMargemlucro()));

	}

}
