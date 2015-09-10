package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Note;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class NotePanel extends JPanel {

	private JTextField txtTitle;
	private JComboBox<String> cboxPrio = new JComboBox<String>();
	private JTextArea textArea = new JTextArea();
	private JButton btnSave = new JButton("Speichern");

	private Note currentNote = null;

	public NotePanel() {
		setLayout(new MigLayout("", "[grow][grow]", "[][grow][]"));

		add(textArea, "cell 0 1 2 1,grow");
		add(btnSave, "cell 0 2,alignx center");
		JLabel lblTitle = new JLabel("Titel:");
		add(lblTitle, "flowx,cell 0 0,alignx center");

		txtTitle = new JTextField();
		add(txtTitle, "cell 0 0");
		txtTitle.setColumns(10);

		JLabel lblPrio = new JLabel("Priorität:");
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

	public String getTitle() {
		return txtTitle.getText();
	}

	public String getPrio() {
		return (String) cboxPrio.getSelectedItem();
	}

	public String getText() {
		return textArea.getText();
	}

	public void setTitle(String t) {
		this.txtTitle.setText(t);
	}

	public void setPrio(String t) {
		this.cboxPrio.setSelectedItem(t);
	}

	public void setText(String t) {
		this.textArea.setText(t);
	}

	public Note getCurrentNote() {
		return currentNote;
	}

	public void setNote(Note sNote) {
		this.currentNote = sNote;
		txtTitle.setText(sNote.getTitle());
		cboxPrio.setSelectedItem(sNote.getPriority());
		textArea.setText(sNote.getText());
	}
	
	public void clear() {

		txtTitle.setText("");
		cboxPrio.setSelectedItem("");
		textArea.setText("");
	
	}
}
