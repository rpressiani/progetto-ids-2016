package actions;

import gameState.GameState;
import player.Player;

public abstract class QuickAction implements GeneralAction {

	public QuickAction(){
		
	}
	
	public QuickAction(MainAction action) {
		// TODO Auto-generated constructor stub
	}

	public void doAction(Player player, GameState gameState) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean acceptMove(Player player, GameState gameState){
		if(gameState.getCurrentPlayer()!=player){
			System.out.println("It's not your turn "+player.getNickname());
			return false;
		}
		
		else{
			System.out.println(player.getNickname()+" did a QuickAction");
			//doAction(player, gameState);
			return true;
		}
	}

}
