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
	private TextArea nicknameArea = new TextArea(); 
	@FXML
	private TextArea colorArea = new TextArea(); 
	@FXML
	private Button ok = new Button(); 
	@FXML
	private Button decline = new Button(); 
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
//    		Player player = new Player(); 
//    		player.setNickname(nicknameArea.getText());
//    		player.setColor(new Color(colorArea.getText()));
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
}
