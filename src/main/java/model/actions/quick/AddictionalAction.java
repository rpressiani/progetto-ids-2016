package model.actions.quick;

import model.GameState;
import model.actions.main.MainAction;
import model.player.Player;

public class AddictionalAction extends QuickAction {
	
	MainAction action;
	
	/**
	 * @param action
	 * @throws NullPointerException if action is null
	 */
	public AddictionalAction(MainAction action) {
		if(action==null) {
			throw new NullPointerException("a main action cannot be null"); 
		}
		this.action=action;
	}
	
	public void doAction(Player player, GameState gameState) {
		if(player==null || gameState==null) {
			throw new NullPointerException("player and gameState cannot be null"); 
		}
		if(player.getAssistants().getItems()>=3){
			player.getAssistants().sub(3);
			action.doAction(player, gameState);
		}
	}
}
