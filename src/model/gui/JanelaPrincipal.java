package model.gui;

import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaPrincipal extends JFrame {
	private static final long serialVersionUID = 2042082930009264780L;

	private JDesktopPane desktop;

	private JMenuBar barra;

	private JMenu menuArquivo;

	private JMenuItem itemCadastro;
	private JMenuItem itemConsulta;
	private JMenuItem itemListar;
	private JMenuItem itemSair;

	public JanelaPrincipal() {
		super("Menu");
		criarComponentes();
		ajustarComponentes();

	}

	private void criarComponentes() {
		desktop = new JDesktopPane();

		barra = new JMenuBar();

		menuArquivo = new JMenu("Arquivo");

		itemCadastro = new JMenuItem("Cadastrar Cliente");
		itemCadastro.addActionListener(this::abrirJanelaCadastro);

		itemConsulta = new JMenuItem("Consultar Cadastros");
		itemConsulta.addActionListener(this::abrirJanelaConsulta);

		itemListar = new JMenuItem("Listar Empréstimos");
		itemListar.addActionListener(this::abrirJanelaListarPessoas);

		itemSair = new JMenuItem("Sair");
		itemSair.addActionListener(this::sair);

		menuArquivo.add(itemCadastro);
		menuArquivo.add(itemConsulta);
		menuArquivo.add(itemListar);
		menuArquivo.addSeparator();
		menuArquivo.add(itemSair);

		barra.add(menuArquivo);

		setJMenuBar(barra);

		add(desktop);

	}

	private void ajustarComponentes() {
		setVisible(true);
        setSize(1200,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	 private void abrirJanelaCadastro(ActionEvent e) {    	
	    	JanelaCadastro form = new JanelaCadastro();
	    	carregarJanela(form);
	    }
	 
	    
	    private void abrirJanelaConsulta(ActionEvent e) {    	
	    	JanelaConsulta form = new JanelaConsulta();
	    	carregarJanela(form);
	    }
	    
	    private void abrirJanelaListarPessoas(ActionEvent e) {    	
	    	JanelaListaEmprestimo form = new JanelaListaEmprestimo();
	    	carregarJanela(form);;
	    }

	    private void carregarJanela(JInternalFrame janela) {
	        desktop.add(janela);
	        desktop.moveToFront(janela);
	    }
	    
	    private void sair(ActionEvent e) {
	        System.exit(0);
	    }

}
