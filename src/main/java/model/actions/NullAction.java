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
		if(player==null) {
			throw new NullPointerException("player cannot be null");
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null");
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		return true;
	}

}
