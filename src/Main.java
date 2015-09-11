import java.awt.Component;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import view.Start;

public class Main {

	static controller.MainController mainController;

	public static void main(String[] args) throws FileNotFoundException {

		Start sp = new Start();
		
		sp.addOkListener((e) -> {
			if (sp.getPW().equals("1337")) {
				try {
					sp.setVS(false);
					mainController = new controller.MainController();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				Component infoFrame = null;
				JOptionPane.showMessageDialog(infoFrame, "Passwort nicht richtig", "Warnung", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
		

	}
}
