package model.actions.quick;

import model.GameState;
import model.actions.QuickAction;
import model.player.Player;

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
