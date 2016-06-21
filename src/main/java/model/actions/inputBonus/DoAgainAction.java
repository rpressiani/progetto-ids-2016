package model.actions.inputBonus;

import model.GameState;
import model.actions.main.MainAction;
import model.bonusItem.BonusAddictionalAction;
import model.changes.ChangeMsg;
import model.player.Player;

public class DoAgainAction implements InputBonusAction {

	MainAction action;
	
	/**
	 * @param action
	 * @throws NullPointerException if action is null
	 */
	public DoAgainAction(MainAction action) {
		if(action==null) {
			throw new NullPointerException("a main action cannot be null"); 
		}
		
		this.action=action;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {

		if(player==null || gameState==null) {
			throw new NullPointerException("player and gameState cannot be null"); 
		}

			action.doAction(player, gameState);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(!(player.getBonusInputs().get(0) instanceof BonusAddictionalAction)){
			gameState.notifyObserver(player, new ChangeMsg("It's no time to do a bonus action"));
			return false;
		}
		
		if(action.checkCondition(player, gameState)==false) return false;
		
		return true;
	}

}
