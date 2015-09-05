package controller;

import view.*;
import model.*;

// TODO: Make sub controller?
public class MainController {

	private MainView mainView;
	private Store<Note> noteStore;
	private NewNotePanel newNotePanel = new view.NewNotePanel();
	private NoteTable noteTable = new view.NoteTable(noteStore);
	private NoteWriter fileWriter = new NoteWriter();
	private NoteLoader noteLoader = new NoteLoader();

	public MainController(MainView MainView, Store<Note> noteStore) {
		this.mainView = MainView;
		this.noteStore = noteStore;
		this.mainView.setscrollPaneContent(noteTable);
		
		// MainView
		this.mainView.setNewNoteListener((e) -> {
			// TODO: Remove debug Info
			System.out.println("Creating a new note.");
			mainView.setscrollPaneContent(newNotePanel);
		});

		// NewNotePanel
		this.newNotePanel.setSaveListener((e) -> {
			// TODO: Remove debug Info
			System.out.println("Start save");
			Note newNote = new Note(this.newNotePanel.getTitle(), this.newNotePanel.getPrio(), this.newNotePanel.getText());
			this.noteStore.add(newNote);
			this.mainView.setscrollPaneContent(noteTable);
			
			this.fileWriter.writeToDisk(newNote);
			
		});
		
		this.newNotePanel.setCancelListener((e) -> {
			this.mainView.setscrollPaneContent(noteTable);
		});
		
		
		// TODO: Specify the File to load 
		this.mainView.setFileOpenListener((e) -> {
			this.noteLoader.loadNote();
		});
	}
}
