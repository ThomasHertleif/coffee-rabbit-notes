package model;

import java.util.ArrayList;

public class NoteStore {

	private ArrayList<Note> noteArray;

	public NoteStore() {
		// TODO: Remove debug info
		System.out.println("Create new NoteStore");
		noteArray = new ArrayList<Note>();
	}

	public void add(Note newNote) {
		noteArray.add(newNote);
	}
	/*
	 * public void add(ArrayList<Note> moreNotes) { noteArray.addAll(moreNotes);
	 * }
	 */
}
