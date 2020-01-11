package br.com.agenda.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.agenda.conection.Conexao;

public class Principal {
	
	public static void main(String[] args) {		
		insere(2,"Diego Pereira");
//		lista();		
	}
	
	static void insere(int matricula, String nome) {
		String sql = "INSERT INTO aluno (matricula,nome) VALUES ('"+matricula+
				"','"+nome+"');";
		Conexao con = new Conexao();
		int res = con.executeUpdate(sql);
		if (res >= 1) {
			System.out.println("Inserção realizada!");
		} else {
			System.err.println("Inserção NÃO realizada!");
		}
	}
 
	static void lista() {
		String sql = "SELECT * FROM aluno";
		Conexao con = new Conexao();
				
		System.out.println("Nome - Matrícula");
		try {
			ResultSet consulta = con.executeQuery(sql);
			while(consulta.next()) {
				int mat = consulta.getInt("matricula");
				String nome = consulta.getString("nome");
				System.out.println(nome+" - "+mat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
