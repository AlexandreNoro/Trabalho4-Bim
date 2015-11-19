package Relatorios;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Desktop;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Tables.TabelaCliente;
import Tables.TabelaProduto;
import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Estado;
import br.univel.cadastroCliente.Genero;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

public class RelatorioCliente extends JPanel {
	private JTable tablecliente;
	private JComboBox<String> cmbx_estado;
	private JComboBox<String> cmbx_cidade;
	// Nome do arquivo pdf gerado
	private static String ARQ_PDF = "relatorio de cliente.pdf";
	// Caminho de onde está o arquivo jasper
	private String arq = "C:\\Users\\Alexandre H. Noro\\git\\Trabalho4-Bim\\src\\main\\resources\\RelatorioCliente.Jasper";
	private List<Cliente> listacliente;
	private TabelaCliente tabelaCliente;
	private String comando = "SELECT ID_C, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO FROM CLIENTE";

	/**
	 * Create the panel.
	 */
	public RelatorioCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 95, 0, 129, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblFiltrarPorEstado = new JLabel("Filtrar por Estado:");
		lblFiltrarPorEstado.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblFiltrarPorEstado = new GridBagConstraints();
		gbc_lblFiltrarPorEstado.anchor = GridBagConstraints.EAST;
		gbc_lblFiltrarPorEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrarPorEstado.gridx = 0;
		gbc_lblFiltrarPorEstado.gridy = 0;
		add(lblFiltrarPorEstado, gbc_lblFiltrarPorEstado);

		cmbx_estado = new JComboBox();
		GridBagConstraints gbc_cmbx_estado = new GridBagConstraints();
		gbc_cmbx_estado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbx_estado.insets = new Insets(0, 0, 5, 5);
		gbc_cmbx_estado.gridx = 1;
		gbc_cmbx_estado.gridy = 0;
		add(cmbx_estado, gbc_cmbx_estado);

		JLabel lblFiltrarPorCidade = new JLabel("Filtrar por Cidade:");
		lblFiltrarPorCidade.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblFiltrarPorCidade = new GridBagConstraints();
		gbc_lblFiltrarPorCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrarPorCidade.anchor = GridBagConstraints.EAST;
		gbc_lblFiltrarPorCidade.gridx = 2;
		gbc_lblFiltrarPorCidade.gridy = 0;
		add(lblFiltrarPorCidade, gbc_lblFiltrarPorCidade);

		cmbx_cidade = new JComboBox();
		GridBagConstraints gbc_cmbx_cidade = new GridBagConstraints();
		gbc_cmbx_cidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbx_cidade.insets = new Insets(0, 0, 5, 0);
		gbc_cmbx_cidade.gridx = 3;
		gbc_cmbx_cidade.gridy = 0;
		add(cmbx_cidade, gbc_cmbx_cidade);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				filtrarEstCid();

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
			public void actionPerformed(ActionEvent arg0) {
				carregartabela();

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
			public void actionPerformed(ActionEvent arg0) {
				GerarPdf();

			}
		});
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

		tablecliente = new JTable();
		tablecliente.setFont(new Font("Consolas", Font.BOLD, 11));
		scrollPane.setViewportView(tablecliente);

		carregartabela();

		mostradados();

	}

	/**
	 * 
	 * MÉTODOS
	 */

	// Método que cria um pdf
	protected void GerarPdf() {

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

	// Metodo que retorna na table a lista de cliente cadastrados
	private TableModel getTabelaProduto() {
		String[] columnNames = { "id_c", "nome", "telefone", "endereco", "cidade", "estado", "email", "genero" };

		Object[][] dados = new Object[listacliente.size()][8];
		for (int i = 0; i < listacliente.size(); i++) {
			int x = 0;
			dados[i][x++] = listacliente.get(i).getId();
			dados[i][x++] = listacliente.get(i).getNome();
			dados[i][x++] = listacliente.get(i).getTelefone();
			dados[i][x++] = listacliente.get(i).getEndereco();
			dados[i][x++] = listacliente.get(i).getCidade();
			dados[i][x++] = listacliente.get(i).getEstado().getNome();
			dados[i][x++] = listacliente.get(i).getEmail();
			dados[i][x++] = listacliente.get(i).getGenero().getNome();
		}

		return new DefaultTableModel(dados, columnNames);

	}

	// Metodo para filtrar por estado e por cidade
	protected void filtrarEstCid() {
		if (cmbx_cidade.getSelectedItem() != "" && cmbx_estado.getSelectedItem() != "") {
			StringBuilder filtracomando = new StringBuilder();

			filtracomando
					.append(comando + " WHERE ESTADO = '" + Estado.validar(cmbx_estado.getSelectedItem().toString())
							+ "' AND CIDADE = '" + cmbx_cidade.getSelectedItem().toString() + "'");
			listacliente = tabelaCliente.mostraRelatorio(filtracomando.toString());

			tablecliente.setModel(tabelaCliente);

		} else {
			JOptionPane.showMessageDialog(null, "Escolha a Cidade e o Estado que deseja Filtrar");
		}
	}

	// Método que carrega a table na tela
	private void carregartabela() {
		tabelaCliente = new TabelaCliente();
		listacliente = tabelaCliente.listar();
		new Thread(new Runnable() {
			public void run() {
				tablecliente.setModel(tabelaCliente);
			}
		}).start();

	}

	// Metodo que traz no combobox estados e cidades
	private void mostradados() {
		int in = 0;

		for (Estado e : Estado.values()) {
			if (in == 0) {
				cmbx_estado.addItem("");
				in = 1;
			}
			cmbx_estado.addItem(e.getNome());
		}

		for (int x = 0; x < listacliente.size(); x++) {
			in = 0;
			if (x == 0) {
				cmbx_cidade.addItem("");
			}

			for (int y = 0; y < cmbx_cidade.getItemCount(); y++) {
				if (listacliente.get(x).getCidade().equals(cmbx_cidade.getItemAt(y).toString()))
					in++;
				if (in > 1)
					break;
			}
			if (in < 1)
				cmbx_cidade.addItem(listacliente.get(x).getCidade());
		}
	}

}
