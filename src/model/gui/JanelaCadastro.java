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

import model.controller.InsereClienteController;

public class JanelaCadastro extends JInternalFrame {

	private static final long serialVersionUID = -5776708341913155789L;
	
	private JPanel painel;
    private JPanel painelTopo;
    private JPanel painelCentro;
    private JPanel painelRodape;
	
	private JLabel labelNome;
	private JLabel labelEmail;
	private JLabel labelCpf;
	private JLabel labelRg;
	private JLabel labelEndereco;
	private JLabel labelRenda;
	private JLabel labelSenha;

	private JTextField fieldNome;
	private JTextField fieldEmail;
	private JTextField fieldCpf;
	private JTextField fieldRg;
	private JTextField fieldEndereco;
	private JTextField fieldRenda;
	private JTextField fieldSenha;


	private JButton btnSalvarPessoa;
	private JButton btnLimpar;

	public JanelaCadastro() {
		super("Janela de Cadastro", true, true, true, true);
		criarComponentes();
		ajustarComponentes();
	}

	private void criarComponentes() {

		painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cadastro de Clientes"));
        painelTopo = new JPanel();
        painelCentro = new JPanel();
        painelRodape = new JPanel();
		

		labelNome = new JLabel("Nome: ");
		labelEmail = new JLabel("E-mail: ");
		labelCpf = new JLabel("CPF: ");
		labelRg = new JLabel("RG: ");
		labelEndereco = new JLabel("Endereço: ");
		labelRenda = new JLabel("Renda: ");
		labelSenha = new JLabel("Senha: ");

		fieldNome = new JTextField(18);
		fieldEmail = new JTextField(16);
		fieldCpf = new JTextField(12);
		fieldRg = new JTextField(12);
		fieldEndereco = new JTextField(30);
		fieldRenda = new JTextField(8);
		fieldSenha = new JTextField(8);

		btnSalvarPessoa = new JButton("Salvar");
		btnSalvarPessoa.addActionListener(this::onClickListener);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this::limpar);

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
		painelRodape.add(btnSalvarPessoa);
		painelRodape.add(btnLimpar);
		
		
		painelTopo.setBorder(BorderFactory.createEmptyBorder());
        painelCentro.setBorder(BorderFactory.createEmptyBorder());
        painelRodape.setBorder(BorderFactory.createEmptyBorder());

        painel.add(painelTopo);
        painel.add(painelCentro);
        painel.add(painelRodape);
		

		add(painel);

	}

	private void onClickListener(ActionEvent e) {
		if (e.getSource().equals(btnSalvarPessoa)) {
			if (fieldNome.getText().isBlank() || fieldEmail.getText().isBlank() || fieldEndereco.getText().isBlank()
					|| fieldRenda.getText().isBlank() || fieldSenha.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
				return;
			}

			InsereClienteController cliente = new InsereClienteController(this);
			cliente.cadastrarCliente();

		}
	}

	private void limpar(ActionEvent e) {
		fieldNome.setText(null);
		fieldEmail.setText(null);
		fieldCpf.setText(null);
		fieldRg.setText(null);
		fieldEndereco.setText(null);
		fieldRenda.setText(null);
		fieldSenha.setText(null);
	}

	private void ajustarComponentes() {
		setVisible(true);
		setSize(620,800);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	public JPanel getPanel() {
		return painel;
	}
	
	public JLabel getLabelNome() {
		return labelNome;
	}
	
	public JTextField getFieldNome() {
		return fieldNome;
	}
	
	public JLabel getLabelEmail() {
		return labelEmail;
	}

	public JTextField getFieldEmail() {
		return fieldEmail;
	}

	public JTextField getFieldCpf() {
		return fieldCpf;
	}

	public JTextField getFieldRG() {
		return fieldRg;
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



}
