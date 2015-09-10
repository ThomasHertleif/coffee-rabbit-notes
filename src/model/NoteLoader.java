package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoteLoader {

	static private String keyVal = "^(?<key>\\w*): \"(?<val>.*)\"";
	private Store<Note> noteStore;

	public NoteLoader(Store<Note> noteStore) {
		this.noteStore = noteStore;

	}

	public Note loadNote(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);

		sc.nextLine(); // "---"

		String title = sc.nextLine().replaceAll(keyVal, "${val}");
		String priority = sc.nextLine().replaceAll(keyVal, "${val}");
		String created = sc.nextLine().replaceAll(keyVal, "${val}");
		String changed = sc.nextLine().replaceAll(keyVal, "${val}");

		sc.nextLine(); // "---"

		String content = sc.useDelimiter("\\A").next();

		Note leNote = new Note(title, priority, content, created, changed);

		sc.close();

		return leNote;
	}

	public void loadDirectory(File[] files) throws FileNotFoundException {

		this.noteStore.clearStore();
		
		
		
		for (int i = 0; i < files.length; i++) {
			Scanner sc = new Scanner(files[i]);	
			sc.nextLine(); // "---"

			String title = sc.nextLine().replaceAll(keyVal, "${val}");
			String priority = sc.nextLine().replaceAll(keyVal, "${val}");
			String created = sc.nextLine().replaceAll(keyVal, "${val}");
			String changed = sc.nextLine().replaceAll(keyVal, "${val}");

			sc.nextLine(); // "---"

			String content = sc.useDelimiter("\\A").next();
			Note leNote = new Note(title, priority, content, created, changed);

			noteStore.add(leNote);
			sc.close();
		}
	}
}
