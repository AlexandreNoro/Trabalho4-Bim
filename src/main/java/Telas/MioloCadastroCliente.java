package Telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

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
             
	/**      
	 * Create the panel.
	 */
	public MioloCadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 1;
		gbc_txfNome.gridy = 1;
		add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);
		
		lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 2;
		add(lblTelefone, gbc_lblTelefone);
		
		txftelefone = new JTextField();
		GridBagConstraints gbc_txftelefone = new GridBagConstraints();
		gbc_txftelefone.insets = new Insets(0, 0, 5, 0);
		gbc_txftelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txftelefone.gridx = 1;
		gbc_txftelefone.gridy = 2;
		add(txftelefone, gbc_txftelefone);
		txftelefone.setColumns(10);
		
		lblEndereco = new JLabel("Endereco");
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.anchor = GridBagConstraints.EAST;
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.gridx = 0;
		gbc_lblEndereco.gridy = 3;
		add(lblEndereco, gbc_lblEndereco);
		
		txfendereco = new JTextField();
		GridBagConstraints gbc_txfendereco = new GridBagConstraints();
		gbc_txfendereco.insets = new Insets(0, 0, 5, 0);
		gbc_txfendereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfendereco.gridx = 1;
		gbc_txfendereco.gridy = 3;
		add(txfendereco, gbc_txfendereco);
		txfendereco.setColumns(10);
		
		lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 4;
		add(lblCidade, gbc_lblCidade);
		
		txfcidade = new JTextField();
		GridBagConstraints gbc_txfcidade = new GridBagConstraints();
		gbc_txfcidade.insets = new Insets(0, 0, 5, 0);
		gbc_txfcidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfcidade.gridx = 1;
		gbc_txfcidade.gridy = 4;
		add(txfcidade, gbc_txfcidade);
		txfcidade.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 5;
		add(lblEstado, gbc_lblEstado);
		
		cmbxEstado = new JComboBox();
		GridBagConstraints gbc_cmbxEstado = new GridBagConstraints();
		gbc_cmbxEstado.insets = new Insets(0, 0, 5, 0);
		gbc_cmbxEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbxEstado.gridx = 1;
		gbc_cmbxEstado.gridy = 5;
		add(cmbxEstado, gbc_cmbxEstado);
		
		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		txfEmail = new JTextField();
		GridBagConstraints gbc_txfEmail = new GridBagConstraints();
		gbc_txfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfEmail.gridx = 1;
		gbc_txfEmail.gridy = 6;
		add(txfEmail, gbc_txfEmail);
		txfEmail.setColumns(10);
		
		lblGenero = new JLabel("Genero");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 0, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 7;
		add(lblGenero, gbc_lblGenero);
		
		cmbxGenero = new JComboBox();
		GridBagConstraints gbc_cmbxGenero = new GridBagConstraints();
		gbc_cmbxGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbxGenero.gridx = 1;
		gbc_cmbxGenero.gridy = 7;
		add(cmbxGenero, gbc_cmbxGenero);

	}

}