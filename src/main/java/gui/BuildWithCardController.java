package gui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BuildWithCardController {
	
	private String state = new String();
	
	private boolean error = false;

	@FXML
	private TextArea card = new TextArea(); 
	@FXML
	private TextArea city = new TextArea();
	@FXML
	private Button ok = new Button(); 
	@FXML
	private Button cancel = new Button(); 
	
	private MainApp mainApp; 
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp; 
	}
	@FXML
	private void handleOk() {
		ArrayList<String> inputList = new ArrayList<String>();
		if (state.equals("addaction")) {
			inputList.add("addaction");
		}
		if (state.equals("bonus")) {
			inputList.add("bonusdoactionagain");
		}
		inputList.add("buildempcard");
		inputList.add(card.getText());
		inputList.add(city.getText());
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
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
}
