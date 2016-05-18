package actions;

import gameState.GameState;
import player.Player;

public class NullAction implements GeneralAction {
	
	public boolean acceptMove(Player player, GameState gameState){
		if(gameState.getCurrentPlayer()!=player) return false;
		else return true;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
	}

}
