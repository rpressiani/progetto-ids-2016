package model.actions;

import model.GameState;
import model.player.Player;

public class AddictionalAction extends QuickAction {
	
	MainAction action;
	
	public AddictionalAction(MainAction action){
		this.action=action;
	}
	
	public void doAction(Player player, GameState gameState){
		if(player.getAssistants().getItems()>=3){
			player.getAssistants().sub(3);
			action.doAction(player, gameState);
		}
	}
}
