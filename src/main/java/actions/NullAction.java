package actions;

import gameState.GameState;
import player.Player;

public class NullAction implements GeneralAction {
	
	@Override
	public void doAction(Player player, GameState gameState) {
	
	}
	
	public boolean acceptMove(Player player, GameState gameState){
		if(gameState.getCurrentPlayer()!=player){
			System.out.println("It's not your turn "+player.getNickname());
			return false;
		}
		
		else{
			System.out.println(player.getNickname()+" passed the turn");
			//doAction(player, gameState);
			return true;
		}
	}

}
