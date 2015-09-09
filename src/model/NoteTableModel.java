package model;

import javax.swing.table.DefaultTableModel;

public class NoteTableModel extends DefaultTableModel{
	
	private static final long serialVersionUID = -6195535680249481279L;

	public NoteTableModel(Object[][] data, String[] headers) {
		super(data, headers);
	}
	
	public NoteTableModel(int rows, int cols) {
		super(rows, cols);
	}
	
	@Override
	public boolean isCellEditable(int row, int cols) {
		return false;
	}
	
}
