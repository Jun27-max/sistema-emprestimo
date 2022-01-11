package model.gui;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dao.impl.ClienteDaoJDBC;
import model.entities.Cliente;

public class JanelaListaEmprestimo extends JInternalFrame {

	private static final long serialVersionUID = 440187986214986723L;
	
	
	private JTabbedPane controleAbas;
	private JPanel abaCliente;
	private JPanel abaEmprestimo;;
	private JPanel painelBotoesCliente;
	private JPanel painelBotoesEmprestimo;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	private JTable tabelaCliente;
	private JTable tabelaEmprestimo;
	private JButton buttonBuscarCliente;
	private JButton buttonBuscarEmprestimo;

	private DefaultTableModel modeloCliente;
	private DefaultTableModel modeloEmprestimo;

	private List<Cliente> clientes;

	public JanelaListaEmprestimo() {
		modeloCliente = new DefaultTableModel();
		modeloEmprestimo = new DefaultTableModel();
		criarTabela();
		criarComponentes();
		ajustarPropriedadesJanela();
	}
	
	private void criarTabela() {
		
		tabelaCliente = new JTable(modeloCliente);
		tabelaCliente.setSize(700, 800);
		modeloCliente.addColumn("Nome");
		modeloCliente.addColumn("Renda");
		modeloCliente.addColumn("Primeira Parcela");
		modeloCliente.addColumn("Total");
		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(5);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(70);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(120);


		tabelaEmprestimo = new JTable(modeloEmprestimo);
		tabelaEmprestimo.setSize(700, 800);
		modeloEmprestimo.addColumn("Nome");
		modeloEmprestimo.addColumn("Renda");
		modeloEmprestimo.addColumn("Primeira Parcela");
		modeloEmprestimo.addColumn("Total");
		tabelaEmprestimo.getColumnModel().getColumn(0).setPreferredWidth(5);
		tabelaEmprestimo.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabelaEmprestimo.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabelaEmprestimo.getColumnModel().getColumn(3).setPreferredWidth(120);
		
	}

	private void criarComponentes() {
		
		
		controleAbas = new JTabbedPane();
		abaCliente = new JPanel();
		abaEmprestimo = new JPanel();
		painelBotoesCliente = new JPanel();
		painelBotoesCliente.setBorder(BorderFactory.createTitledBorder("Cliente"));
		painelBotoesEmprestimo = new JPanel();
		painelBotoesEmprestimo.setBorder(BorderFactory.createTitledBorder("Emprestimo"));
		
		
		scroll1 = new JScrollPane();
		scroll1.setViewportView(tabelaCliente);
		scroll2 = new JScrollPane();
		scroll2.setViewportView(tabelaEmprestimo);

		buttonBuscarCliente = new JButton("Atualizar");
		buttonBuscarCliente.addActionListener(this::buscarCliente);

		buttonBuscarEmprestimo = new JButton("Editar");
		buttonBuscarEmprestimo.addActionListener(this::buscarEmprestimo);


		adicionarComponentes();
		
	}
	
	private void adicionarComponentes() {
		painelBotoesCliente.add(buttonBuscarCliente);
		painelBotoesCliente.add(scroll1);

		painelBotoesEmprestimo.add(buttonBuscarEmprestimo);
		painelBotoesEmprestimo.add(scroll2);


		abaCliente.add(painelBotoesCliente);
		abaEmprestimo.add(painelBotoesEmprestimo);

		controleAbas.addTab("Cadastro Avulso", abaCliente);
		controleAbas.addTab("Cadastro Mensalista", abaEmprestimo);
		add(controleAbas);

	}
	
	
	private void ajustarPropriedadesJanela() {
		
		setTitle("Janela Relatório");
		setVisible(true);
		pack();
		setSize(700,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}



	public void buscarCliente(ActionEvent e) {

		int totalListaCliente = modeloCliente.getRowCount();
		if (modeloCliente.getRowCount() >= 0) {
			for (int i = 0; i < totalListaCliente; i++) {
				modeloCliente.removeRow(0);
			}
		}
		carregarListaCliente();
	}
	
	
	public void buscarEmprestimo(ActionEvent e) {
		int totalListaEmp = modeloEmprestimo.getRowCount();
		if (modeloEmprestimo.getRowCount() >= 0) {
			for (int i = 0; i < totalListaEmp; i++) {
				modeloEmprestimo.removeRow(0);
			}
		}
		carregarListaEmprestimo();
	}
	
	
	

	private void carregarListaCliente() {
		ClienteDaoJDBC dao = new ClienteDaoJDBC();
		clientes = dao.findAll();
		for (Cliente c : clientes) {
			modeloCliente.addRow(new Object[] { c.getId(), c.getNome(), c.getParcela() });
		}
	}
	
	
	private void carregarListaEmprestimo() {
		ClienteDaoJDBC dao = new ClienteDaoJDBC();
		clientes = dao.findAll();
		for (Cliente c : clientes) {
			modeloEmprestimo.addRow(new Object[] { c.getId(), c.getNome(), c.getParcela() });
		}
	}

}
