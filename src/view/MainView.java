package view;


import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class MainView {

	private JFrame frame;
	private JTextField txtSearch;
	private JButton btnNewNote;
	private JScrollPane scrollPane = new JScrollPane();

	public MainView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
		
		btnNewNote = new JButton("Neue Notiz");

		frame.getContentPane().add(btnNewNote, "cell 0 0,alignx center");
		
		txtSearch = new JTextField();
		txtSearch.setText("Suche");
		frame.getContentPane().add(txtSearch, "cell 1 0,growx");
		txtSearch.setColumns(10);

		frame.getContentPane().add(scrollPane, "cell 0 1 2 1,grow");
		scrollPane.setViewportView(new NoteTable());
		
		//TODO: Auto update the View!
		frame.setVisible(true);
	}
	
	public void setNewNoteListener(ActionListener l) {
		this.btnNewNote.addActionListener(l);
	}
	
	public void setscrollPaneContent (JPanel newPanel) {
		scrollPane.setViewportView(newPanel);
	}
	
	

}
