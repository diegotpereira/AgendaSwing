package br.com.agenda.dao;

import java.util.List;

import br.com.agenda.models.Pessoa;

public interface Dao {
	
	  public void insert(Pessoa pessoa);
	  public void update(Pessoa pessoa);
	  public void delete(Pessoa pessoa);
	  public Object select(int id);
	  public List select();

}
