package model.actions;

import model.GameState;
import model.player.Player;

public class NullAction implements GeneralAction {
	
	/**
	 * create the null action
	 */
	public NullAction(){
		
	}
	
	@Override
	/**
	 * pass the turn
	 */
	public void doAction(Player player, GameState gameState) {
		
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		return true;
	}

}
