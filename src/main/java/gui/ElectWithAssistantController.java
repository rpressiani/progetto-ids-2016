package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ElectWithAssistantController {
	
	@FXML
	private Button ok = new Button(); 
	@FXML
	private Button cancel = new Button(); 
	@FXML
	private TextArea balcony = new TextArea(); 
	@FXML
	private TextArea color = new TextArea(); 
	
	private MainApp mainApp; 
	
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
