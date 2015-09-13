package model;

import java.io.*;

public class NoteWriter {

	private FileWriter writer;
	private Note note;
	private Store<Note> noteStore;

	public NoteWriter(Store<Note> noteStore) {
		this.noteStore = noteStore;
	}

	public void writeToDisk(Note note) {

		this.note = note;

		File dir = new File("C:/Users/" + System.getProperty("user.name").toString() + "/Documents/CRNotes/");
		if (dir.exists() == false) {
			dir.mkdir();
		}

		try {
			writer = new FileWriter("C:/Users/" + System.getProperty("user.name").toString() + "/Documents/CRNotes/"
					+ note.getTitle() + ".crnz");
			writer.write(note.cearialize());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteNoteFromDisk(Note dNote) {
		File dir = new File("C:/Users/" + System.getProperty("user.name").toString() + "/Documents/CRNotes/"
				+ dNote.getTitle() + ".crnz");
		dir.delete();
	}
}
