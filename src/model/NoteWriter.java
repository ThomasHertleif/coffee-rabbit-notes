package model;

import java.io.*;

public class NoteWriter {

	private FileWriter writer;
	private Note note;

	public NoteWriter() {

	}

	public void writeToDisk(Note note) {
		// TODO: Remove debug info
		System.out.println("Writing note to Disk");

		this.note = note;

		try {
			writer = new FileWriter("C:/Users/Thomas/Documents/Notes/" + note.getTitle() + ".txt");
			writer.write(note.getPriority() + "§" + note.getCreateDate() + "§" + note.getChangeDate() + "§");
			writer.write(note.getText());
			writer.flush();
			writer.close();
			System.out.println("File writen to the disk");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
