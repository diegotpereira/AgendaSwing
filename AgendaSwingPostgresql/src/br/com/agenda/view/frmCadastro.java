package br.com.agenda.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class frmCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField entCodigo;
	private JTextField entNome;
	private JTextField entLogradouro;
	private JTextField entBairro;
	private JTextField entCidade;
	private JTextField entNumero;
	private JFormattedTextField entCPF;
	private JFormattedTextField entTelefone;
	private JTextField entEstado;
	private JButton btnInserir;
	private JButton btnLimpar;
	private JButton btnBusca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCadastro frame = new frmCadastro();
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
	public frmCadastro() {
		
		setResizable(false);
		setTitle("Cadastro Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel lblCidigo = new JLabel("Cidigo:");

		JLabel lblNome = new JLabel("Nome:");

		JLabel lblCpf = new JLabel("CPF:");

		JLabel lblTelefone = new JLabel("Telefone:");

		JLabel lblLogradouro = new JLabel("Logradouro:");

		JLabel lblN = new JLabel("Nº:");

		JLabel lblBairro = new JLabel("Bairro:");

		JLabel lblCidade = new JLabel("Cidade:");

		JLabel lblEstado = new JLabel("Estado:");

		entCodigo = new JTextField();
		entCodigo.setColumns(10);

		entNome = new JTextField();
		entNome.setColumns(10);

		entLogradouro = new JTextField();
		entLogradouro.setColumns(10);

		entBairro = new JTextField();
		entBairro.setColumns(10);

		entCidade = new JTextField();
		entCidade.setColumns(10);

		entNumero = new JTextField();
		entNumero.setColumns(10);

		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Insere.Principal();
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpaCampos();
			}
		});

		btnBusca = new JButton("Busca");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Cria e Instancia o objeto da class Busca
//				Busca b = new Busca();
				// JFrame visivel
//				b.setVisible(true);
			}
		});

		entCPF = new JFormattedTextField();

		entTelefone = new JFormattedTextField();

		entEstado = new JTextField();
		entEstado.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblCidade)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		entCidade,
																		GroupLayout.DEFAULT_SIZE,
																		373,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		lblEstado)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		entEstado,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										lblBairro)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										entBairro,
																										GroupLayout.DEFAULT_SIZE,
																										457,
																										Short.MAX_VALUE))
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										lblLogradouro)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										entLogradouro,
																										GroupLayout.DEFAULT_SIZE,
																										422,
																										Short.MAX_VALUE)
																								.addPreferredGap(
																										ComponentPlacement.UNRELATED)))
																.addGap(18)
																.addComponent(
																		lblN)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		entNumero,
																		GroupLayout.PREFERRED_SIZE,
																		59,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		btnBusca)
																.addPreferredGap(
																		ComponentPlacement.RELATED,
																		392,
																		Short.MAX_VALUE)
																.addComponent(
																		btnLimpar)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		btnInserir))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblNome)
																				.addComponent(
																						lblCidigo)
																				.addComponent(
																						lblCpf))
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						entCodigo,
																						GroupLayout.PREFERRED_SIZE,
																						118,
																						GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										entCPF,
																										GroupLayout.PREFERRED_SIZE,
																										148,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										lblTelefone)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										entTelefone,
																										GroupLayout.PREFERRED_SIZE,
																										183,
																										GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						entNome,
																						GroupLayout.DEFAULT_SIZE,
																						558,
																						Short.MAX_VALUE))))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblCidigo)
												.addComponent(
														entCodigo,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNome)
												.addComponent(
														entNome,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblCpf)
												.addComponent(
														entCPF,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTelefone)
												.addComponent(
														entTelefone,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(31)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createParallelGroup(
																Alignment.BASELINE)
																.addComponent(
																		lblLogradouro)
																.addComponent(
																		entNumero,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		lblN))
												.addComponent(
														entLogradouro,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblBairro)
												.addComponent(
														entBairro,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblCidade)
												.addComponent(lblEstado)
												.addComponent(
														entCidade,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														entEstado,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(btnInserir)
												.addComponent(btnLimpar)
												.addComponent(btnBusca))
								.addContainerGap()));
		panel.setLayout(gl_panel);
		
		
			}
	
	// Este Metodo Limpa os campos
		public void limpaCampos() {
			entCodigo.setText("");
			entNome.setText("");
			entCPF.setText("");
			entTelefone.setText("");
			entLogradouro.setText("");
			entNumero.setText("");
			entBairro.setText("");
			entCidade.setText("");
			entEstado.setText("");
		}

}
