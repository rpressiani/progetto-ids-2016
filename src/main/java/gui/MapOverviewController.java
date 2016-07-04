package gui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class MapOverviewController {
	
	@FXML
	private AnchorPane layout; 
	@FXML
	private MenuButton mainActions = new MenuButton(); 
	@FXML
	private MenuItem buildAction = new MenuItem(); 
	@FXML
	private MenuItem buy = new MenuItem(); 
	@FXML
	private MenuItem buildWithKing = new MenuItem(); 
	@FXML
	private MenuItem elect = new MenuItem(); 
	@FXML
	private MenuButton quickActions = new MenuButton(); 
	@FXML
	private MenuItem addictional = new MenuItem(); 
	@FXML
	private MenuItem substitute = new MenuItem(); 
	@FXML
	private MenuItem electWithAssistant = new MenuItem(); 
	@FXML 
	private MenuItem hire = new MenuItem(); 
	@FXML
	private MenuItem nullAction = new MenuItem(); 
	@FXML
	private MenuItem doAgain = new MenuItem();
	@FXML
	private MenuItem getAgainBonus = new MenuItem(); 
	@FXML
	private MenuItem getFreePermission = new MenuItem();
	@FXML
	private MenuItem getFreeToken = new MenuItem(); 
	@FXML
	private MenuItem buyAction = new MenuItem(); 
	@FXML
	private MenuItem sellAction = new MenuItem(); 
	@FXML 
	private MenuItem scoresQuery = new MenuItem(); 
	@FXML 
	private MenuItem currentPlayerQuery = new MenuItem(); 
	@FXML
	private MenuItem infoQuery = new MenuItem(); 
	@FXML
	private MenuItem playerInfoQuery = new MenuItem();
	@FXML
	private MenuItem otherPlayersQuery = new MenuItem(); 
	@FXML
	private MenuItem freeCounsellorsQuery = new MenuItem(); 
	@FXML
	private MenuItem balconiesQuery = new MenuItem(); 
	@FXML
	private MenuItem availablePermissionsQuery = new MenuItem(); 
	@FXML
	private MenuItem mapQuery = new MenuItem(); 
	@FXML
	private MenuItem marketQuery = new MenuItem(); 
	
	@FXML
	private Button send = new Button();
	@FXML
	private TextArea chat = new TextArea();
	@FXML 
	private TextArea textArea = new TextArea(); 

	private MainApp mainApp;  
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp; 
	}
	
	@FXML
	private void initialize() {
		
		this.textArea.setWrapText(true);
		this.textArea.setEditable(false);
		this.textArea.setText("Welcome to Co4! Wait for a match to start...\n");
		textArea.setScrollTop(Double.MAX_VALUE);
		
		this.chat.setWrapText(true);
		this.chat.setEditable(true);
		
	}
	@FXML
	public void handleChatSend(){
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("chat");
		inputList.add(chat.getText());
		this.chat.clear();
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleBuildEmporium() {
		mainApp.showBuildWithCard();
	}
	@FXML
	public void handleElectCounsellor() {
		mainApp.showElectCounsellor();
	}
	@FXML
	public void handleBuyPermissionCard() {
		mainApp.showBuyPermissionCard();
	}
	@FXML
	public void handleBuildWithKing() {
		mainApp.showBuildWithKing();
	}
	@FXML
	public void handleAddictionalAction() {
		mainApp.showAddAction();
	}
	@FXML
	public void handleSubstitute() {
		mainApp.showSubstitute();
	}
	@FXML
	private void handleBuyAction() {
		mainApp.showBuyAction();
	}
	@FXML
	private void handleSellAction() {
		mainApp.showSellAction();
	}
	@FXML
	public void handleElectWithAssistant() {
		mainApp.showElectCounsellorWithAssistant();
	}
	@FXML
	public void handleHireAssistant(){
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("hireAssistant");
		MainApp.getOutHandler().activate(inputList);
	}
	
	@FXML
	public void handleNullAction() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("pass");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleQuit(){
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("quit");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	private void handleDoAgain() {
		mainApp.showDoActionAgain();
	}
	@FXML
	private void handleGetAgainBonus() {
		mainApp.showGetAgainBonus();
	}
	@FXML
	private void handleGetFreePermission() {
		mainApp.showGetFreePermission();
	}
	@FXML
	private void handleGetFreeToken() {
		mainApp.showGetFreeToken();
	}
	@FXML
	public void handleScoresQuery() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("getscores");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleCurrentPlayerQuery() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("getcurrentplayer");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleInformationQuery() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("getinfo");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handlePlayerInformation() {
//		ArrayList<String> inputList = new ArrayList<String>();
//		inputList.add("getplayerinfo");
//		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleOtherPlayersQuery() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("getplayers");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleFreeCounsellorsQuery() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("getfreecounsellors");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleBalconiesQuery() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("getbalconies");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleAvailablePermissionsQuery() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("getpermissionavailable");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleMapQuery() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("getmap");
		MainApp.getOutHandler().activate(inputList);
	}
	@FXML
	public void handleMarketQuery() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add("getmarket");
		MainApp.getOutHandler().activate(inputList);
	}
//	public void endTurn() {
//		if(doneMain && doneQuick) {
//			isTurnOver = true; 
//		}
//	}
//	public boolean getDoneMain() {
//		return doneMain; 
//	}
//	public boolean getDoneQuick() {
//		return doneQuick; 
//	}
//	public void waitForActionClick(Player player, MenuItem actionToDo) {
//		final EventHandler<MouseEvent> mouseEventHandler =
//		        new EventHandler<MouseEvent>() {
//		            public void handle(final MouseEvent mouseEvent) {
//		                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
//		                    mouseEvent.consume();
//		                }
//		            }
//		        };
//	}
	
	 public void alert(String msg){
		 textArea.appendText(msg);
		 textArea.setScrollTop(Double.MAX_VALUE);
		}
}
