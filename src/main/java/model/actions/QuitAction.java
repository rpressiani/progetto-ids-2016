package model.actions;

import model.GameState;
import model.player.Player;

public class QuitAction implements GeneralAction {

	@Override
	public void doAction(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null");
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		
		player.getView().disconnect();
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
