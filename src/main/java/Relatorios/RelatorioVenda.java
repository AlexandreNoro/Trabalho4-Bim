package Relatorios;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import java.awt.Desktop;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import AcessoAoBanco.RelatorioDaoAcesso;
import Tables.TabelaVendas;
import br.univel.cadastroCliente.Vendas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioVenda extends JPanel {
	private JTextField txf_cliente;
	private JTable tablevenda;

	private List<Vendas> listaVenda = new ArrayList<Vendas>();
	private JComboBox<String> cbx_catProd;
	private JComboBox<Object> cbx_mes;
	private JComboBox<Object> cbx_dia;

	private TabelaVendas tbModelVenda;
								//Nome do arquivo pdf gerado
	private static String ARQ_PDF = "relatorio de Venda.pdf";
								//Caminho de onde está o arquivo jasper
	private String arq = "C:\\Users\\Alexandre H. Noro\\git\\Trabalho4-Bim\\src\\main\\resources\\RelatorioVenda.jasper";

	/**
	 * Create the panel.
	 */
	public RelatorioVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 85, 0, 0, 85, 0, 88, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblDia = new JLabel("Dia: ");
		lblDia.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.anchor = GridBagConstraints.EAST;
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 0;
		gbc_lblDia.gridy = 0;
		add(lblDia, gbc_lblDia);

		cbx_dia = new JComboBox<>();
		GridBagConstraints gbc_cbx_dia = new GridBagConstraints();
		gbc_cbx_dia.insets = new Insets(0, 0, 5, 5);
		gbc_cbx_dia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_dia.gridx = 1;
		gbc_cbx_dia.gridy = 0;
		add(cbx_dia, gbc_cbx_dia);

		JLabel lblmes = new JLabel("M\u00EAs: ");
		lblmes.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblmes = new GridBagConstraints();
		gbc_lblmes.anchor = GridBagConstraints.EAST;
		gbc_lblmes.insets = new Insets(0, 0, 5, 5);
		gbc_lblmes.gridx = 3;
		gbc_lblmes.gridy = 0;
		add(lblmes, gbc_lblmes);

		cbx_mes = new JComboBox<>();
		GridBagConstraints gbc_cbx_mes = new GridBagConstraints();
		gbc_cbx_mes.insets = new Insets(0, 0, 5, 5);
		gbc_cbx_mes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_mes.gridx = 4;
		gbc_cbx_mes.gridy = 0;
		add(cbx_mes, gbc_cbx_mes);

		JLabel lblctgproduto = new JLabel("Categoria do Produto: ");
		lblctgproduto.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblctgproduto = new GridBagConstraints();
		gbc_lblctgproduto.anchor = GridBagConstraints.EAST;
		gbc_lblctgproduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblctgproduto.gridx = 5;
		gbc_lblctgproduto.gridy = 0;
		add(lblctgproduto, gbc_lblctgproduto);

		cbx_catProd = new JComboBox<>();
		GridBagConstraints gbc_cbx_catProd = new GridBagConstraints();
		gbc_cbx_catProd.insets = new Insets(0, 0, 5, 0);
		gbc_cbx_catProd.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_catProd.gridx = 6;
		gbc_cbx_catProd.gridy = 0;
		add(cbx_catProd, gbc_cbx_catProd);

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
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFiltrar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltrar.gridx = 4;
		gbc_btnFiltrar.gridy = 1;
		add(btnFiltrar, gbc_btnFiltrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloTable();
			}
		});
		btnAtualizar.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 5;
		gbc_btnAtualizar.gridy = 1;
		add(btnAtualizar, gbc_btnAtualizar);

		JButton btnGerarPdf = new JButton("Gerar PDF");
		btnGerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleReportDiretoPdf();
			}
		});
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

		// carregar modelo da table
		modeloTable();
		// carregar dia e mês
		carregarCBX();
		// carregar gategoria
		carregarCBXCateg();

	}
	//Carrega table na tela
	private void modeloTable() {
		tbModelVenda = new TabelaVendas();
		listaVenda = tbModelVenda.listar();
		new Thread(new Runnable() {
			@Override
			public void run() {
				tablevenda.setModel(tbModelVenda);
			}
		}).start();
	}

	// método pra carregar filtro de categoria
	private void carregarCBX() {
		for (int i = 1; i < 32; i++) {
			if (i <= 12) {
				if (i <= 9) {
					cbx_mes.addItem("0" + i);
					cbx_dia.addItem("0" + i);
				} else {
					cbx_mes.addItem(i);
					cbx_dia.addItem(i);
				}
			} else {
				cbx_dia.addItem(i);
			}
		}
	}

	// método pra carregar filtro de categoria no comboBox
	private void carregarCBXCateg() {
		RelatorioDaoAcesso d = new RelatorioDaoAcesso();
		List<String> lct = d.listarCategoriaProduto();
		for (int i = 0; i < lct.size(); i++) {
			int indice = 0;
			for (int j = 0; j < cbx_catProd.getItemCount(); j++) {
				if (lct.get(i).toString().equals(cbx_catProd.getItemAt(j).toString()))
					indice++;
				if (indice > 1)
					break;
			}
			if (indice < 1)
				cbx_catProd.addItem(lct.get(i).toString());
		}
	}
	//Cria o arquivo pdf
	public void SimpleReportDiretoPdf() {

		TableModel tableModel = getTableModelProduto();

		JasperPrint jp = null;
		try {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("endereco_c", "NOROSYSTEM");
			map.put("telefone_c", "(45)8817-9098");

			jp = JasperFillManager.fillReport(arq, map, new JRTableModelDataSource(tableModel));

			JasperExportManager.exportReportToPdfFile(jp, ARQ_PDF);

			JOptionPane.showMessageDialog(null, "<html>Arquivo exportado para PDF!<br><br>A aplicação vai pedir"
					+ " ao Sistema operacional <br>para abrir com o visualizador" + " padrão.");

			Desktop.getDesktop().open(new File(ARQ_PDF));

		} catch (JRException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// gera uma table com os dados presentes na tela

	private TableModel getTableModelProduto() {
		String[] columnNames = { "cod_v", "id_c", "cliente", "cod_p", "produto", "vtotal", "vpagamento", "troco", "data", "hora" };

		Object[][] data = new Object[listaVenda.size()][10];
		for (int i = 0; i < listaVenda.size(); i++) {
			int j = 0;
			data[i][j++] = listaVenda.get(i).getCod_v();
			data[i][j++] = listaVenda.get(i).getId_c();
			data[i][j++] = listaVenda.get(i).getCliente();
			data[i][j++] = listaVenda.get(i).getCod_p();
			data[i][j++] = listaVenda.get(i).getProduto();
			data[i][j++] = listaVenda.get(i).getvTotal();
			data[i][j++] = listaVenda.get(i).getvPago();
			data[i][j++] = listaVenda.get(i).getTroco();
			data[i][j++] = listaVenda.get(i).getData();
			data[i][j++] = listaVenda.get(i).getHora();
		}
		return new DefaultTableModel(data, columnNames);
	}

}
