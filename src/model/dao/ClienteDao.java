package model.dao;

import java.util.List;

import model.entities.Cliente;
import model.entities.Emprestimo;

public interface ClienteDao {

	void insert(Cliente obj);

	void update(Cliente obj);

	void deleteById(Integer id);

	Cliente findById(Integer id);

	void insert(Emprestimo obj);

	void update(Emprestimo obj);

	void deleteEmprestimo(Integer id);

	List<Cliente> findAll();

}
