package model.dao;

import java.util.List;

import model.entities.Cliente;
import model.entities.Emprestimo;

public interface ClienteDao {
	
	void insert(Cliente obj);

	void update(Cliente obj);

	void deleteById(Integer id);

	Cliente findById(Integer id);

	List<Cliente> findAll();

	List<Cliente> findByEmprestimo(Emprestimo emprestimo);
	
	

}
