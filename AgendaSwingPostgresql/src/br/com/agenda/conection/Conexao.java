package br.com.agenda.conection;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;




public class Conexao {
	
	
	public static Connection conectar() throws Exception {
		
		Connection conec = null;
	      
	      try {
	          Class.forName("org.postgresql.Driver");
	          conec  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Agenda", "postgres","1234");
	      } catch (ClassNotFoundException | SQLException ex) {
	          System.out.println(ex.getMessage());
	      }
	      return conec;
	
        
     
    }
 
    //sobrecarga dos metodo desconectar,
    //na sobrecarga muda somente a assinatura dos metodos ou seja os parâmetros
    public static void desconectar(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Exceção, causa:" + e.getClass());
            e.printStackTrace();
        }
    }
 
    public static void desconectar(Connection conn, PreparedStatement pstm) {
        try {
            if (pstm != null) {
                pstm.close();
            }
 
            if (conn != null) {
                conn.close();
            }
 
        } catch (Exception e) {
            System.out.println("Exceção, causa:" + e.getClass());
            e.printStackTrace();
        }
    }
 
    public static void desconectar(Connection conn, PreparedStatement pstm, ResultSet rs) {
        try {
 
            if (rs != null) {
                rs.close();
            }
 
            if (pstm != null) {
                pstm.close();
            }
 
            if (conn != null) {
                conn.close();
            }
 
        } catch (Exception e) {
            System.out.println("Exceção, causa:" + e.getClass());
            e.printStackTrace();
 
        }
    }
}
