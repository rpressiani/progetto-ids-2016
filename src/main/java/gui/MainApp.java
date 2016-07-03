package gui;

import java.io.IOException;

import client.gui.GUIClientOutHandlerSocket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.GameState;

public class MainApp extends Application {

	private Stage primaryStage; 
	private BorderPane rootLayout; 
	//how 
	private GameState gameState; 
	
	private static GUIClientOutHandlerSocket outHandler;
	
	private static MapOverviewController controller;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage; 
			this.primaryStage.setTitle("Council of Four");
			
			initRootLayout(); 
			
			showLoginClient(); 
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args); 
	}
	
	private void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout); 
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public BorderPane getRootLayout() {
		return rootLayout; 
	}
	
	public Stage getPrimaryStage() {
		return primaryStage; 
	}
	
	public void showLoginClient() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/LoginClient.fxml"));
			StackPane loginClient = (StackPane) loader.load();
			rootLayout.setCenter(loginClient);
			LoginClientController controller = loader.getController(); 
			controller.setMainApp(this); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showGameScene() {
		try {
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(getClass().getResource("/GameScene.fxml"));
			//which gameState?
			AnchorPane gameScene = (AnchorPane) loader.load(); 
			rootLayout.setCenter(gameScene);
			controller = loader.getController(); 
			controller.setMainApp(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void showElectCounsellor() {
		try {
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(getClass().getResource("/ElectCounsellorScene.fxml"));
			Stage stage = new Stage(); 
			AnchorPane actionScene = (AnchorPane) loader.load();
			rootLayout.setCenter(actionScene);
			Scene scene = new Scene(actionScene); 

//			controller = loader.getController(); 
//			controller.setMainApp(this);
			ElectCounsellorController controller = loader.getController();
//			System.out.println("!!!");
//			System.out.println(controller);
		    controller.setMainApp(this);

			primaryStage.setScene(scene);
			primaryStage.show();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	
	public void showBuildWithCard() {
		AnchorPane actionScene;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/BuildEmporiumWithCardScene.fxml"));
			actionScene = (AnchorPane) loader.load();
			rootLayout.setCenter(actionScene);
			BuildWithCardController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * @return gameState
	 */
	public GameState getGameState() {
		return gameState; 
	}
	
	public static void print(String message){
		System.out.println(message);
	}
	
	/**
	 * @return the myOutHandler
	 */
	public static GUIClientOutHandlerSocket getOutHandler() {
		return outHandler;
	}

	/**
	 * @param myOutHandler the myOutHandler to set
	 */
	public static void setOutHandler(GUIClientOutHandlerSocket myOutHandler) {
		MainApp.outHandler = myOutHandler;
	}
	
	public static void alert(String msg){
		if (controller != null) {
			System.out.println(controller);
			controller.alert(msg);
		}
		
	}
}
