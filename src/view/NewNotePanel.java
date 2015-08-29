package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class NewNotePanel extends JPanel {
	private JTextField txtTitle;

	public NewNotePanel() {
		setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
		
		JLabel lblPrio = new JLabel("Priorit\u00E4t:");
		add(lblPrio, "flowx,cell 0 0");
		
		JLabel lblTitle = new JLabel("Titel:");
		add(lblTitle, "flowx,cell 1 0");
		
		txtTitle = new JTextField();
		add(txtTitle, "cell 1 0");
		txtTitle.setColumns(10);
		
		JComboBox cboxPrio = new JComboBox();
		add(cboxPrio, "cell 0 0");
		
		JTextArea textArea = new JTextArea();
		add(textArea, "cell 0 1 2 1,grow");

	}

}
