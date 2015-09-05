package model;

import java.util.ArrayList;

public class Store<T> {

	private ArrayList<T> data;
	
	public Store() {
		// TODO: Remove debug info
		System.out.println("Create new NoteStore");
		data = new ArrayList<T>();
	}

	public void add(T newNote) {
		data.add(newNote);
	}

	public void add(ArrayList<T> moreNotes) {
		data.addAll(moreNotes);
	}

	public ArrayList<T> getAll() {
		return data;
	}
	
	

}
