package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.player.Player;
import utilities.Color;

public class LoginClientController {

	@FXML
	private TextArea nicknameArea; 
	@FXML
	private TextArea colorArea; 
	
	private Stage dialogStage; 
	private Player player; //?
	private boolean okClicked = false; 
	
	/**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    public boolean isInputOk() {
    	String errorMessage = "";
    	if(nicknameArea.getText()==null || nicknameArea.getText().length()==0) {
    		errorMessage += "No valid first name!\n"; 
    	} //TODO: color should be read from some file!
    	if(colorArea.getText()==null || colorArea.getText().length()==0) {
    		errorMessage += "No valid color!\n"; 
    	}
    	if(errorMessage.length()==0) {
    		return true; 
    	} else {
    		// Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
    	}
    }
    @FXML
    private void handleOk() {
    	if(isInputOk()) {
    		player.setNickname(nicknameArea.getText());
    		player.setColor(new Color(colorArea.getText()));
    		
    		okClicked = true; 
    		dialogStage.close();
    	}
    }
    
}
