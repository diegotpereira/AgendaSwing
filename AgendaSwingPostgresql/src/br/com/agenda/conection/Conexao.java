package br.com.agenda.conection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;




public class Conexao {
	
	public Conexao(){
	      
	      
    }
    
    Connection conec;
  
public Connection getCon(){
      
      try {
          Class.forName("org.postgresql.Driver");
          conec  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "postgres","1234");
      } catch (ClassNotFoundException | SQLException ex) {
          System.out.println(ex.getMessage());
      }
      return conec;
  }  
 public void confirmar() throws SQLException {
      try {
          conec.commit();
      } catch (SQLException e) {
          throw new SQLException("Problemas na instrução SQL.\n" + e.getMessage());
      } finally {
          conec.close();
      }
  }
}
