package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SellActionController {
	
	private MainApp mainApp; 
	
	@FXML
	private Button ok; 
	@FXML
	private Button cancel; 
	@FXML
	private TextArea sellCoins; 
	@FXML
	private TextArea sellAssistants; 
	@FXML
	private TextArea sellPermissions; 
	@FXML
	private TextArea sellPoliticals; 
	@FXML
	private TextArea buyCoins; 
	@FXML
	private TextArea buyAssistants; 
	@FXML
	private TextArea buyPermissions; 
	@FXML
	private TextArea buyPoliticals; 
	
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
