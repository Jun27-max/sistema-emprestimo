package application;

import model.gui.JanelaPrincipal;

public class Main {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JanelaPrincipal();
			}
		});

	}

}
