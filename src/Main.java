import view.*;


public class Main {

	static view.MainView mainView;
	static controller.MainController mainController;
	
	public static void main(String[] args) {
		
		mainView = new view.MainView();
		mainController = new controller.MainController(mainView);

	}

}
