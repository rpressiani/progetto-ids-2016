package gui;

import java.io.IOException;

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
	
	public MainApp() {
		
	}
	
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
	public void showConnectionChoice() {
		try {
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(getClass().getResource("/ChooseConnection.fxml"));
			AnchorPane connectionChoice = (AnchorPane) loader.load();
			rootLayout.setCenter(connectionChoice);
			ChooseConnectionController controller = loader.getController(); 
			controller.setMainApp(this);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void showGameScene() {
		try {
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(MainApp.class.getResource("/GameScene.fxml"));
			//which gameState?
			AnchorPane gameScene = (AnchorPane) loader.load(); 
			rootLayout.setCenter(gameScene);
			MapOverviewController controller = loader.getController(); 
			controller.setMainApp(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public GameState getGameState() {
		return gameState; 
	}
}
