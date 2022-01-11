package model.gui;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.controller.ConsultaClienteController;
import model.controller.EditarClienteController;
import model.controller.ExcluirClienteController;
import model.entities.Cliente;

public class JanelaConsulta extends JInternalFrame {

	private static final long serialVersionUID = 5103810395385969446L;

	private JPanel panel;

	private JPanel painel;
	private JPanel painelTopo;
	private JPanel painelCentro;
	private JPanel painelRodape;

	private JLabel labelIdBusca;
	private JLabel labelNome;
	private JLabel labelEmail;
	private JLabel labelCpf;
	private JLabel labelRg;
	private JLabel labelEndereco;
	private JLabel labelRenda;
	private JLabel labelSenha;
	private JLabel labelParcela;
	private JLabel labelTotal;

	private JTextField fieldBusca;
	private JTextField fieldNome;
	private JTextField fieldEmail;
	private JTextField fieldCpf;
	private JTextField fieldRg;
	private JTextField fieldEndereco;
	private JTextField fieldRenda;
	private JTextField fieldSenha;
	private JTextField fieldParcela;
	private JTextField fieldTotal;

	private JButton btnBuscar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnSalvar;

	private Integer id;

	public JanelaConsulta() {
		super("Janela de Cadastro", true, true, true, true);
		criarComponentes();
		configurarJanela();
	}

	private void criarComponentes() {
		painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cadastro de Clientes"));
		painelTopo = new JPanel();
		painelCentro = new JPanel();
		painelRodape = new JPanel();
		
		labelIdBusca = new JLabel("Buscar: ");
		labelNome = new JLabel("Nome: ");
		labelEmail = new JLabel("E-mail: ");
		labelCpf = new JLabel("CPF: ");
		labelRg = new JLabel("RG: ");
		labelEndereco = new JLabel("Endereço: ");
		labelRenda = new JLabel("Renda: ");
		labelSenha = new JLabel("Senha: ");
		labelParcela = new JLabel("Parcela: ");
		labelTotal = new JLabel("Total: ");
		
		fieldBusca = new JTextField(3);
		fieldNome = new JTextField(18);
		fieldEmail = new JTextField(16);
		fieldCpf = new JTextField(12);
		fieldRg = new JTextField(12);
		fieldEndereco = new JTextField(30);
		fieldRenda = new JTextField(8);
		fieldSenha = new JTextField(8);
		fieldParcela = new JTextField(8);
		fieldTotal = new JTextField(8);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this::buscarListener);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this::editarListener);

		btnExcluir = new JButton("Excluir");
		;
		btnExcluir.addActionListener(this::excluirListener);

		btnSalvar = new JButton("salvar");
		btnSalvar.addActionListener(this::salvarListener);
		
		
		painelTopo.add(labelIdBusca);
		painelTopo.add(fieldBusca);
		painelTopo.add(labelNome);
		painelTopo.add(fieldNome);
		painelTopo.add(labelEmail);
		painelTopo.add(fieldEmail);
		painelCentro.add(labelCpf);
		painelCentro.add(fieldCpf);
		painelCentro.add(labelRg);
		painelCentro.add(fieldRg);
		painelCentro.add(labelEndereco);
		painelCentro.add(fieldEndereco);
		painelCentro.add(labelRenda);
		painelCentro.add(fieldRenda);
		painelCentro.add(labelSenha);
		painelCentro.add(fieldSenha);
		painelCentro.add(labelParcela);
		painelCentro.add(fieldParcela);
		painelCentro.add(labelTotal);
		painelCentro.add(fieldTotal);
		painelRodape.add(btnBuscar);
		painelRodape.add(btnEditar);
		painelRodape.add(btnExcluir);
		painelRodape.add(btnSalvar);

		painelTopo.setBorder(BorderFactory.createEmptyBorder());
		painelCentro.setBorder(BorderFactory.createEmptyBorder());
		painelRodape.setBorder(BorderFactory.createEmptyBorder());

		painel.add(painelTopo);
		painel.add(painelCentro);
		painel.add(painelRodape);

		add(painel);

	}

	private void configurarJanela() {
		setVisible(true);
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void buscarListener(ActionEvent e) {

		if (fieldBusca.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Preencha os campos para a pesquisa");
			return;
		}
		ConsultaClienteController cliente = new ConsultaClienteController(this);
		Cliente c = cliente.consultarId();
		if (c == null) {
			JOptionPane.showMessageDialog(this, "Id não inválido");
			return;
		}
		carregaBusca(c);

	}

	private void editarListener(ActionEvent e) {
		fieldNome.setEditable(true);
		fieldEmail.setEditable(true);
		fieldCpf.setEditable(true);
		fieldRg.setEditable(true);
		fieldEndereco.setEditable(true);
		fieldRenda.setEditable(true);
		fieldSenha.setEditable(true);
		fieldParcela.setEditable(true);
		fieldTotal.setEditable(true);
	}

	private void salvarListener(ActionEvent e) {

		if (fieldNome.getText().isBlank() || fieldEmail.getText().isBlank() || fieldCpf.getText().isBlank()
				|| fieldRg.getText().isBlank() || fieldEndereco.getText().isBlank() || fieldRenda.getText().isBlank()
				|| fieldSenha.getText().isBlank() || fieldParcela.getText().isBlank()
				|| fieldTotal.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
			return;
		}
		EditarClienteController ec = new EditarClienteController(this);
		ec.editarCliente();
		;
		JOptionPane.showMessageDialog(this, "Registro alterado");
		resetaCampos();

	}

	private void excluirListener(ActionEvent e) {
		ExcluirClienteController ec = new ExcluirClienteController(this);
		if (id != null) {
			ec.excluirCliente(id);
		}
		JOptionPane.showMessageDialog(this, "Registro excluído");

		resetaCampos();
	}

	private void carregaBusca(Cliente cliente) {
		fieldNome.setText(cliente.getNome());
		fieldParcela.setText("" + cliente.getParcela());
		fieldTotal.setText("" + cliente.getValor());
		setId(cliente.getId());
		btnEditar.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnSalvar.setEnabled(true);
	}

	private void resetaCampos() {
		fieldNome.setText("");
		fieldParcela.setText("");
		fieldTotal.setText("");

		fieldNome.setEditable(false);
		fieldParcela.setEditable(false);
		fieldTotal.setEditable(false);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnSalvar.setEnabled(false);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JLabel getLabelIdBusca() {
		return labelIdBusca;
	}

	public JTextField getfIdBusca() {
		return fieldBusca;
	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldEmail() {
		return fieldEmail;
	}

	public JTextField getFieldCPF() {
		return fieldCpf;
	}

	public JTextField getFieldEndereco() {
		return fieldEndereco;
	}

	public JTextField getFieldRenda() {
		return fieldRenda;
	}

	public JTextField getFieldSenha() {
		return fieldSenha;
	}

	public JTextField getFieldValor() {
		return fieldTotal;
	}

	public JTextField getFieldParcela() {
		return fieldParcela;
	}

}
