package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Relatorios.RelatorioVenda;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.function.Function;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private BlockPanel glass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setExtendedState(Frame.MAXIMIZED_BOTH);

		blockParaLogin();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		mnCadastros.setForeground(new Color(0, 0, 102));
		mnCadastros.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnCadastros);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTela();
			}

		});
		mnCadastros.add(mntmCliente);

		JMenuItem mntmBloquear = new JMenuItem("Bloquear");
		mntmBloquear.setForeground(new Color(204, 0, 0));
		mntmBloquear.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		mntmBloquear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				block();
			}
		});

		JMenuItem mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaUsuario();
			}

		});

		mnCadastros.add(mntmUsuario);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaProduto();
			}

		});
		mnCadastros.add(mntmProduto);

		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mntmVendas.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		mntmVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaVendas();
			}
		});
		mnCadastros.add(mntmVendas);

		mnCadastros.add(mntmBloquear);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		mnRelatrios.setForeground(new Color(0, 0, 102));
		mnRelatrios.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnRelatrios);

		JMenuItem mntmRelatrioCliente = new JMenuItem("Relat\u00F3rio Cliente");
		mntmRelatrioCliente.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		mntmRelatrioCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abreRelatorioCliente();

			}
		});
		mnRelatrios.add(mntmRelatrioCliente);

		JMenuItem mntmRelatrioProduto = new JMenuItem("Relat\u00F3rio Produto");
		mntmRelatrioProduto.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		mntmRelatrioProduto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abreRelatorioProduto();

			}
		});
		mnRelatrios.add(mntmRelatrioProduto);

		JMenuItem mntmRelatrioVenda = new JMenuItem("Relat\u00F3rio Venda");
		mntmRelatrioVenda.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		mntmRelatrioVenda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abreRelatorioVendas();

			}
		});
		mnRelatrios.add(mntmRelatrioVenda);

		JMenu mnSistema = new JMenu("Sistema");
		mnSistema.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		mnSistema.setForeground(new Color(0, 0, 102));
		menuBar.add(mnSistema);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setForeground(new Color(204, 0, 0));
		mntmSair.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}

		});
		mnSistema.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBackground(new Color(255, 255, 255));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void block() {
		setGlassPane(glass);
		glass.setVisible(true);

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				glass.setVisible(false);
			}
		}).start();
	}

	// Metodo de acao do botao de bloquear tela
	private void blockParaLogin() {
		Runnable acaoOk = () -> {
			glass.setVisible(false);
			glass = new BlockPanel();
		};

		PainelLogin painelLogin = new PainelLogin(acaoOk);

		glass = new BlockPanel(painelLogin);

		setGlassPane(glass);

		glass.setVisible(true);
	}

	// Método para abrir a tela de cadastro de Clientes
	private void abrirTela() {
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroCliente);
			}
		};
		telaCadastroCliente.setCloseAction(action);

		tabbedPane.addTab("Cadastrar Cliente ", telaCadastroCliente);
		
		mostraUltima();
	}

	// Método para abrir a tela de cadastro de produtos
	private void abrirTelaProduto() {
		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroProduto);

			}
		};
		telaCadastroProduto.setCloseAction(action);

		tabbedPane.addTab("Cadastrar Produto ", telaCadastroProduto);
		mostraUltima();
	}

	private void mostraUltima() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}

	// Método para abrir a tela de cadastro de Usuarios
	protected void abrirTelaUsuario() {
		TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroUsuario);
			}
		};
		telaCadastroUsuario.setCloseAction(action);

		tabbedPane.addTab("Cadastrar Usuário ", telaCadastroUsuario);

		mostraUltima();
	}

	// Método para abrir a tela de cadastro de Vendas
	protected void abrirTelaVendas() {
		TelaCadastroVendas telaCadastroVendas = new TelaCadastroVendas();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroVendas);
			}
		};
		telaCadastroVendas.setCloseAction(action);

		tabbedPane.addTab("Cadastrar Venda ", telaCadastroVendas);

		mostraUltima();
	}

	// Método para abrir a tela de relatorio de clientes
	protected void abreRelatorioCliente() {
		TelaRelatorioCliente telaRelatorioCliente = new TelaRelatorioCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorioCliente);
			}
		};
		telaRelatorioCliente.setCloseAction(action);

		tabbedPane.addTab("Relatório Cliente ", telaRelatorioCliente);

		mostraUltima();
	}

	// Método para abrir a tela de relatorio de Produto
	protected void abreRelatorioProduto() {
		TelaRelatorioProduto telaRelatorioProduto = new TelaRelatorioProduto();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorioProduto);
			}
		};
		telaRelatorioProduto.setCloseAction(action);

		tabbedPane.addTab("Relatório Produto ", telaRelatorioProduto);

		mostraUltima();
	}

	// Método para abrir a tela de relatorio de Vendas
	protected void abreRelatorioVendas() {

		TelaRelatorioVenda telaRelatorioVenda = new TelaRelatorioVenda();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorioVenda);
			}
		};
		telaRelatorioVenda.setCloseAction(action);

		tabbedPane.addTab("Relatório Vendas ", telaRelatorioVenda);

		mostraUltima();
	}

}