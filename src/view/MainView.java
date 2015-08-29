package view;


import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainView {

	private JFrame frame;
	private JTextField txtSearch;
	private JButton btnNewNote;
	private JScrollPane scrollPane = new JScrollPane();
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mnAbout;

	public MainView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Coffee Rabbit Note");
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
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnHelp = new JMenu("Hilfe");
		menuBar.add(mnHelp);
		
		mnAbout = new JMenuItem("\u00DCber");
		mnHelp.add(mnAbout);
		
		// TODO: Maybe move this to a controller...
		mnAbout.addActionListener((e) -> {
			Component infoFrame = null;
			JOptionPane.showMessageDialog(infoFrame, "Coffee Rabbit Notes v0.0.0 von Thomas Hertleif", "Über",
				JOptionPane.PLAIN_MESSAGE);
		});
		
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
