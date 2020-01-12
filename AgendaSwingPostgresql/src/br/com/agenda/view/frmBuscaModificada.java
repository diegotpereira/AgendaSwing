package br.com.agenda.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class frmBuscaModificada extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField entBusca;
	private JTable tabela;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBuscaModificada frame = new frmBuscaModificada();
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
	public frmBuscaModificada() {
		setTitle("Busca Modificada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Código  desejado (nenhum p/todos):");

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				BuscaDados();
			}
		});

		entBusca = new JTextField();
		entBusca.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						Alignment.LEADING,
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														scrollPane,
														GroupLayout.DEFAULT_SIZE,
														536, Short.MAX_VALUE)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNewLabel)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		entBusca,
																		GroupLayout.DEFAULT_SIZE,
																		211,
																		Short.MAX_VALUE)
																.addGap(18)
																.addComponent(
																		btnBuscar)))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNewLabel)
												.addComponent(btnBuscar)
												.addComponent(
														entBusca,
														GroupLayout.PREFERRED_SIZE,
														25,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 339,
										Short.MAX_VALUE).addContainerGap()));

		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		panel.setLayout(gl_panel);
	}

}
