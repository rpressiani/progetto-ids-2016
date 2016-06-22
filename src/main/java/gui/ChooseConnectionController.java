package gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.player.Player;

public class ChooseConnectionController {
	
	private Stage dialogStage;
    private boolean okClicked = false;
    private Player player; 
    
	@FXML
	private TextArea connectionArea;
	@FXML
	private TextArea portArea; 
	
	private MainApp mainApp; 
	
	@FXML
	private void initialize() {
		
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage; 
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp; 
	}
	public boolean isPortOk() {
		if(portArea.getText()==null) {
			return false; 
		} //TODO: fix this
		return true; 
		
	}
	@FXML
	private void handleCancel() {
		
	}
	@FXML 
	private void handleOk() {
		
		//TODO: switch to gameScene --> mapOverview
		okClicked = true; 
	}
	

}
