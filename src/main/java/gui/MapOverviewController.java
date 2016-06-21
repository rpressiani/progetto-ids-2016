package gui;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.GameState;
import model.player.Player;

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
	
	private boolean doneMain = false; 
	private boolean doneQuick = false; 
	private boolean isTurnOver = false; 
	//private ArrayList<MenuItem> mainActionsList; 
	
	@FXML
	private void initialize() {
		buildAction.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		buy.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
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
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	public void handleMainAction() {
		
	}
	public void handleQuickAction() {
		
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
}
