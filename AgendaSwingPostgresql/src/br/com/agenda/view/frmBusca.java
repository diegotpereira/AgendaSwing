package br.com.agenda.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class frmBusca extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField saidaCodigo;
	private JTextField saidaNome;
	private JTextField saidaLogradouro;
	private JTextField saidaNumero;
	private JTextField saidaBairro;
	private JTextField saidaEstado;
	private JTextField saidaCidade;
	private JFormattedTextField saidaCPF;
	private JFormattedTextField saidaTelefone;
	private JFormattedTextField entBusca;
	private JComboBox opcaoBusca = new JComboBox();
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnLimpar;
	static JPanel panel = new JPanel();
	static frmBusca frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBusca frame = new frmBusca();
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
	public frmBusca() {
		setTitle("Busca por Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		setAcessibilidade();

		// JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel lblCdigo = new JLabel("Código:");

		JLabel lblNome = new JLabel("Nome:");

		saidaCodigo = new JTextField();
		saidaCodigo.setEnabled(false);
		saidaCodigo.setColumns(10);

		saidaNome = new JTextField();
		saidaNome.setEnabled(false);
		saidaNome.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ativarCampos();
				BuscaDados();

			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});

		JLabel label = new JLabel("CPF:");

		JLabel label_1 = new JLabel("Telefone:");

		JLabel label_2 = new JLabel("Logradouro:");

		saidaLogradouro = new JTextField();
		saidaLogradouro.setEnabled(false);
		saidaLogradouro.setColumns(10);

		saidaNumero = new JTextField();
		saidaNumero.setEnabled(false);
		saidaNumero.setColumns(10);

		JLabel label_3 = new JLabel("Bairro:");

		saidaBairro = new JTextField();
		saidaBairro.setEnabled(false);
		saidaBairro.setColumns(10);

		saidaEstado = new JTextField();
		saidaEstado.setEnabled(false);
		saidaEstado.setColumns(10);

		JLabel label_4 = new JLabel("Estado:");

		saidaCidade = new JTextField();
		saidaCidade.setEnabled(false);
		saidaCidade.setColumns(10);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExcluirDados();
			}
		});

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlterarDados();
			}
		});

		JLabel lblCidade = new JLabel("Cidade:");

		JLabel lblN = new JLabel("Nº:");

		opcaoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Escolhe a Forma da Busca
				if (opcaoBusca.getSelectedIndex() == 1) {
					limpar();
					entBusca.enable(true);

				}
				if (opcaoBusca.getSelectedIndex() == 2) {
					limpar();

				} else if (opcaoBusca.getSelectedIndex() == 3) {
					frmBuscaModificada busca = new frmBuscaModificada();
					busca.setVisible(true);
					limpar();
				}
			}
		});
		opcaoBusca.setBackground(Color.WHITE);

		// JComboBox opcaoBusca = new JComboBox();
		opcaoBusca.setModel(new DefaultComboBoxModel(new String[] {
				"Opção da Busca", "Código", "CPF", "Todos" }));

		saidaCPF = new JFormattedTextField();
		saidaCPF.setEnabled(false);

		saidaTelefone = new JFormattedTextField();
		saidaTelefone.setEnabled(false);

		entBusca = new JFormattedTextField();
		entBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				entBusca.setText("");
			}
		});
		entBusca.setEnabled(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		btnExcluir)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		btnAlterar)
																.addPreferredGap(
																		ComponentPlacement.RELATED,
																		280,
																		Short.MAX_VALUE)
																.addComponent(
																		btnLimpar)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		btnSair))
												.addGroup(
														Alignment.LEADING,
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNome)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		saidaNome,
																		GroupLayout.DEFAULT_SIZE,
																		528,
																		Short.MAX_VALUE))
												.addGroup(
														Alignment.LEADING,
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblCdigo)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		saidaCodigo,
																		GroupLayout.PREFERRED_SIZE,
																		122,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														Alignment.LEADING,
														gl_panel.createSequentialGroup()
																.addComponent(
																		opcaoBusca,
																		GroupLayout.PREFERRED_SIZE,
																		253,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		entBusca,
																		GroupLayout.DEFAULT_SIZE,
																		244,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		btnBuscar))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.TRAILING)
																				.addGroup(
																						Alignment.LEADING,
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										label_2,
																										GroupLayout.PREFERRED_SIZE,
																										88,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										saidaLogradouro,
																										GroupLayout.DEFAULT_SIZE,
																										371,
																										Short.MAX_VALUE))
																				.addGroup(
																						Alignment.LEADING,
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										label,
																										GroupLayout.PREFERRED_SIZE,
																										31,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										saidaCPF,
																										GroupLayout.PREFERRED_SIZE,
																										149,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.UNRELATED)
																								.addComponent(
																										label_1,
																										GroupLayout.PREFERRED_SIZE,
																										67,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										saidaTelefone,
																										182,
																										182,
																										182))
																				.addGroup(
																						Alignment.LEADING,
																						gl_panel.createSequentialGroup()
																								.addGroup(
																										gl_panel.createParallelGroup(
																												Alignment.LEADING)
																												.addComponent(
																														label_3,
																														GroupLayout.PREFERRED_SIZE,
																														48,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														lblCidade))
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addGroup(
																										gl_panel.createParallelGroup(
																												Alignment.LEADING)
																												.addGroup(
																														gl_panel.createSequentialGroup()
																																.addComponent(
																																		saidaCidade,
																																		GroupLayout.PREFERRED_SIZE,
																																		320,
																																		GroupLayout.PREFERRED_SIZE)
																																.addPreferredGap(
																																		ComponentPlacement.UNRELATED)
																																.addComponent(
																																		label_4,
																																		GroupLayout.PREFERRED_SIZE,
																																		54,
																																		GroupLayout.PREFERRED_SIZE))
																												.addComponent(
																														saidaBairro,
																														GroupLayout.DEFAULT_SIZE,
																														405,
																														Short.MAX_VALUE))))
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.TRAILING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										lblN)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										saidaNumero,
																										GroupLayout.PREFERRED_SIZE,
																										61,
																										GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						saidaEstado,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														btnBuscar,
														GroupLayout.PREFERRED_SIZE,
														25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														opcaoBusca,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														entBusca,
														GroupLayout.PREFERRED_SIZE,
														25,
														GroupLayout.PREFERRED_SIZE))
								.addGap(32)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblCdigo)
												.addComponent(
														saidaCodigo,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNome)
												.addComponent(
														saidaNome,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														gl_panel.createParallelGroup(
																Alignment.BASELINE)
																.addComponent(
																		label)
																.addComponent(
																		saidaCPF,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createParallelGroup(
																Alignment.BASELINE)
																.addComponent(
																		label_1)
																.addComponent(
																		saidaTelefone,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(label_2)
												.addComponent(
														saidaLogradouro,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblN)
												.addComponent(
														saidaNumero,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(label_3)
												.addComponent(
														saidaBairro,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblCidade)
												.addComponent(
														saidaCidade,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(label_4)
												.addComponent(
														saidaEstado,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(36)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(btnExcluir)
												.addComponent(btnAlterar)
												.addComponent(btnLimpar)
												.addComponent(btnSair))
								.addContainerGap()));
		panel.setLayout(gl_panel);
	}
	
	// Limpa os Campos
		public void limpar() {
			entBusca.setText("");
			saidaCodigo.setText("");
			saidaNome.setText("");
			saidaCPF.setText("");
			saidaTelefone.setText("");
			saidaLogradouro.setText("");
			saidaNumero.setText("");
			saidaBairro.setText("");
			saidaCidade.setText("");
			saidaEstado.setText("");
		}

		// Fecha a Janela
		public static void sair() {
			// frame.setVisible(false);
			// Comando para fecha Janela.
			frame.dispose();
		}

		// Ativa os campos
		public void ativarCampos() {
			entBusca.setEnabled(true);
			saidaCodigo.setEnabled(true);
			saidaNome.setEnabled(true);
			saidaCPF.setEnabled(true);
			saidaTelefone.setEnabled(true);
			saidaLogradouro.setEnabled(true);
			saidaNumero.setEnabled(true);
			saidaBairro.setEnabled(true);
			saidaCidade.setEnabled(true);
			saidaEstado.setEnabled(true);
		}
		
		public void setAcessibilidade() {
			JRootPane meurootpane = getRootPane();
			meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
					KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
			meurootpane.getRootPane().getActionMap()
					.put("ESCAPE", new AbstractAction("ESCAPE") {

						public void actionPerformed(ActionEvent e) {
							setVisible(false);
						}
					});
		}
		
		// Busca os dados no BD
		public void BuscaDados() {
			boolean consulta = true;

			try {
				// * Driver conector MySQL.
				Class.forName("org.postgresql.Driver");

				// * Conexão BD
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/Agenda", "postgres","1234");

				Statement stmt = con.createStatement();

				// * Entras de dados no campo codigo do formulário.
				int BuscaCodigo = Integer.parseInt(entBusca.getText());
				String BuscaCPF = entBusca.getText();

				ResultSet RS = null;

				// Escolha a Opção de Busca.
				if (opcaoBusca.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null,
							"Escolha uma Opção de Busca!");

				} else if (opcaoBusca.getSelectedIndex() == 1) {
					RS = stmt
							.executeQuery("Select * from TabFicha where Matricula = "
									+ BuscaCodigo);

					while (RS.next()) {

						// * Exibe os valore retornados na consulta.

						// * Pega a Matricula.
						int Mat = RS.getInt("Matricula");

						// * Conver inteiro para String
						saidaCodigo.setText(String.valueOf(Mat));

						// Pega os demais.
						saidaNome.setText(RS.getString("Nome"));
						saidaCPF.setText(RS.getString("CPF"));
						saidaTelefone.setText(RS.getString("Telefone"));
						saidaLogradouro.setText(RS.getString("Logradouro"));
						saidaNumero.setText(RS.getString("Numero"));
						saidaBairro.setText(RS.getString("Bairro"));
						saidaCidade.setText(RS.getString("Cidade"));
						saidaEstado.setText(RS.getString("Estado"));

						consulta = false;
						JOptionPane.showMessageDialog(null, "Dados Encontrado!");

					}

				} else if (opcaoBusca.getSelectedIndex() == 2) {
					RS = stmt.executeQuery("Select * from TabFicha where CPF = "
							+ BuscaCPF);

					while (RS.next()) {

						// * Pega o CPF.
						String CPF = RS.getString("CPF");
						saidaCPF.setText(CPF);

						// * Exibe os valore retornados na consulta.
						saidaNome.setText(RS.getString("Nome"));
						saidaCodigo.setText(RS.getString("Matricula"));
						saidaTelefone.setText(RS.getString("Telefone"));
						saidaLogradouro.setText(RS.getString("Logradouro"));
						saidaNumero.setText(RS.getString("Numero"));
						saidaBairro.setText(RS.getString("Bairro"));
						saidaCidade.setText(RS.getString("Cidade"));
						saidaEstado.setText(RS.getString("Estado"));

						consulta = false;
						JOptionPane.showMessageDialog(null, "Dados Encontrado!");

					}

				}

				if (consulta) {
					JOptionPane.showMessageDialog(null, "Dados não Encontrados!");

				}
				RS.close();
				stmt.close();

				// * Fecha conexão com DB.
				con.close();

			} catch (SQLException Erro) {
				JOptionPane.showMessageDialog(null,
						"Erro Cmdo SQL" + Erro.getMessage());

			} catch (ClassNotFoundException Erro) {
				JOptionPane.showMessageDialog(null, "Driver não Encontrado!");

			}
		}
		
		// Altera os dados no BD
		public void AlterarDados() {
			try {
				// * Drive Conector MySQL.
				Class.forName("com.mysql.jdbc.Driver");

				// * Conexão como BD.
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost/BDCadastro", "root", "210712");

				// * Objeto comdo SQL.
				Statement stmt = con.createStatement();

				// * Opção de Entrada para Alterar.
				int consMatricula = Integer.parseInt(entBusca.getText());
				String consCPF = entBusca.getText();

				// * Pega os dados no formulário.
				int cadMat = Integer.parseInt(saidaCodigo.getText());
				String cadNome = saidaNome.getText();
				String cadCPF = saidaCPF.getText();
				String cadTelefone = saidaTelefone.getText();
				String cadLogradouro = saidaLogradouro.getText();
				int cadNumero = Integer.parseInt(saidaNumero.getText());
				String cadBairro = saidaBairro.getText();
				String cadCidade = saidaCidade.getText();
				String cadEstado = saidaEstado.getText();

				// Escolha a Opção de Busca.
				if (opcaoBusca.getSelectedIndex() == 1) {
					int registro = stmt.executeUpdate("update TabFicha set "
							+ "Nome='" + cadNome + "',CPF='" + cadCPF
							+ "',Telefone='" + cadTelefone + "',Logradouro='"
							+ cadLogradouro + "',Numero='" + cadNumero
							+ "',Bairro='" + cadBairro + "',Cidade='" + cadCidade
							+ "',Estado='" + cadEstado + "', Matricula=" + cadMat
							+ " where Matricula=" + consMatricula);

					if (registro != 0)
						JOptionPane.showMessageDialog(null, "Dados Alterados!");

					else
						JOptionPane.showMessageDialog(null, "Dados Não Alterados!");
					stmt.close();

					// * Fecha conexão com BD.
					con.close();

				} else if (opcaoBusca.getSelectedIndex() == 2) {
					int registro = stmt.executeUpdate("update TabFicha set "
							+ "Matricula='" + cadMat + "',Nome='" + cadNome
							+ "',Telefone='" + cadTelefone + "',Logradouro='"
							+ cadLogradouro + "',Numero='" + cadNumero
							+ "',Bairro='" + cadBairro + "',Cidade='" + cadCidade
							+ "',Estado='" + cadEstado + "',CPF=" + cadCPF
							+ "where CPF=" + consCPF);

					if (registro != 0)
						JOptionPane.showMessageDialog(null, "Dados Alterados!");

					else
						JOptionPane.showMessageDialog(null, "Dados NãoAlterados!");
					stmt.close();

					// * Fecha conexão com BD.
					con.close();
				}

			} catch (SQLException Erro) {
				JOptionPane.showMessageDialog(null,
						"Erro Cmdo SQL" + Erro.getMessage());

			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Driver não encontrado");
			}
		}
		
		// Exclui dados no BD
		public void ExcluirDados() {
			try {
				// * Drive Conector MySQL.
				Class.forName("org.postgresql.Driver");

				// * Conexão como BD.
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/Agenda", "postgres","1234");

				// * Objeto comdo SQL.
				Statement stmt = con.createStatement();

				int excluirMatricula = Integer.parseInt(entBusca.getText());
				int registro = stmt
						.executeUpdate("delete from TabFicha where Matricula="
								+ excluirMatricula);

				if (registro != 0) {
					JOptionPane.showMessageDialog(null, "Dados Excluido!");
					limpar();

				} else {
					JOptionPane.showMessageDialog(null, "Dados não Excluidos!");
				}
				stmt.close();

				// * Limpar a caixa de Texto.
				limpar();

				// * Fecha conexão com o BD.
				con.close();

			} catch (SQLException Erro) {
				JOptionPane.showMessageDialog(null,
						"Erro Cmdo SQL" + Erro.getMessage());

			} catch (ClassNotFoundException Erro) {
				JOptionPane.showMessageDialog(null, "Driver não Encontrado!");

			}
		}
}
