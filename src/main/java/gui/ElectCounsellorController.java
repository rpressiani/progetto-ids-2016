package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ElectCounsellorController {

	private MainApp mainApp; 
	
	@FXML
	private TextArea region = new TextArea(); 
	@FXML
	private TextArea color = new TextArea(); 
	@FXML
	private Button ok = new Button(); 
	@FXML
	private Button cancel = new Button(); 
	
	@FXML
	private void intialize(){
		
	}
	
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
