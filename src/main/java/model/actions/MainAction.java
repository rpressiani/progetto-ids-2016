package model.actions;

import model.GameState;
import model.player.Player;

public abstract class MainAction implements GeneralAction{
	
	public MainAction(){
		
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
			System.out.println(player.getNickname()+" did a MainAction");
			//doAction(player, gameState);
			return true;
		}
	}
	
}
