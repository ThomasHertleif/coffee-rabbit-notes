package model;

import java.util.ArrayList;

public class Store<T> {

	private ArrayList<T> data;
	
	public Store() {
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
	
	public void clearStore() {
		if (data.isEmpty() == false) {
			for (int i = 0; i < data.size(); i++) {
				data.remove(i);
			}
		}
	}
}
