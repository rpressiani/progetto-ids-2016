package gui;

import javafx.fxml.FXML;

public class MainController {
	
	@FXML
	private ChooseConnectionController controller; 
	@FXML
	private LoginClientController controller2; 
	@FXML
	public void initialize() {
		System.out.println("Application started");
		controller.init(this);
		controller2.init(this);
	}

}
