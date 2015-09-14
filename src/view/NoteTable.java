package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;

public class NoteTable extends JPanel {

	private JTable tbl_noteList;
	private Store<Note> noteStore;
	private Note[] nA;
	private DefaultTableModel dtm;
	private ListSelectionModel selectionModel;

	public NoteTable(Store<Note> noteStore) {

		setLayout(new MigLayout("", "[grow]", "[grow]"));

		this.noteStore = noteStore;

		// New ScrollPane because Table Header fix...
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,growx,aligny center");

		dtm = new DefaultTableModel(0, 0);
		dtm.setColumnIdentifiers(new String[] { "Name", "Erstellt", "Geändert", "Priorität" });

		tbl_noteList = new JTable(dtm);
		tbl_noteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_noteList.setAutoCreateRowSorter(true);

		selectionModel = tbl_noteList.getSelectionModel();

		scrollPane.setViewportView(tbl_noteList);

	}

	public void updateTable() {
		tbl_noteList.clearSelection();

		if (dtm.getRowCount() > 0) {
			for (int i = dtm.getRowCount() - 1; i > -1; i--) {
				dtm.removeRow(i);
			}
		}

		for (int i = 0; i < noteStore.getAll().size(); i++) {
			dtm.addRow(new Object[] { noteStore.getAll().get(i).getTitle(), noteStore.getAll().get(i).getCreateDate(),
					noteStore.getAll().get(i).getChangeDate(), noteStore.getAll().get(i).getPriority() });
		}
		tbl_noteList.updateUI();

	}

	public void setSelectionListener(ListSelectionListener l) {
		this.selectionModel.addListSelectionListener(l);
	}

	public int getSelected() {
		return tbl_noteList.getSelectedRow();
	}

}
