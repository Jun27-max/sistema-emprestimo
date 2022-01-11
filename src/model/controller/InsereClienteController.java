package model.controller;

import javax.swing.JOptionPane;

import model.dao.impl.ClienteDaoJDBC;
import model.entities.Cliente;
import model.gui.JanelaCadastro;

public class InsereClienteController {

	private JanelaCadastro janelaCadastro;
	private Cliente cliente;

	public InsereClienteController(JanelaCadastro janelaCadastro) {
		this.janelaCadastro = janelaCadastro;
	}

	public void cadastrarCliente() {

		cliente.setNome(this.janelaCadastro.getFieldNome().getText());
		cliente.setEmail(this.janelaCadastro.getFieldEmail().getText());
		cliente.setCpf(this.janelaCadastro.getFieldCpf().getText());
		cliente.setRg(this.janelaCadastro.getFieldRG().getText());
		cliente.setEndereço(this.janelaCadastro.getFieldEndereco().getText());
		cliente.setRenda(Double.parseDouble(this.janelaCadastro.getFieldRenda().getText()));
		cliente.setSenha(this.janelaCadastro.getFieldSenha().getText());

		ClienteDaoJDBC dao = new ClienteDaoJDBC();
		dao.insert(cliente);

		JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!. ");

	}

}
