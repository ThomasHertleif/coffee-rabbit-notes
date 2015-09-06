package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NoteLoader {

	private FileReader reader;

	public NoteLoader() {

		// Load Stuff

	}

	public void loadNote(String fileName) {
		try {
			String entireFileText = new Scanner(new File(fileName)).useDelimiter("\\A").next();
			System.out.println(entireFileText);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Failed to load Note");
		}
	}
	

}
