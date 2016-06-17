package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage; 
	private GridPane rootLayout; 
	
	public MainApp() {
		
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage; 
		this.primaryStage.setTitle("Council of Four");
		initRootLayout(); 
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	private void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("gui/RootLayout.fxml"));
			rootLayout = (GridPane) loader.load();
			Scene scene = new Scene(rootLayout); 
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
