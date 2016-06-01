package model.stateMachine.state;

import model.GameState;
import model.actions.market.BuyAction;
import model.player.Player;

public class CanBuyState implements State {
	
	public void transition(Player player, BuyAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(action.acceptMove(player, gameState)==true){
			if(action.checkCondition(player, gameState)==true){
				action.doAction(player, gameState);
				System.out.println(player.getNickname()+" decided what to buy");
				player.setState(new StartState());
				player.getState().checkTurn(player, gameState);
			}
		}
		
		else player.setState(this);
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State5");
	}
	
	@Override
	public void checkTurn(Player player, GameState gameState){
		gameState.nextPlayer(player);
	}
}
