package actions;

import gameState.GameState;
import player.Player;

public abstract class MainAction implements GeneralAction{
	
	public MainAction(){
		
	}
	
	public boolean acceptMove(Player player, GameState gameState){
		if(gameState.getCurrentPlayer()!=player) return false;
		else return true;
	}
	
	public void doAction(Player player, GameState gameState) {
		// TODO Auto-generated method stub
		
	}
	
}
