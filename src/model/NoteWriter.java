package model;

import java.io.*;
import java.util.stream.Stream;
import java.util.zip.*;

public class NoteWriter {

	private FileWriter writer;
	private Note note;
	private Store<Note> noteStore;

	public NoteWriter(Store<Note> noteStore) {
		this.noteStore = noteStore;
	}

//	public Stream<String[]> serializeNotes(Store<Note> notes) {
//		return notes.getAll().stream().map((note) -> {
//			// FIXME: add uuid field to note and use it instead of title here.
//			String[] nameAndContent = { note.getTitle(), note.cearialize() };
//			return nameAndContent;
//		});
//	}

	// Maybe for later use...
//	public void newNotebook(String name) {
//
//		try {
//			FileOutputStream dest = new FileOutputStream("C:/Users/Thomas/Documents/Notes/" + name + ".crnz");
//			ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(dest));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	// public void writeToDisk(Stream<String[]> textStream) {
	// textStream.forEach((nameAndContent) -> {
	// try {
	//
	// FileOutputStream dest = new
	// FileOutputStream("C:/Users/Thomas/Documents/Notes/" + "jim" + ".crnz");
	// ZipOutputStream zipOut = new ZipOutputStream(new
	// BufferedOutputStream(dest));
	//
	// ZipEntry e = new ZipEntry(nameAndContent[0]);
	//
	// zipOut.putNextEntry(e);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// });
	// }

	public void writeToDisk(Note note) {
		// TODO: Remove debug info
		System.out.println("Writing note to Disk");

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
			System.out.println("File writen to the disk");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Writer error");
		}
	}
}
