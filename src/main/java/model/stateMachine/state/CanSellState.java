package model.stateMachine.state;

import model.GameState;
import model.actions.market.SellAction;
import model.changes.ChangeMsg;
import model.player.Player;

public class CanSellState implements State {
	
	@Override
	public void transition(Player player, SellAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(action.acceptMove(player, gameState)==true){
			if(action.checkCondition(player, gameState)==true){
				action.doAction(player, gameState);
				System.out.println(player.getNickname()+" decided what to sell");
				gameState.notifyObserver(new ChangeMsg(player.getNickname()+" decided what to sell"));
				player.setState(new CanBuyState());
				player.getState().checkTurn(player, gameState);
			}
		}
		
	}
	
	@Override
	public void checkTurn(Player player, GameState gameState){
		if(player==null || gameState==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		
		gameState.nextPlayer(player);
		gameState.notifyObserver(new ChangeMsg("Now it's time for "+gameState.getCurrentPlayer().getNickname()+" to play"));
	}
	
	@Override
	public void printOut(Player player, State state){
		if(player==null || state==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		System.out.println(player.getNickname()+": "+"State4");
	}
	
}
