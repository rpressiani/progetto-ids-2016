package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddictionalActionController {
	
	private MainApp mainApp; 
	@FXML
	private Button buildWithCard = new Button(); 
	@FXML
	private Button buildWithKing = new Button(); 
	@FXML
	private Button electCounsellor = new Button(); 
	@FXML
	private Button buyPermissionCard = new Button(); 
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp; 
	}
	
	@FXML
	private void handleBuildWithCard() {
		mainApp.getTempStage().close();
		mainApp.showAddActionBuildWithCard();
		
	}
	@FXML
	private void handleBuildWithKing() {
		mainApp.getTempStage().close();
		mainApp.showAddActionBuildWithKing();
		
	}
	@FXML
	private void handleElectCounsellor() {
		mainApp.getTempStage().close();
		mainApp.showAddActionElectCounsellor();
	}
	@FXML
	private void handleBuyPermissionCard() {
		mainApp.getTempStage().close();
		mainApp.showAddActionBuyPermissionCard();
	}
}
