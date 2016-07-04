package gui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ElectWithAssistantController {
	
	private boolean error = false;
	
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
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("electcounsellorassistant");
		inputList.add(balcony.getText());
		inputList.add(color.getText());
		for (String string : inputList) {
			if (string.equals("")) {
				mainApp.getTempStage().close();
				this.error = true;
				break;
			}
		}
		if (this.error == false) {
			MainApp.getOutHandler().activate(inputList);
		}		mainApp.getTempStage().close();
	}
	@FXML
	private void handleCancel() {
		mainApp.getTempStage().close();
	}
	


}
