package gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
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
	private MainController main; 
	private MainApp mainApp; 
	
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
    		try {
    			FXMLLoader loader = new FXMLLoader(); 
        		loader.setLocation(getClass().getResource("/ConnectionChoice.fxml"));
				AnchorPane connectionChoice = (AnchorPane) loader.load();
				Scene scene = new Scene(connectionChoice); 
				mainApp.getRootLayout().setCenter(connectionChoice);
				mainApp.getPrimaryStage().setScene(scene);
				mainApp.getPrimaryStage().show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    		//TODO: switch to next scene --> connection choice
    	}
    }
    @FXML
    private void handleCancel() {
    	dialogStage.close(); 
    }
    public void init(MainController mainController) {
		main = mainController;
	}
    
}
