package br.com.agenda.models;

public class Pessoa {
	
	private int Matricula;
	private String Nome;
	private String CPF;
	private String Telefone;
	private String Logradouro;
	private int Numero;
	private String Bairro;
	private String Cidade;
	private String Estado;
	
	
	public Pessoa(int matricula, String nome, String cpf, String telefone, String logradouro, int numero, String bairro,
			String cidade, String estado) {
		
		this.Matricula = matricula;
		this.Nome = nome;
		this.CPF = cpf;
		this.Telefone = telefone;
		this.Logradouro = logradouro;
		this.Numero = numero;
		this.Bairro = bairro;
		this.Cidade = cidade;
		this.Estado = estado;
	}
	
	public Pessoa() {}


	public int getMatricula() {
		return Matricula;
	}


	public void setMatricula(int matricula) {
		Matricula = matricula;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cpf) {
		CPF = cpf;
	}


	public String getTelefone() {
		return Telefone;
	}


	public void setTelefone(String telefone) {
		Telefone = telefone;
	}


	public String getLogradouro() {
		return Logradouro;
	}


	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}


	public int getNumero() {
		return Numero;
	}


	public void setNumero(int numero) {
		Numero = numero;
	}


	public String getBairro() {
		return Bairro;
	}


	public void setBairro(String bairro) {
		Bairro = bairro;
	}


	public String getCidade() {
		return Cidade;
	}


	public void setCidade(String cidade) {
		Cidade = cidade;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
	

}
