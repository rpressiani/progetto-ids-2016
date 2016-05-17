package actions;

import gameState.GameState;
import player.Player;

public class OneMoreMainAction extends QuickAction {
	
	MainAction action;
	
	public OneMoreMainAction(MainAction action){
		this.action=action;
	}
	
	public void doAction(Player player, GameState gameState){
		if(player.getAssistants().getItems()>=3){
			player.getAssistants().sub(3);
			action.doAction(player, gameState);
		}
	}
}
