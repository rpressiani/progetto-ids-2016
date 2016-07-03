package gui;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import model.GameState;
import model.actions.main.BuildEmporiumWithCard;
import model.actions.main.ElectCounsellor;
import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.council.Balcony;
import model.map.City;
import model.map.Region;
import model.player.Player;

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
	//if we want to load regions from configuration file
	@FXML
	private ImageView region1 = new ImageView(); 
	@FXML
	private ImageView region2 = new ImageView(); 
	@FXML
	private ImageView region3 = new ImageView(); 
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
	private ArrayList<Button> cities;
	@FXML private TextArea textArea = new TextArea();

	
	private ArrayList<ImageView> council1 = new ArrayList<ImageView>(); 
	private ArrayList<ImageView> council2 = new ArrayList<ImageView>(); 
	private ArrayList<ImageView> council3 = new ArrayList<ImageView>(); 
	private ArrayList<ImageView> kingCouncil = new ArrayList<ImageView>(); 

	private MainApp mainApp; 
	private boolean doneMain = false; 
	private boolean doneQuick = false; 
	private boolean isTurnOver = false; 
	//private ArrayList<MenuItem> mainActionsList; 
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp; 
	}
	
	@FXML
	private void initialize() {
		
//		 dataPane.setEditable(false);
//        dataPane.prefWidthProperty().bind(hbox.widthProperty());
//
//        dataPane.setWrapText(true);     // New line of the text exceeds the text area
//        dataPane.setPrefRowCount(10);
//        dataPane.setText("Testdata");
//        dataPane.appendText("\ndata");
		
		this.textArea.setWrapText(true);
		this.textArea.setEditable(false);
		this.textArea.setText("TextArea TEST\n");
		
	}
	@FXML
	public void handleBuildEmporium(MouseEvent mouseEvent) {
		GameState gameState = mainApp.getGameState();
		Player player = gameState.getCurrentPlayer(); 
		PermissionCard card = gameState.getMap().getRegions().get("seaside").getPermissionDeck().getVisibleCards().get(0);
		City city = gameState.getMap().getAllCitiesHashMap().get("A"); 
		BuildEmporiumWithCard action = new BuildEmporiumWithCard(card, city);
		action.doAction(player, gameState);
		//TODO: GUI correspondence
	}
	@FXML
	public void handleElectCounsellor(MouseEvent mouseEvent) {
		GameState gameState = mainApp.getGameState();
		Player player = gameState.getCurrentPlayer(); 
		Balcony balcony = 
				gameState.getMap().getRegions().get("seaside").getBalcony(); 

//		Color color = new Color("red"); 
//		ElectCounsellor action = new ElectCounsellor(balcony, color);
//		action.doAction(player, gameState);
		//TODO: GUI corrspondence

	}
	@FXML
	public void handleBuyPermissionCard() {
		GameState gameState = mainApp.getGameState(); 
		Player player = gameState.getCurrentPlayer(); 
	}
	@FXML
	public void handleBuildWithKing() {
		
	}
	@FXML
	public void handleSubstitute() {
		if(!mainApp.getGameState().getCurrentPlayer().isEnabled()) {
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setTitle("Error");
			alert.setHeaderText("You'd better change your mind");
			alert.setContentText("Can't do this action now");
			alert.showAndWait(); 
		}
	}
	@FXML
	public void handleElectWithAssistant() {
		if(!mainApp.getGameState().getCurrentPlayer().isEnabled()) {
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setTitle("Error");
			alert.setHeaderText("You'd better change your mind");
			alert.setContentText("Can't do this action now");
			alert.showAndWait();
		}
	}
	@FXML
	public void handleNullAction() {
		
	}
	@FXML
	public void handleScoresQuery() {
		
	}
	@FXML
	public void handleCurrentPlayerQuery() {
		
	}
	@FXML
	public void handleInformationQuery() {
		
	}
	@FXML
	public void handlePlayerInformation() {
		
	}
	@FXML
	public void handleOtherPlayersQuery() {
		
	}
	@FXML
	public void handleFreeCounsellorsQuery() {
		
	}
	@FXML
	public void handlebalconiesQuery() {
		
	}
	@FXML
	public void handleAvailablePermissionsQuery() {
		
	}
	@FXML
	public void handleMapQuery() {
		
	}
	@FXML
	public void handleMarketQuery() {
		
	}
	public void endTurn() {
		if(doneMain && doneQuick) {
			isTurnOver = true; 
		}
	}
	public boolean getDoneMain() {
		return doneMain; 
	}
	public boolean getDoneQuick() {
		return doneQuick; 
	}
	public void waitForActionClick(Player player, MenuItem actionToDo) {
		final EventHandler<MouseEvent> mouseEventHandler =
		        new EventHandler<MouseEvent>() {
		            public void handle(final MouseEvent mouseEvent) {
		                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
		                    mouseEvent.consume();
		                }
		            }
		        };
	}
	
	 public void alert(String msg){
//	    	System.out.println("alert1");
//	    	Alert alert = new Alert(AlertType.INFORMATION);
//	    	System.out.println("alert2");
////	        alert.initOwner(dialogStage);
//	        System.out.println("alert3");
//	        alert.setTitle("Invalid Fields");
//	        System.out.println("alert4");
//	        alert.setHeaderText("Please correct invalid fields");
//	        System.out.println("alert5");
//	        alert.setContentText(msg);
//	        System.out.println("alert6");
//
//	        alert.showAndWait();
		 
		 

		 
		 
		 System.out.println("append1");
		 textArea.appendText(msg);
		 System.out.println("append2");
		 
		}
}
