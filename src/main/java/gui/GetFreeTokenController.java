package gui;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GetFreeTokenController {
	
	private MainApp mainApp;
	
	private boolean error = false;
	
	@FXML
	private Button ok = new Button(); 
	@FXML
	private Button cancel = new Button(); 
	@FXML
	private TextArea cities = new TextArea(); 
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp; 
	}
	
	@FXML
	private void handleOk() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("bonustoken");
		ArrayList<String> citiesArray = new ArrayList<String>(Arrays.asList(cities.getText().split(" ")));
		for (String string : citiesArray) {
			inputList.add(string);
		}
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
