package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

import view.*;


public class MainController {
	
	private MainView mainView;
	
	public MainController(MainView MainView) {
		this.mainView = MainView;
	
		this.mainView.setNewNoteListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("New Note will be made");
				
				mainView.setscrollPaneContent(new view.NewNotePanel());
				
			}
		});
	}
	
	
	
}
