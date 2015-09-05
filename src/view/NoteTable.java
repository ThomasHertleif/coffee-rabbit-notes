package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import model.*;

public class NoteTable extends JPanel {
	
	private NoteTableModel tblModel;
	
	private JTable tbl_noteList;
	private Store<Note> noteStore;
	
	public NoteTable(Store<Note> noteStore) {
		tbl_noteList = new JTable();
		add(tbl_noteList);
		 
		
		this.noteStore = noteStore;
		//this.tbl_noteList.setTableHeader(tblModel());
		
		
	}
	
	public void updateTable() {
		
	}
}
