package gui;

import java.util.ArrayList;
import java.util.Arrays;

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
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("sell");
		inputList.add(sellCoins.getText());
		inputList.add(sellAssistants.getText());
		ArrayList<String> sellPermissionsArray = new ArrayList<String>(Arrays.asList(sellPermissions.getText().split(" ")));
		for (String string : sellPermissionsArray) {
			inputList.add(string);
		}
		ArrayList<String> sellPoliticalsArray = new ArrayList<String>(Arrays.asList(sellPoliticals.getText().split(" ")));
		if (sellPoliticalsArray.size()!=7) {
			return;
		}
		for (String string : sellPoliticalsArray) {
			inputList.add(string);
		}
		
		inputList.add(buyCoins.getText());
		inputList.add(buyAssistants.getText());
		ArrayList<String> buyPermissionsArray = new ArrayList<String>(Arrays.asList(buyPermissions.getText().split(" ")));
		for (String string : buyPermissionsArray) {
			inputList.add(string);
		}
		ArrayList<String> buyPoliticalsArray = new ArrayList<String>(Arrays.asList(buyPoliticals.getText().split(" ")));
		if (buyPoliticalsArray.size()!=7) {
			return;
		}
		for (String string : buyPoliticalsArray) {
			inputList.add(string);
		}
		
		
		MainApp.getOutHandler().activate(inputList);
		mainApp.getTempStage().close();
	}
	@FXML
	private void handleCancel() {
		mainApp.getTempStage().close();
	}

}
