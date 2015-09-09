package view;


import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.*;

public class NoteTable extends JPanel {

	private JTable tbl_noteList;
	private Store<Note> noteStore;
	private Note[] nA;

	private DefaultTableModel dtm;

	public NoteTable(Store<Note> noteStore) {

		this.noteStore = noteStore;
		dtm = new DefaultTableModel(0, 0);

		tbl_noteList = new JTable();
		add(tbl_noteList);

		dtm.setColumnIdentifiers(new String[] { "Name", "Erstellt", "Geändert", "Priorität" });

		tbl_noteList.setModel(dtm);

	}

	public void updateTable(Store<Note> nStore) {		
		dtm.addRow(nStore.getAll().toArray());
		
		// remove all them rows
		if (dtm.getRowCount() > 0) {
			for (int i = dtm.getRowCount() - 1; i > -1; i--) {
				dtm.removeRow(i);
			}
		}

		// this.updateState();

		for (Note note : nStore.getAll()) {
			dtm.addRow(new Object[] { note.getTitle(), note.getCreateDate(), note.getChangeDate(), note.getPriority() });
		}

		tbl_noteList.updateUI();
	}

}
