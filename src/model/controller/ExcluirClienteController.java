package model.controller;

import model.dao.impl.ClienteDaoJDBC;
import model.gui.JanelaConsulta;

public class ExcluirClienteController {

	private JanelaConsulta janela;

	public ExcluirClienteController(JanelaConsulta janela) {
		this.janela = janela;
	}

	public void excluirCliente(int id) {

		ClienteDaoJDBC dao = new ClienteDaoJDBC();

		dao.deleteById(id);

	}

}
