package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BuyActionController {
	
	private MainApp mainApp; 
	
	@FXML
	private Button ok = new Button(); 
	@FXML
	private Button cancel = new Button();
	@FXML
	private TextArea contractNumber = new TextArea(); 
	
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
