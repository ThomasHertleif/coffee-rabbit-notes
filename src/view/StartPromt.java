package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class StartPromt extends JPanel {

	/**
	 * Create the panel.
	 */
	public StartPromt() {
		setLayout(new MigLayout("", "[grow]", "[][]"));
		
		JButton btnNewNotebook = new JButton("Neues Notizbuck erstellen");
		add(btnNewNotebook, "cell 0 0,alignx center");
		
		JButton btnOpenNotebook = new JButton("Notizbuch öffnen");
		add(btnOpenNotebook, "cell 0 1,alignx center");

	}

}
