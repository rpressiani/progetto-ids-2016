package model.actions;

import model.GameState;
import model.player.Player;

public interface GeneralAction {
	
	public void doAction(Player player, GameState gameState);
	
	public default boolean acceptMove(Player player, GameState gameState){
		if(gameState.getCurrentPlayer()!=player){
			System.out.println("It's not your turn "+player.getNickname());
			return false;
		}
		
		else{
			//doAction(player, gameState);
			return true;
		}
	}
}
