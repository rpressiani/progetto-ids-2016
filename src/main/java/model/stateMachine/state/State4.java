package model.stateMachine.state;

import model.GameState;
import model.actions.market.SellAction;
import model.player.Player;

public class State4 implements State {
	
	@Override
	public void transition(Player player, SellAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		if(action.acceptMove(player, gameState)==true){
			//action.doAction(player, gameState);
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
		if(player==null || state==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		System.out.println(player.getNickname()+": "+"State4");
	}
	
}
