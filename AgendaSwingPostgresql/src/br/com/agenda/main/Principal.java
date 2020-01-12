package br.com.agenda.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.agenda.conection.Conexao;
import br.com.agenda.view.frmCadastro;

public class Principal {
	
	public static void main(String[] args) {	
		
		frmCadastro frm = new frmCadastro();
		frm.setVisible(true);
	}
}
