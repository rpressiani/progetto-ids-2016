package gui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BuyPermissionCardController {
	
	private MainApp mainApp; 
	
	private String state = new String();
	
	private boolean error = false;
	
	@FXML
	private TextArea region = new TextArea(); 
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
	private TextArea index = new TextArea(); 
	@FXML
	private Button ok = new Button(); 
	@FXML
	private Button cancel = new Button(); 
		
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
		inputList.add("buypermissioncard");
		inputList.add(region.getText());
		inputList.add(index.getText());
		inputList.add(blackCards.getText());
		inputList.add(orangeCards.getText());
		inputList.add(blueCards.getText());
		inputList.add(pinkCards.getText());
		inputList.add(whiteCards.getText());
		inputList.add(purpleCards.getText());
		inputList.add(jolly.getText());
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
