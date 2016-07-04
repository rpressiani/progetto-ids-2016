package gui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ElectCounsellorController {

	private MainApp mainApp;
	
	private String state;
	
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
		ArrayList<String> inputList = new ArrayList<String>();
		if (state.equals("addaction")) {
			inputList.add("addaction");
		}
		if (state.equals("bonus")) {
			inputList.add("bonusdoactionagain");
		}
		inputList.add("electCounsellor");
		inputList.add(region.getText());
		inputList.add(color.getText());
		MainApp.getOutHandler().activate(inputList);
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
