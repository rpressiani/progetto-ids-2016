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
	
	private static GUIClientOutHandlerSocket outHandler;
	
	private static MapOverviewController controller;
	
	private Stage tempStage;
	private AnchorPane gameScene;

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
	
	/**
	 * initializes root layout
	 */
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
	/**
	 * @return rootLayout
	 */
	public BorderPane getRootLayout() {
		return rootLayout; 
	}
	
	/**
	 * @return primaryStage
	 */
	public Stage getPrimaryStage() {
		return primaryStage; 
	}
	
	/**
	 * shows login 
	 */
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
	/**
	 * shows main game scene
	 */
	public void showGameScene() {
		try {
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(getClass().getResource("/GameScene.fxml"));
			//which gameState?
			this.gameScene = (AnchorPane) loader.load(); 
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
//			this.tempStage = new Stage(); 
////			AnchorPane actionScene = (AnchorPane) loader.load();
//			this.gameScene.getChildren().setAll(FXMLLoader.load(getClass().getResource("/ElectCounsellorScene.fxml")));
//			rootLayout.setCenter(this.gameScene);
//
//			FXMLLoader loader = new FXMLLoader(); 
//			loader.setLocation(getClass().getResource("/ElectCounsellorScene.fxml"));
			Scene gameScene = new Scene((AnchorPane) loader.load());
//			Scene scene = new Scene(this.gameScene); 
//
//			ElectCounsellorController controller = loader.getController();
//		    controller.setMainApp(this);
//
//			this.tempStage.setScene(scene);
//			this.tempStage.show();
//			System.out.println(this.tempStage);
			
			this.tempStage = new Stage();
			this.tempStage.setScene(gameScene);
			ElectCounsellorController controller = loader.getController();
			controller.setMainApp(this);
//			Stage t = new Stage();
//			t.setScene(gameScene);
//			this.tempStage = t;
			this.tempStage.show();
			
			
			

			
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

	/**
	 * @return the tempStage
	 */
	public Stage getTempStage() {
		return tempStage;
	}
}
