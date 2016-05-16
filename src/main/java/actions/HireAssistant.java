package actions;

import gameState.GameState;
import player.Player;

public class HireAssistant extends QuickAction {
	
	public HireAssistant(){
		
	}
	
	public void doAction(Player player, GameState gameState){
		if(player.getCoins().getItems()>=3){
			player.getAssistants().add(1);
			player.getCoins().sub(3);
		}
	}
}
