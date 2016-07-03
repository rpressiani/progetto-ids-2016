package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BuildWithKingController {
	
	private MainApp mainApp; 
	
	@FXML
	private Button ok = new Button(); 
	@FXML
	private Button cancel = new Button(); 
	@FXML
	private TextArea blackCards = new TextArea(); 
	@FXML
	private TextArea orangeCards = new TextArea(); 
	@FXML
	private TextArea blueCards = new TextArea(); 
	@FXML
	private TextArea pinkCards = new TextArea(); 
	@FXML
	private TextArea whiteCards = new TextArea(); 
	@FXML
	private TextArea purpleCards = new TextArea(); 
	@FXML
	private TextArea jolly = new TextArea(); 
	@FXML
	private TextArea city = new TextArea(); 
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp; 
	}
	@FXML
	private void handleOk() {
		
	}
	@FXML
	private void handleCancel() {
		
	}
	

}
