package controller;

import view.*;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;

public class MainController {

	private MainView mainView;
	private Store<Note> noteStore;
	private NotePanel newNotePanel;
	private NoteTable noteTable;
	private NoteWriter noteWriter;
	private NoteLoader noteLoader;

	public MainController() throws FileNotFoundException {
		this.noteStore = new Store<Note>();
		this.newNotePanel = new view.NotePanel();
		this.noteTable = new NoteTable(noteStore);
		this.noteWriter = new NoteWriter(noteStore);
		this.noteLoader = new NoteLoader(noteStore);

		this.mainView = new MainView();
		this.mainView.setscrollPaneContent(newNotePanel);
		this.mainView.setScrollTable(noteTable);

		File dir = new File("C:/Users/" + System.getProperty("user.name").toString() + "/Documents/CRNotes/");
		File[] listOfNoteFile = dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".txt");
			}
		});
		
		if (dir.exists() == true) {
			this.noteLoader.loadDirectory(listOfNoteFile);
			this.noteTable.updateTable();
		}
		dir.mkdir();
		// MainView
		this.mainView.setNewNoteListener((e) -> {
			this.newNotePanel.clear();
			this.newNotePanel.removeNote();
		});

		// NewNotePanel
		this.newNotePanel.setSaveListener((e) -> {

			if (this.newNotePanel.getTitle().equals("")) {
				Component infoFrame = null;
				JOptionPane.showMessageDialog(infoFrame, "Bitte Titel eingeben.", "Warnung", JOptionPane.PLAIN_MESSAGE);

			} else {

				Note existingNote = this.newNotePanel.getCurrentNote();

				if (existingNote != null) {
					existingNote.setTitle(this.newNotePanel.getTitle());
					existingNote.setPriority(this.newNotePanel.getPrio());
					existingNote.setText(this.newNotePanel.getText());

					this.noteWriter.writeToDisk(existingNote);
				} else {
					Note newNote = new Note(this.newNotePanel.getTitle(), this.newNotePanel.getPrio(),
							this.newNotePanel.getText());

					this.noteStore.add(newNote);
					this.noteWriter.writeToDisk(newNote);
				}

				this.noteTable.updateTable();
				this.newNotePanel.clear();
			}
		});

		this.newNotePanel.setDeleteListener((e) -> {

			if (this.newNotePanel.getCurrentNote() != null) {
				this.noteWriter.deleteNoteFromDisk(this.newNotePanel.getCurrentNote());
				this.noteStore.removeNote(this.newNotePanel.getCurrentNote());
				this.newNotePanel.clear();
				this.newNotePanel.removeNote();
				this.noteTable.updateTable();
			}

		});

		this.noteTable.setSelectionListener((e) -> {
			ArrayList<Note> list = noteStore.getAll();
			int selected = noteTable.getSelected();

			if (selected >= 0 && list.size() >= selected) {
				this.newNotePanel.setNote(list.get(selected));
			}
			// this.mainView.setscrollPaneContent(newNotePanel);
		});

	}
}
