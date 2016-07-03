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
		mainApp.showAddActionBuildWithCard();
		mainApp.getTempStage().close();
	}
	@FXML
	private void handleBuildWithKing() {
		mainApp.showAddActionBuildWithKing();
		mainApp.getTempStage().close();
	}
	@FXML
	private void handleElectCounsellor() {
		mainApp.showAddActionElectCounsellor();
		mainApp.getTempStage().close();
	}
	@FXML
	private void handleBuyPermissionCard() {
		mainApp.showAddActionBuyPermissionCard();
		mainApp.getTempStage().close();
	}
}
