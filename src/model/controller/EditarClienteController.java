package model.controller;


import model.dao.impl.ClienteDaoJDBC;
import model.entities.Cliente;
import model.gui.JanelaConsulta;

public class EditarClienteController {
	
	private JanelaConsulta janela;
	private Cliente cliente;
	
	
	public EditarClienteController(JanelaConsulta janela) {
		this.janela = janela;
	}
	
	public void editarCliente() {
		
		String editarNome = janela.getFieldNome().getText().toString();
		String editarEmail = janela.getFieldEmail().getText().toString();
		String editarCpf = janela.getFieldCPF().getText().toString();
		String editarRg = janela.getFieldCPF().getText().toString();
		String editarEndereco = janela.getFieldEndereco().getText().toString();
		double editarRenda = Double.parseDouble(janela.getFieldRenda().getText().toString());
		String editarSenha = janela.getFieldSenha().getText().toString();
		double editarValor = Double.parseDouble(janela.getFieldValor().getText().toString());
		int editarParcela = Integer.parseInt(janela.getFieldParcela().getText().toString());
		
		ClienteDaoJDBC dao = new ClienteDaoJDBC();
		cliente = new Cliente(editarNome, editarEmail, editarCpf, editarRg, editarEndereco, editarRenda, editarSenha, editarValor, editarParcela);
		dao.update(cliente);
		
	}

}
