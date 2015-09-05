package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NoteLoader {

	private FileReader reader;

	public NoteLoader() {

		// Load Stuff

	}

	public void loadNote() {
		try {
			reader = new FileReader("test.txt");

			try {
				System.out.println(reader.read());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to load Note");
		}
	}

}
