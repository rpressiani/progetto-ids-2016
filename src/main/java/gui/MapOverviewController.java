package gui;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.GameState;
import model.actions.main.BuildEmporiumWithCard;
import model.actions.main.ElectCounsellor;
import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.map.City;
import model.map.Region;
import model.player.Player;
import utilities.Color;

public class MapOverviewController {
	
	@FXML
	private AnchorPane layout; 
	@FXML
	private MenuButton mainActions; 
	@FXML
	private MenuItem buildAction; 
	@FXML
	private MenuItem buy; 
	@FXML
	private MenuItem buildWithKing; 
	@FXML
	private MenuItem elect; 
	@FXML
	private MenuButton quickActions; 
	@FXML
	private MenuItem addictional; 
	@FXML
	private MenuItem substitute; 
	@FXML
	private MenuItem elect2; 
	@FXML 
	private MenuItem hire; 
	@FXML
	private MenuItem nullAction; 
	//if we want to load regions from configuration file
	@FXML
	private ImageView region1; 
	@FXML
	private ImageView region2; 
	@FXML
	private ImageView region3; 
	@FXML
	private ArrayList<Button> cities; 
	
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
		//initialize cities?
		buildAction.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {		
			@Override
			public void handle(MouseEvent event) {
				City city = mainApp.getGameState().getMap().getAllCitiesHashMap().get("A"); 
				PermissionCard card = 
						mainApp.getGameState().getMap().getRegions().get("seaside").getPermissionDeck().getDeck().get(0);
				//TODO: choose clicked city
				BuildEmporiumWithCard action = new BuildEmporiumWithCard(card, city); 
				action.doAction(mainApp.getGameState().getCurrentPlayer(), mainApp.getGameState());
				doneMain = true; 
				//TODO: implement end of turn
			}
			
		});
		buy.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
			}
			
		});
		buildWithKing.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		elect.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Region region = mainApp.getGameState().getMap().getRegions().get("seaside");
				Color color = new Color("red"); 
				ElectCounsellor action = new ElectCounsellor(region, color);
				action.doAction(mainApp.getGameState().getCurrentPlayer(), mainApp.getGameState());
				doneMain = true; 
				
			}
			
		});
		addictional.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		substitute.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		elect2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		hire.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	@FXML
	public void handleBuildEmporium(MouseEvent mouseEvent) {
		if(!mainApp.getGameState().getCurrentPlayer().isEnabled()) {
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setTitle("Error");
			alert.setHeaderText("You'd better change your mind");
			alert.setContentText("Can't do this action now");
		}
	}
	@FXML
	public void handleElectCounsellor(MouseEvent mouseEvent) {
		if(!mainApp.getGameState().getCurrentPlayer().isEnabled()) {
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setTitle("Error");
			alert.setHeaderText("You'd better change your mind");
			alert.setContentText("Can't do this action now");
		}
	}
	@FXML
	public void handleBuildWithKing() {
		if(!mainApp.getGameState().getCurrentPlayer().isEnabled()) {
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setTitle("Error");
			alert.setHeaderText("You'd better change your mind");
			alert.setContentText("Can't do this action now");
		}
	}
	@FXML
	public void handleSubstitute() {
		if(!mainApp.getGameState().getCurrentPlayer().isEnabled()) {
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setTitle("Error");
			alert.setHeaderText("You'd better change your mind");
			alert.setContentText("Can't do this action now");
		}
	}
	@FXML
	public void handleElectWithAssistant() {
		if(!mainApp.getGameState().getCurrentPlayer().isEnabled()) {
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setTitle("Error");
			alert.setHeaderText("You'd better change your mind");
			alert.setContentText("Can't do this action now");
		}
	}
	@FXML
	public void handleNullAction() {
		
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
}
