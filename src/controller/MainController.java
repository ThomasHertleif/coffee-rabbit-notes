package controller;

import view.*;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
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
		File[] listOfFiles = dir.listFiles();
		this.noteLoader.loadDirectory(listOfFiles);
		this.noteTable.updateTable();
		// MainView
		this.mainView.setNewNoteListener((e) -> {
			// TODO: Remove debug Info
			System.out.println("Creating a new note.");
			mainView.setscrollPaneContent(this.newNotePanel);
		});

		// NewNotePanel
		this.newNotePanel.setSaveListener((e) -> {
			// TODO: Remove debug Info
			System.out.println("Start save");

			if (this.newNotePanel.getTitle().equals("")) {
				Component infoFrame = null;
				JOptionPane.showMessageDialog(infoFrame, "Bitte Titel eingeben.", "Warnung", JOptionPane.PLAIN_MESSAGE);

			} else {

				Note existingNote = this.newNotePanel.getCurrentNote();

				if (existingNote != null) {
					System.out.println("existing note" + existingNote);
					existingNote.setTitle(this.newNotePanel.getTitle());
					existingNote.setPriority(this.newNotePanel.getPrio());
					existingNote.setText(this.newNotePanel.getText());

					this.noteWriter.writeToDisk(existingNote);
				} else {
					System.out.println("its a new note, its a new day, ...");
					Note newNote = new Note(this.newNotePanel.getTitle(), this.newNotePanel.getPrio(),
							this.newNotePanel.getText());

					this.noteStore.add(newNote);
					this.noteWriter.writeToDisk(newNote);
				}

				this.noteTable.updateTable();
				this.newNotePanel.clear();
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
