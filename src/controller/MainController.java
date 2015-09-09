package controller;

import view.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.*;

public class MainController {

	private MainView mainView;
	private Store<Note> noteStore;
	private NotePanel newNotePanel;
	private NoteTable noteTable;
	private NoteWriter noteWriter;
	private NoteLoader noteLoader;

	public MainController() {
		this.noteStore = new Store<Note>();
		this.newNotePanel = new view.NotePanel();
		this.noteTable = new NoteTable(noteStore);
		this.noteWriter = new NoteWriter(noteStore);
		this.noteLoader = new NoteLoader(noteStore);

		this.mainView = new MainView();
		this.mainView.setscrollPaneContent(newNotePanel);
		this.mainView.setScrollTable(noteTable);

		// MainView
		this.mainView.setNewNoteListener((e) -> {
			// TODO: Remove debug Info
			System.out.println("Creating a new note.");
			mainView.setscrollPaneContent(new NotePanel());
		});

		// NewNotePanel
		this.newNotePanel.setSaveListener((e) -> {
			// TODO: Remove debug Info
			System.out.println("Start save");
			Note newNote = new Note(this.newNotePanel.getTitle(), this.newNotePanel.getPrio(),
					this.newNotePanel.getText());
			this.noteStore.add(newNote);
			this.mainView.setScrollTable(noteTable);

			this.noteWriter.writeToDisk(newNote);

		});

		this.newNotePanel.setCancelListener((e) -> {
			// TODO: Remove Cancel Button
			this.mainView.setscrollPaneContent(noteTable);
		});

		this.mainView.setFileOpenListener((e) -> {

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Coffee Rabbit Notebook", "crnz");

			JFileChooser fileSelect = new JFileChooser();
			fileSelect.setMultiSelectionEnabled(false);
			fileSelect.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileSelect.setFileFilter(filter);

			int returnVal = fileSelect.showOpenDialog(null);

			if (returnVal != JFileChooser.APPROVE_OPTION) {
				return;
			}

			try {
				Note newNote = this.noteLoader.loadNote(fileSelect.getSelectedFile());
				System.out.println(newNote);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		this.mainView.setFolderListener((e) -> {
			JFileChooser folderSelect = new JFileChooser();
			folderSelect.setMultiSelectionEnabled(false);
			folderSelect.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int returnVal = folderSelect.showOpenDialog(null);

			if (returnVal != JFileChooser.APPROVE_OPTION) {
				return;
			}

			try {
				this.noteLoader.loadDirectory(folderSelect.getSelectedFile().listFiles());
				this.noteTable.updateTable(noteStore);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
}
