package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DoAgainActionController {
	
	private MainApp mainApp; 
	
	@FXML
	private Button buildWithCard = new Button(); 
	@FXML
	private Button buildWithKing = new Button(); 
	@FXML
	private Button electCounsellor = new Button(); 
	@FXML
	private Button buyPermissionCard = new Button(); 
	
	@FXML
	private void handleBuildWithCard() {
		mainApp.getTempStage().close();
		mainApp.showBonusBuildWithCard();
	}
	@FXML
	private void handleBuildWithKing() {
		mainApp.getTempStage().close();
		mainApp.showBonusBuildWithKing();
	}
	@FXML
	private void handleElectCounsellor() {
		mainApp.getTempStage().close();
		mainApp.showBonusElectCounsellor();
	}
	@FXML
	private void handleBuyPermissionCard() {
		mainApp.getTempStage().close();
		mainApp.showBonusBuyPermissionCard();
	}
	/**
	 * @param mainApp the mainApp to set
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
