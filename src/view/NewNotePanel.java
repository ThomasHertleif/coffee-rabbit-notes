package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NewNotePanel extends JPanel {

	private JTextField txtTitle;
	private JComboBox<String> cboxPrio = new JComboBox<String>();

	private JButton btnCancel = new JButton("Abbrechen");
	private JTextArea textArea = new JTextArea();
	private JButton btnSave = new JButton("Speichern");

	public NewNotePanel() {
		setLayout(new MigLayout("", "[grow][grow]", "[][grow][]"));

		add(textArea, "cell 0 1 2 1,grow");
		add(btnSave, "cell 0 2,alignx center");
		add(btnCancel, "cell 1 2,alignx center");
				
						JLabel lblTitle = new JLabel("Titel:");
						add(lblTitle, "flowx,cell 0 0,alignx center");
		
				txtTitle = new JTextField();
				add(txtTitle, "cell 0 0");
				txtTitle.setColumns(10);
				
						JLabel lblPrio = new JLabel("Priorit\u00E4t:");
						add(lblPrio, "flowx,cell 1 0,alignx center");
						
								add(cboxPrio, "cell 1 0");
								cboxPrio.addItem("Niedrig");
								cboxPrio.addItem("Mittel");
								cboxPrio.addItem("Hoch");
								cboxPrio.setSelectedItem("Mittel");

	}

	public void setSaveListener(ActionListener l) {
		this.btnSave.addActionListener(l);
	}

}
