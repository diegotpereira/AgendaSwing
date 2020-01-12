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
	

	
	private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    
    private final String SELECT=" SELECT * FROM EMPREGADO ";
    private final String INSERT=" INSERT INTO TabFicha(Matricula, Nome, CPF, Telefone, Logradouro, Numero, Bairro, Cidade, Estado)VALUES(?,?,?,?,?,?,?,?,?) ";
    private final String UPDATE=" UPDATE EMPREGADO SET NOME=?,DAT_NASC=?,SALARIO=? WHERE ID=? ";
    private final String DELETE=" DELETE FROM EMPREGADO WHERE ID=? ";
	
	
	
	// Salva os dados no BD
	@Override
	public void insert(Pessoa pessoa) {
		// TODO Auto-generated method stub
		  try {
			    conn=Conexao.conectar();
			    Conexao c = new Conexao();
	            pstm=conn.prepareStatement(INSERT);
	            pstm.setInt   (1, pessoa.getMatricula());
	            pstm.setString(2, pessoa.getNome());
	            pstm.setString(3, pessoa.getCPF());
	            pstm.setString(4, pessoa.getTelefone());
	            pstm.setString(5, pessoa.getLogradouro());
	            pstm.setInt   (6, pessoa.getNumero());
	            pstm.setString(7, pessoa.getBairro());
	            pstm.setString(8, pessoa.getCidade());
	            pstm.setString(9, pessoa.getEstado());
	 
	            pstm.executeUpdate();
				       
		  
		                } catch (Exception e) {
				            System.err.println("Ocorreu um erro, causa:"+e.getMessage());
				            e.printStackTrace();
				        }finally{
				            Conexao.desconectar(conn, pstm, rs);
				        }    
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
		
//		boolean consulta = true;
//
//		try {
//			// * Driver conector MySQL.
//			Class.forName("org.postgresql.Driver");
//
//			// * Conexão BD
//			Connection con = DriverManager.getConnection(
//					"jdbc:postgresql://localhost:5432/Agenda", "postgres","1234");
//
//			Statement stmt = con.createStatement();
//
//			// * Entras de dados no campo codigo do formulário.
//			int BuscaCodigo = Integer.parseInt(entBusca.getText());
//			String BuscaCPF = entBusca.getText();
//
//			ResultSet RS = null;
//
//			// Escolha a Opção de Busca.
//			if (opcaoBusca.getSelectedIndex() == 0) {
//				JOptionPane.showMessageDialog(null,
//						"Escolha uma Opção de Busca!");
//
//			} else if (opcaoBusca.getSelectedIndex() == 1) {
//				RS = stmt
//						.executeQuery("Select * from TabFicha where Matricula = "
//								+ BuscaCodigo);
//
//				while (RS.next()) {
//
//					// * Exibe os valore retornados na consulta.
//
//					// * Pega a Matricula.
//					int Mat = RS.getInt("Matricula");
//
//					// * Conver inteiro para String
//					saidaCodigo.setText(String.valueOf(Mat));
//
//					// Pega os demais.
//					saidaNome.setText(RS.getString("Nome"));
//					saidaCPF.setText(RS.getString("CPF"));
//					saidaTelefone.setText(RS.getString("Telefone"));
//					saidaLogradouro.setText(RS.getString("Logradouro"));
//					saidaNumero.setText(RS.getString("Numero"));
//					saidaBairro.setText(RS.getString("Bairro"));
//					saidaCidade.setText(RS.getString("Cidade"));
//					saidaEstado.setText(RS.getString("Estado"));
//
//					consulta = false;
//					JOptionPane.showMessageDialog(null, "Dados Encontrado!");
//
//				}
//
//			} else if (opcaoBusca.getSelectedIndex() == 2) {
//				RS = stmt.executeQuery("Select * from TabFicha where CPF = "
//						+ BuscaCPF);
//
//				while (RS.next()) {
//
//					// * Pega o CPF.
//					String CPF = RS.getString("CPF");
//					saidaCPF.setText(CPF);
//
//					// * Exibe os valore retornados na consulta.
//					saidaNome.setText(RS.getString("Nome"));
//					saidaCodigo.setText(RS.getString("Matricula"));
//					saidaTelefone.setText(RS.getString("Telefone"));
//					saidaLogradouro.setText(RS.getString("Logradouro"));
//					saidaNumero.setText(RS.getString("Numero"));
//					saidaBairro.setText(RS.getString("Bairro"));
//					saidaCidade.setText(RS.getString("Cidade"));
//					saidaEstado.setText(RS.getString("Estado"));
//
//					consulta = false;
//					JOptionPane.showMessageDialog(null, "Dados Encontrado!");
//
//				}
//
//			}
//
//			if (consulta) {
//				JOptionPane.showMessageDialog(null, "Dados não Encontrados!");
//
//			}
//			RS.close();
//			stmt.close();
//
//			// * Fecha conexão com DB.
//			con.close();
//
//		} catch (SQLException Erro) {
//			JOptionPane.showMessageDialog(null,
//					"Erro Cmdo SQL" + Erro.getMessage());
//
//		} catch (ClassNotFoundException Erro) {
//			JOptionPane.showMessageDialog(null, "Driver não Encontrado!");
//
//		}
		return null;
	}

	@Override
	public List select() {
		// TODO Auto-generated method stub
		return null;
	}

}
