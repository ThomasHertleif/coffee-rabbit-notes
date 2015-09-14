package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PWHandler {

	public PWHandler() {
		
	}
	
	public boolean checkCFG() {
		File cfg = new File("C:/Users/" + System.getProperty("user.name").toString() + "/Documents/CRNotes/crnz.cfg");
		if (cfg.exists() == false) {
			return false;
		} else 
			return true;
	}

	public void createCFG(String pw) throws IOException {
		File dir = new File("C:/Users/" + System.getProperty("user.name").toString() + "/Documents/CRNotes/");
		if (dir.exists() == false) {
			dir.mkdir();
		}
		
		File cfg = new File("C:/Users/" + System.getProperty("user.name").toString() + "/Documents/CRNotes/crnz.cfg");
		if (cfg.exists() == false) {
			FileWriter writer = new FileWriter(cfg);
			writer.write(pw);
			writer.flush();
			writer.close();
		}
	}

	public String getCFGpw() throws FileNotFoundException {
		File cfg = new File("C:/Users/" + System.getProperty("user.name").toString() + "/Documents/CRNotes/crnz.cfg");
		Scanner sc = new Scanner(cfg);
		return sc.nextLine();
	}

}
