package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class NewNotePanel extends JPanel {

	public NewNotePanel() {
		setLayout(new MigLayout("", "[grow][grow]", "[]"));
		
		JLabel lblPrio = new JLabel("Priorit\u00E4t:");
		add(lblPrio, "cell 0 0");

	}

}
