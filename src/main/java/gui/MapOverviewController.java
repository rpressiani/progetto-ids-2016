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
	private MenuItem elect2 = new MenuItem(); 
	@FXML 
	private MenuItem hire = new MenuItem(); 
	@FXML
	private MenuItem nullAction = new MenuItem(); 
	//if we want to load regions from configuration file
	@FXML
	private ImageView region1; 
	@FXML
	private ImageView region2; 
	@FXML
	private ImageView region3; 
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
		
	}
	@FXML
	public void handleElectCounsellor(MouseEvent mouseEvent) {
		if(!mainApp.getGameState().getCurrentPlayer().isEnabled()) {
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setTitle("Error");
			alert.setHeaderText("You'd better change your mind");
			alert.setContentText("Can't do this action now");
			alert.showAndWait(); 
		}
	}
	@FXML
	public void handleBuildWithKing() {
		if(!mainApp.getGameState().getCurrentPlayer().isEnabled()) {
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setTitle("Error");
			alert.setHeaderText("You'd better change your mind");
			alert.setContentText("Can't do this action now");
			alert.showAndWait(); 
		}
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
