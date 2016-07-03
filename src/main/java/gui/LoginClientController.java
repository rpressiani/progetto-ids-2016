package gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class LoginClientController {

	@FXML
	private TextArea nicknameArea; 
	@FXML
	private TextArea colorArea; 
	@FXML
	private Button ok; 
	@FXML
	private Button decline; 
	private Stage dialogStage; 
	//private Player player; //?
	private boolean okClicked = false; 
	private MainApp mainApp; 
	
	/**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
	public LoginClientController() {
		
	}
	/**
	 * @return the dialogStage
	 */
	public Stage getDialogStage() {
		return dialogStage;
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp; 
	}
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
    		ArrayList<String> inputList = new ArrayList<String>();
    		inputList.add("setup");
    		inputList.add(nicknameArea.getText());
    		inputList.add(colorArea.getText());
    		MainApp.getOutHandler().activate(inputList);
    		
    		okClicked = true; 
    		
    		mainApp.showGameScene();
    	}
    }
    @FXML
    private void handleCancel() {
    	decline.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainApp.getPrimaryStage().close();				
			}
    		
    	});
    }
    public String getNickname() {
    	return nicknameArea.getText(); 
    }
    
    public void alert(String msg){
    	System.out.println("alert1");
    	Alert alert = new Alert(AlertType.ERROR);
    	System.out.println("alert2");
        alert.initOwner(dialogStage);
        System.out.println("alert3");
        alert.setTitle("Invalid Fields");
        System.out.println("alert4");
        alert.setHeaderText("Please correct invalid fields");
        System.out.println("alert5");
        alert.setContentText(msg);
        System.out.println("alert6");

        alert.showAndWait();
	}
}
