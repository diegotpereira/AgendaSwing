package br.com.agenda.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.agenda.conection.Conexao;
import br.com.agenda.models.Pessoa;

public class PessoaDao implements Dao{
	
	// Salva os dados no BD
	@Override
	public void insert(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
		try {
			

			// * Conexão como BD.
			Connection con;

			// * Objeto comdo SQL.
			Statement stmt = con.createStatement();

			// * Pega os dados informado no formulário,
			
			stmt.setInt(1,Integer.parseInt(entCodigo.getText()));
			
			//int cadMat = Integer.parseInt(entCodigo.getText());
			String cadNome = entNome.getText();
			String cadCPF = entCPF.getText();
			String cadTelefone = entTelefone.getText();
			String cadLogradouro = entLogradouro.getText();
			int cadNumero = Integer.parseInt(entNumero.getText());
			String cadBairro = entBairro.getText();
			String cadCidade = entCidade.getText();
			String cadEstado = entEstado.getText();

			// * Insere os dados do formulário no BD.
			stmt.executeUpdate("insert into TabFicha (Matricula, Nome, CPF, Telefone, Logradouro, Numero, Bairro, Cidade, Estado) values ('"
					+ cadMat
					+ "','"
					+ cadNome
					+ "','"
					+ cadCPF
					+ "','"
					+ cadTelefone
					+ "','"
					+ cadLogradouro
					+ "','"
					+ cadNumero
					+ "','"
					+ cadBairro
					+ "','"
					+ cadCidade
					+ "','"
					+ cadEstado
					+ "')");
			JOptionPane.showMessageDialog(null, "Dados Salvos!");
		
		
		

		    
		
	}

	@Override
	public void update(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List select() {
		// TODO Auto-generated method stub
		return null;
	}

}
