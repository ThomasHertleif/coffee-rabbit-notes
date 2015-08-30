import model.NoteStore;

public class Main {

	static view.MainView mainView;
	static controller.MainController mainController;
	static model.NoteStore noteStore;

	public static void main(String[] args) {
		
		noteStore = new NoteStore();
		mainView = new view.MainView();
		mainController = new controller.MainController(mainView, noteStore);

	}
}
