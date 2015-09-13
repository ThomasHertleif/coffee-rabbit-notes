package controller;

import model.PWHandler;
import view.Start;

public class StartController {

	static controller.MainController mainController;
	private Start start;
	private PWHandler pwHandler;

	public StartController() {
		start = new Start();
		pwHandler = new PWHandler();

		if (this.pwHandler.checkCFG() == false) {
			this.start.setPWInfo("Bitte ein neues Passwort eingeben.");

			this.start.setOkListener((e) -> {
				try {
					this.pwHandler.createCFG(this.start.getPW());
					this.start.hide();
					mainController = new controller.MainController();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		} else
			this.start.setOkListener((e) -> {
				try {
					if (this.pwHandler.getCFGpw().equals(this.start.getPW())) {
						this.start.hide();
						mainController = new controller.MainController();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	}
}
