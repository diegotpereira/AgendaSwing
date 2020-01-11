package br.com.agenda.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {
	
	 private String url;
	    private String usr;
	    private String pass;
	    
	    public Conexao() {     
	        url="jdbc:postgresql://localhost:5432/Agenda";
	        usr="postgresql";
	        pass="1234";
	    }
	    
	    private Connection getConnection(){
	        try {
	            Class.forName("org.postgresql.Driver");
	           
	            Connection con = DriverManager.getConnection(url, usr, pass);
	            return con;
	        }catch(ClassNotFoundException ex){
	            JOptionPane.showMessageDialog(null, "O driver n�o foi encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
	            return null;
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "Problemas com a conex�o\n"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	            return null;
	        }
	    }
	 
	    public int executeUpdate(String query){
	        try{
	            Connection con = getConnection();
	            Statement stm = con.createStatement();
	            System.out.println(query);
	            int res=stm.executeUpdate(query);
	            con.close();
	            return res;
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "Problemas com a conex�o\n"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	            return 0;
	        }
	    }
	 
	    public ResultSet executeQuery(String query){
	        try{
	            Connection con = getConnection();
	            Statement stm = con.createStatement();
	            ResultSet rs = stm.executeQuery(query);
	            //con.close();
	            return rs;
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "Problemas com a conex�o\n"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	            return null;
	        }
	    }

}
