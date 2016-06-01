package model.stateMachine.state;

import model.GameState;
import model.actions.NullAction;
import model.actions.quick.QuickAction;
import model.player.Player;

public class CanQuickOrNullState implements State {
	
	@Override
	public void transition(Player player, QuickAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(action.acceptMove(player, gameState)==true){
			if(action.checkCondition(player, gameState)==true){
				action.doAction(player, gameState);
				System.out.println(player.getNickname()+" did a QuickAction");
				player.setState(new CanSellState());
				player.getState().checkTurn(player, gameState);
			}
		}
		
	}
	
	@Override
	public void transition(Player player, NullAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(action.acceptMove(player, gameState)==true){
			if(action.checkCondition(player, gameState)==true){
				action.doAction(player, gameState);
				System.out.println(player.getNickname()+" did a NullAction");
				player.setState(new CanSellState());
				player.getState().checkTurn(player, gameState);
			}
		}
		
	}
	
	@Override
	public void printOut(Player player, State state) {
		if(player==null || state==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		System.out.println(player.getNickname()+": "+"State2");
	}
}
