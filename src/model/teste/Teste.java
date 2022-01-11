package model.teste;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.gui.JanelaPrincipal;

public class Teste extends JPanel {

	private JLabel lbID;
	private JTextField textId;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lbNome;
	private JTextField textNome;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;

	public Teste() {
		setLayout(null);

		lbID = new JLabel("New label");
		lbID.setBounds(31, 32, 46, 14);
		add(lbID);

		textId = new JTextField();
		textId.setBounds(95, 29, 46, 20);
		add(textId);
		textId.setColumns(10);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(151, 32, 46, 14);
		add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(219, 29, 205, 20);
		add(textField_1);
		textField_1.setColumns(10);

		lbNome = new JLabel("New label");
		lbNome.setBounds(31, 78, 46, 14);
		add(lbNome);

		textNome = new JTextField();
		textNome.setBounds(95, 75, 238, 20);
		add(textNome);
		textNome.setColumns(10);

		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(31, 109, 46, 14);
		add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setBounds(95, 106, 46, 20);
		add(textField_3);
		textField_3.setColumns(10);

		JButton salvar = new JButton("salvar");
		salvar.setBounds(31, 152, 89, 23);
		add(salvar);

		JButton buscar = new JButton("New button");
		buscar.setBounds(447, 28, 89, 23);
		add(buscar);

		JButton editar = new JButton("Editar");
		editar.setBounds(351, 74, 89, 23);
		add(editar);

		JButton excluir = new JButton("New button");
		excluir.setBounds(447, 74, 89, 23);
		add(excluir);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Teste();
			}
		});
	}

}
