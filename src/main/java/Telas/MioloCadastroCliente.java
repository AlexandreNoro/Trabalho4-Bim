package Telas;

/**
 * @author Alexandre Henrique Noro 4 de nov de 2015 - 19:03:46
 */
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import AcessoAoBanco.ClienteDaoAcesso;
import Tables.TabelaCliente;
import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Estado;
import br.univel.cadastroCliente.Genero;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseEvent;

public class MioloCadastroCliente extends JPanel {

	protected JTextField txfId;
	protected JTextField txfNome;
	private JLabel lblTelefone;
	private JTextField txftelefone;
	private JLabel lblEndereco;
	private JTextField txfendereco;
	private JLabel lblCidade;
	private JTextField txfcidade;
	private JLabel lblEstado;
	private JComboBox cmbxEstado;
	private JLabel lblEmail;
	private JTextField txfEmail;
	private JLabel lblGenero;
	private JComboBox cmbxGenero;
	private JButton btnGravar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JScrollPane scrollPane;
	private JTable tablemiolocliente;

	private TabelaCliente tabelacliente;
	private ClienteDaoAcesso cda = new ClienteDaoAcesso();
	private List<Cliente> listacliente = new ArrayList<>();
	private int in = -1;

	/**
	 * Create the panel.
	 */
	public MioloCadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 200, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);

		txfNome = new JTextField();
		txfNome.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.insets = new Insets(0, 0, 5, 5);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 1;
		gbc_txfNome.gridy = 1;
		add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 2;
		add(lblTelefone, gbc_lblTelefone);

		txftelefone = new JTextField();
		txftelefone.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txftelefone = new GridBagConstraints();
		gbc_txftelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txftelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txftelefone.gridx = 1;
		gbc_txftelefone.gridy = 2;
		add(txftelefone, gbc_txftelefone);
		txftelefone.setColumns(10);

		lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.anchor = GridBagConstraints.EAST;
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.gridx = 0;
		gbc_lblEndereco.gridy = 3;
		add(lblEndereco, gbc_lblEndereco);

		txfendereco = new JTextField();
		txfendereco.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfendereco = new GridBagConstraints();
		gbc_txfendereco.insets = new Insets(0, 0, 5, 5);
		gbc_txfendereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfendereco.gridx = 1;
		gbc_txfendereco.gridy = 3;
		add(txfendereco, gbc_txfendereco);
		txfendereco.setColumns(10);

		lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 4;
		add(lblCidade, gbc_lblCidade);

		txfcidade = new JTextField();
		txfcidade.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfcidade = new GridBagConstraints();
		gbc_txfcidade.insets = new Insets(0, 0, 5, 5);
		gbc_txfcidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfcidade.gridx = 1;
		gbc_txfcidade.gridy = 4;
		add(txfcidade, gbc_txfcidade);
		txfcidade.setColumns(10);

		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 5;
		add(lblEstado, gbc_lblEstado);

		cmbxEstado = new JComboBox();
		cmbxEstado.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_cmbxEstado = new GridBagConstraints();
		gbc_cmbxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cmbxEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbxEstado.gridx = 1;
		gbc_cmbxEstado.gridy = 5;
		add(cmbxEstado, gbc_cmbxEstado);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);

		txfEmail = new JTextField();
		txfEmail.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_txfEmail = new GridBagConstraints();
		gbc_txfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfEmail.gridx = 1;
		gbc_txfEmail.gridy = 6;
		add(txfEmail, gbc_txfEmail);
		txfEmail.setColumns(10);

		lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 7;
		add(lblGenero, gbc_lblGenero);

		cmbxGenero = new JComboBox();
		cmbxGenero.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_cmbxGenero = new GridBagConstraints();
		gbc_cmbxGenero.insets = new Insets(0, 0, 5, 5);
		gbc_cmbxGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbxGenero.gridx = 1;
		gbc_cmbxGenero.gridy = 7;
		add(cmbxGenero, gbc_cmbxGenero);

		btnGravar = new JButton("Gravar");
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
		gbc_btnGravar.gridx = 2;
		gbc_btnGravar.gridy = 8;
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
		gbc_btnEditar.gridy = 8;
		add(btnEditar, gbc_btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Excluir();
				limpar();

			}
		});
		btnExcluir.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 0);
		gbc_btnExcluir.gridx = 4;
		gbc_btnExcluir.gridy = 8;
		add(btnExcluir, gbc_btnExcluir);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		add(scrollPane, gbc_scrollPane);

		tablemiolocliente = new JTable();

		tablemiolocliente.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) {
					Cliente c = (Cliente) listacliente.get(tablemiolocliente.getSelectedRow());

					retornaCliente(c);

					in = tablemiolocliente.getSelectedRow();
				}
			}
		});

		tablemiolocliente.setFont(new Font("Consolas", Font.BOLD, 11));
		scrollPane.setViewportView(tablemiolocliente);

		mostrarNoComboBox();

		listarClientes();

	}

	// Lista os clientes cadastrados
	private void listarClientes() {
		new Thread(new Runnable() {

			public void run() {
				tabelacliente = new TabelaCliente();
				listacliente = tabelacliente.listar();
				tablemiolocliente.setModel(tabelacliente);
			}
		}).start();

	}

	// metodo que popula o combobox de estado e genero pré cadastrados nas enums
	private void mostrarNoComboBox() {
		for (Estado e : Estado.values())
			cmbxEstado.addItem(e.name());
		for (Genero g : Genero.values())
			cmbxGenero.addItem(g.name());
	}

	// Metodo para gravar(cadastrar) clientes
	protected void Gravar() {

		Cliente c = new Cliente(txfNome.getText(), txftelefone.getText(), txfendereco.getText(), txfcidade.getText(),
				Estado.valueOf(String.valueOf(cmbxEstado.getSelectedItem())), txfEmail.getText(),
				Genero.valueOf(String.valueOf(cmbxGenero.getSelectedItem())));

		cda.inserir(c);
		listacliente = cda.listar();
		tabelacliente.addLista(listacliente);
		limpar();
	}

	// Metodo Editar(atualizar) clientes ja cadastrados
	protected void Editar() {

		if (in > -1) {
			Cliente c = new Cliente(Integer.parseInt(txfId.getText()), txfNome.getText(), txftelefone.getText(),
					txfendereco.getText(), txfcidade.getText(),
					Estado.valueOf(String.valueOf(cmbxEstado.getSelectedItem())), txfEmail.getText(),
					Genero.valueOf(String.valueOf(cmbxGenero.getSelectedItem())));

			cda.atualizar(c);
			tabelacliente.atualizaLista(in, c);
			limpar();
			in = -1;
		} else {
			JOptionPane.showMessageDialog(null, " Escolha o cliente que deseja modificar!!! ");
		}

	}

	// Metodo excluir(deletar) cliente
	protected void Excluir() {

		cda.excluir(listacliente.get(tablemiolocliente.getSelectedRow()).getId());
		tabelacliente.excluir(tablemiolocliente.getSelectedRow());

	}

	// Metodo limpar textfields
	private void limpar() {

		txfId.setText("");
		txfNome.setText("");
		txftelefone.setText("");
		txfendereco.setText("");
		txfcidade.setText("");
		cmbxEstado.setSelectedIndex(0);
		txfEmail.setText("");
		cmbxGenero.setSelectedIndex(0);

	}

	// Metodo para ao dar dois cliques no mouse carregar dados da table para os
	// textfields
	public void retornaCliente(Cliente c) {
		txfId.setText(String.valueOf(c.getId()));
		txfNome.setText(c.getNome());
		txftelefone.setText(c.getTelefone());
		txfendereco.setText(c.getEndereco());
		txfcidade.setText(c.getCidade());
		cmbxEstado.setSelectedItem(c.getEstado().name());
		txfEmail.setText(c.getEmail());
		cmbxGenero.setSelectedItem(c.getGenero().name());

	}

}