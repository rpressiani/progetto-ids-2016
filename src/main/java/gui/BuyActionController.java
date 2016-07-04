package gui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BuyActionController {
	
	private MainApp mainApp;
	private boolean error;
	
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
		ArrayList<String> inputList = new ArrayList<String>();
		
		inputList.add("buy");
		inputList.add(contractNumber.getText());
		for (String string : inputList) {
			if (string.equals("")) {
				mainApp.getTempStage().close();
				this.error = true;
				break;
			}
		}
		if (this.error == false) {
			MainApp.getOutHandler().activate(inputList);
		}
		mainApp.getTempStage().close();
	}
	@FXML
	private void handleCancel() {
		mainApp.getTempStage().close();
	}

}
