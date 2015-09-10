package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.*;

public class MainView {

	private JFrame frame;
	private JButton btnNewNote;
	private JScrollPane scrollPane = new JScrollPane();
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mnAbout;
	private JScrollPane scrollTable;
	private NoteTable noteTable;
	private Store<Note> noteStore;
	private JButton btnOpenFolder;

	public MainView() {
		initialize();
	}

	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		frame = new JFrame();
		frame.setTitle("Coffee Rabbit Note");
		frame.setBounds(100, 100, 843, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow 150][grow][grow]", "[][grow]"));
		
		btnOpenFolder = new JButton("Ordner öffnen");
		frame.getContentPane().add(btnOpenFolder, "cell 0 0");

		btnNewNote = new JButton("Neue Notiz");

		frame.getContentPane().add(btnNewNote, "cell 1 0,alignx center");

		scrollTable = new JScrollPane();
		frame.getContentPane().add(scrollTable, "cell 0 1,grow");
		noteTable = new NoteTable(noteStore);
		scrollTable.setViewportView(noteTable);

		frame.getContentPane().add(scrollPane, "cell 1 1 2 1,grow");

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		

		mnHelp = new JMenu("Hilfe");
		menuBar.add(mnHelp);

		mnAbout = new JMenuItem("Über");
		mnHelp.add(mnAbout);

		// TODO: Maybe move this to a controller...
		mnAbout.addActionListener((e) -> {
			Component infoFrame = null;
			JOptionPane.showMessageDialog(infoFrame, "Coffee Rabbit Notes v0.0.0 von Thomas Hertleif", "Über",
					JOptionPane.PLAIN_MESSAGE);
		});

		frame.setVisible(true);
	}

	public void setNewNoteListener(ActionListener l) {
		this.btnNewNote.addActionListener(l);
	}

	public void setscrollPaneContent(JPanel newPanel) {
		this.scrollPane.setViewportView(newPanel);
	}

	public void setScrollTable(JPanel newPanel) {
		this.scrollTable.setViewportView(newPanel);
	}

	public void setFolderListener(ActionListener l) {
		this.btnOpenFolder.addActionListener(l);
	}
}
