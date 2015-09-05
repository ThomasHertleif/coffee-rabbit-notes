import model.*;

public class Main {

	static view.MainView mainView;
	static controller.MainController mainController;
	static model.Store<Note> noteStore;

	public static void main(String[] args) {
		
		noteStore = new Store<Note>();
		mainView = new view.MainView();
		mainController = new controller.MainController(mainView, noteStore);

	}
}
