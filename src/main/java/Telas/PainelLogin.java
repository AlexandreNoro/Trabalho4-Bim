package Telas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import AcessoAoBanco.LoginDaoAcesso;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class PainelLogin extends JPanel {

	private JTextField txf_user;
	private JPasswordField txf_senha;
	private JButton btnEntrar;

	public PainelLogin(Runnable acaoOk) {
		setBackground(Color.BLACK);
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblUsurio = new GridBagConstraints();
		gbc_lblUsurio.insets = new Insets(20, 20, 5, 5);
		gbc_lblUsurio.anchor = GridBagConstraints.EAST;
		gbc_lblUsurio.gridx = 0;
		gbc_lblUsurio.gridy = 0;
		add(lblUsurio, gbc_lblUsurio);

		txf_user = new JTextField();
		txf_user.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		GridBagConstraints gbc_txf_user = new GridBagConstraints();
		gbc_txf_user.insets = new Insets(20, 0, 5, 20);
		gbc_txf_user.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_user.gridx = 1;
		gbc_txf_user.gridy = 0;
		add(txf_user, gbc_txf_user);
		txf_user.setColumns(10);

		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 20, 20, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		txf_senha = new JPasswordField();
		txf_senha.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		GridBagConstraints gbc_txf_senha = new GridBagConstraints();
		gbc_txf_senha.insets = new Insets(0, 0, 20, 20);
		gbc_txf_senha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txf_senha.gridx = 1;
		gbc_txf_senha.gridy = 1;
		add(txf_senha, gbc_txf_senha);

		btnEntrar = new JButton("Conectar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acessarSistema(acaoOk);
			}
		});
		btnEntrar.setFont(new Font("Consolas", Font.BOLD, 14));
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(0, 0, 20, 0);
		gbc_btnEntrar.gridx = 1;
		gbc_btnEntrar.gridy = 2;
		add(btnEntrar, gbc_btnEntrar);
	}

	public void acessarSistema(Runnable acaoOk) {
		try {
			LoginDaoAcesso log = new LoginDaoAcesso();

			log.abreConexao();
			log.st = log.con.createStatement();

			String sql = "SELECT CLIENTE,SENHA FROM USUARIO WHERE CLIENTE='" + txf_user.getText() + "' AND SENHA = '"
					+ txf_senha.getText() + "'";
			log.rs = log.st.executeQuery(sql);

			log.rs.first();

			if (txf_user.getText().equals(log.rs.getString("cliente"))
					&& txf_senha.getText().equals(log.rs.getString("senha"))) {
				acaoOk.run();

				btnEntrar.addActionListener(e -> {
					acessarSistema(acaoOk);
				});
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(PainelLogin.this, "Usuário e/ou senha inválidos!");
			limparCampos();

		}

	}

	private void limparCampos() {
		txf_user.setText("");
		txf_senha.setText("");

	}

}