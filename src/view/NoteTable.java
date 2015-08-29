package view;

import javax.swing.JPanel;
import javax.swing.JTable;

public class NoteTable extends JPanel {
	private JTable tbl_noteList;

	public NoteTable() {
		
		tbl_noteList = new JTable();
		add(tbl_noteList);

	}

}
