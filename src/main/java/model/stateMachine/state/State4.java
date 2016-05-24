package model.stateMachine.state;

import model.GameState;
import model.actions.SellAction;
import model.player.Player;

public class State4 implements State {
	
	public void transition(Player player, SellAction action, GameState gameState){
		
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" decided what to sell");
			player.setState(new State5());
			player.getState().checkTurn(player, gameState);
		}
		
	}
	
	@Override
	public void checkTurn(Player player, GameState gameState){
		gameState.nextPlayer(player);
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State4");
	}
	
}
