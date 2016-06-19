package model.actions.quick;

import model.GameState;
import model.actions.main.MainAction;
import model.changes.ChangeMsg;
import model.player.Player;

public class AddictionalAction implements QuickAction {
	
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
	
	@Override
	public void doAction(Player player, GameState gameState) {
		System.out.println("entrato nell'azione");
		
		if(player==null || gameState==null) {
			throw new NullPointerException("player and gameState cannot be null"); 
		}
			action.doAction(player, gameState);
			player.getAssistants().sub(3);
			System.out.println("uscito dall'azione");
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(player.getAssistants().getItems()<3) {
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to do an addictionalAction"));
			return false;
		}
		
		return true;
	}
}
