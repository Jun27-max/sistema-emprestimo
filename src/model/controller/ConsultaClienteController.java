package model.controller;

import model.dao.impl.ClienteDaoJDBC;
import model.entities.Cliente;
import model.gui.JanelaConsulta;

public class ConsultaClienteController {
	
	
	private JanelaConsulta janela;
	private Cliente cliente;
	
	
	public ConsultaClienteController(JanelaConsulta janela) {
		this.janela = janela;
	}
	
	public Cliente consultarId() {
		ClienteDaoJDBC dao = new ClienteDaoJDBC();

		int buscaId = Integer.parseInt(janela.getLabelIdBusca().getText().toString());

		cliente = dao.findById(buscaId);

		return cliente;

	}

}
