package Relatorios;

/**
 * @author Alexandre Henrique Noro 6 de nov de 2015 - 21:33:48
 */
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Tables.TabelaProduto;
import br.univel.cadastroCliente.Produto;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RelatorioProduto extends JPanel {
	private JTextField txf_mrglucro;
	private JTable tableproduto;
	private JComboBox<String> cmbx_catg;

	private static String ARQ_PDF = "relatorio de produto.pdf";
	private String arq = "C:\\Users\\Alexandre H. Noro\\git\\Trabalho4-Bim\\src\\main\\resources\\RelatorioProduto.jasper";
	private List<Produto> listaproduto;
	private TabelaProduto tabelaProduto;

	/**
	 * Create the panel.
	 */
	public RelatorioProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 120, 80, 110, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro:");
		lblMargemDeLucro.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblMargemDeLucro = new GridBagConstraints();
		gbc_lblMargemDeLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMargemDeLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemDeLucro.gridx = 0;
		gbc_lblMargemDeLucro.gridy = 0;
		add(lblMargemDeLucro, gbc_lblMargemDeLucro);

		txf_mrglucro = new JTextField();
		GridBagConstraints gbc_txf_mrglucro = new GridBagConstraints();
		gbc_txf_mrglucro.insets = new Insets(0, 0, 5, 5);
		gbc_txf_mrglucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_mrglucro.gridx = 1;
		gbc_txf_mrglucro.gridy = 0;
		add(txf_mrglucro, gbc_txf_mrglucro);
		txf_mrglucro.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.gridx = 2;
		gbc_lblCategoria.gridy = 0;
		add(lblCategoria, gbc_lblCategoria);

		cmbx_catg = new JComboBox();
		GridBagConstraints gbc_cmbx_catg = new GridBagConstraints();
		gbc_cmbx_catg.insets = new Insets(0, 0, 5, 0);
		gbc_cmbx_catg.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbx_catg.gridx = 3;
		gbc_cmbx_catg.gridy = 0;
		add(cmbx_catg, gbc_cmbx_catg);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gerarsql();

			}
		});
		btnFiltrar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 1;
		add(btnFiltrar, gbc_btnFiltrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				atualizaTabela();

			}
		});
		btnAtualizar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 2;
		gbc_btnAtualizar.gridy = 1;
		add(btnAtualizar, gbc_btnAtualizar);

		JButton btnGerarPdf = new JButton("Gerar PDF");
		btnGerarPdf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gerarpdf();

			}
		});
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

		atualizaTabela();

		preencherCMBX();

	}

	private void preencherCMBX() {
		for (int i = 0; i < listaproduto.size(); i++) {
			int in = 0;

			if (i == 0) {
				cmbx_catg.addItem("");
			}

			for (int x = 0; x < cmbx_catg.getItemCount(); x++) {
				if (listaproduto.get(i).getCategoria().equals(cmbx_catg.getItemAt(x).toString())) {
					in++;
					if (in > 1) {
						break;
					}
				}
				if (in < 1)
					cmbx_catg.addItem(listaproduto.get(i).getCategoria());
				{

				}
			}
		}

	}

	protected void gerarpdf() {
		TableModel tabelamodelo = getTabelaProduto();

		JasperPrint jsp = null;

		try {

			Map<String, Object> mp = new HashMap<>();
			mp.put("endereco_c", "Avenida Curitiba, 681");
			mp.put("telefone_c", "(45)8817-9098");

			jsp = JasperFillManager.fillReport(arq, mp, new JRTableModelDataSource(tabelamodelo));

			JasperExportManager.exportReportToPdfFile(jsp, ARQ_PDF);
			Desktop.getDesktop().open(new File(ARQ_PDF));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private TableModel getTabelaProduto() {
		String[] columnNames = { "cod_p", "cod_barra", "categoria", "descricao", "unidade", "custo", "marge_lucro" };
		
		
		Object[][] dados = new Object[listaproduto.size()][8];
		for (int i = 0; i < listaproduto.size(); i++) {
			int x = 0;
			dados[i][x++] = Long.valueOf(listaproduto.get(i).getcod_p());
			dados[i][x++] = listaproduto.get(i).getCodbarra();
			dados[i][x++] = listaproduto.get(i).getCategoria();
			dados[i][x++] = listaproduto.get(i).getDescricao();
			dados[i][x++] = listaproduto.get(i).getUnidade();
			dados[i][x++] = listaproduto.get(i).getCusto();
			dados[i][x++] = listaproduto.get(i).getMargemlucro();
		}

		return new DefaultTableModel(dados, columnNames);

	}

	

	protected void atualizaTabela() {
		tabelaProduto = new TabelaProduto();
		listaproduto = tabelaProduto.listar();
		new Thread(new Runnable() {
			public void run() {
				tableproduto.setModel(tabelaProduto);
			}
		}).start();

	}

	protected void gerarsql() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT cod_p, cod_barra, categoria, descricao, unidade, custo, marge_lucro FROM PRODUTO");

		try {
			if (Double.valueOf(txf_mrglucro.getText()) > 0) {
				txf_mrglucro.setBackground(Color.WHITE);
				sb.append(" WHERE MARGE_LUCRO >= '" + txf_mrglucro.getText() + "'");
				if (cmbx_catg.getSelectedItem() != null)
					sb.append(" AND CATEGORIA = '" + cmbx_catg.getSelectedItem() + "'");

			} else if (cmbx_catg.getSelectedItem() != null) {
				sb.append(" WHERE CATEGORIA = '" + cmbx_catg.getSelectedItem() + "'");

			}
			listaproduto = tabelaProduto.mostraRelatorio(sb.toString());
			tableproduto.setModel(tabelaProduto);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, " Digite apenas números!!!!");
			txf_mrglucro.setBackground(Color.blue);
			txf_mrglucro.setFocusable(true);
		}

	}

}
