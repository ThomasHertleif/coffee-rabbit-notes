package model;

import java.util.stream.Stream;
import java.io.*;

public class NoteWriter {

	private FileWriter writer;
	private Note note;

	public void writeToDisk(Note note) {
		// TODO: Remove debug info
		System.out.println("Writing note to Disk");
		System.out.println("File writen to the disk");

		this.note = note;

		try {
			writer = new FileWriter(note.getTitle() + ".txt");
			writer.write(note.getText());
			writer.flush();
			writer.close();
			System.out.println("Finisch");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		writer = new PrintWriter(new BufferedWriter(new java.io.FileWriter(note.getTitle())));

	}
}
