package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage; 
	private BorderPane rootLayout; 
	
	public MainApp() {
		
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage; 
			this.primaryStage.setTitle("Council of Four");
			
			initRootLayout(); 
			
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
			loader.setLocation(MainApp.class.getResource("/progetto-ids2016/src/main/resources/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout); 
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void showLoginClient() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/progetto-ids2016/src/main/resources/LoginClient.fxml"));
			AnchorPane loginClient = (AnchorPane) loader.load();
			rootLayout.setCenter(loginClient);
			MainController controller = new MainController();
			controller.initialize();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showMapOverview() {
		try {
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(MainApp.class.getResource("gui/MapOverview.fxml"));
			AnchorPane mapOverview = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
