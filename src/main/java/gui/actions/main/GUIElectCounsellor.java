package gui.actions.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gui.MainApp;
import javafx.scene.control.ChoiceDialog;
import model.GameState;
import model.actions.main.ElectCounsellor;
import model.council.Balcony;
import model.player.Player;
import utilities.Color;

public class GUIElectCounsellor {
	
	private MainApp mainApp; 
	
	public GUIElectCounsellor(MainApp mainApp) {
		
		this.mainApp = mainApp; 
		
		List<String> choices = new ArrayList<>();
		choices.add("seaside");
		choices.add("hills");
		choices.add("mountain");
		choices.add("king"); 
		
		
		ChoiceDialog<String> dialog = new ChoiceDialog<>("seaside", choices);
		dialog.setTitle("Elect Counsellor");
		dialog.setContentText("Choose the council you wanna change:");
		Optional<String> result = dialog.showAndWait();
		
		if(result.isPresent()) {
			List<String> availableColors = new ArrayList<>(); 
			availableColors.add("pink"); 
			availableColors.add("black");
			availableColors.add("white");
			availableColors.add("grey"); 
			availableColors.add("orange"); 
			ChoiceDialog<String> dialog2 = new ChoiceDialog<>("black", availableColors);
			Optional<String> choice = dialog2.showAndWait(); 
			if(choice.isPresent()) {
				GameState gameState = mainApp.getGameState();
				Player player = gameState.getCurrentPlayer(); 
				Balcony balcony = gameState.getMap().getRegions().get(result).getBalcony();
				Color color = new Color(choice.get()); 
				ElectCounsellor action = new ElectCounsellor(balcony, color);
				action.doAction(player, gameState);
				dialog2.close();
				dialog.close();
			}
		}
	}
}
