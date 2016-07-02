package model.stateMachine;

import model.GameState;
import model.actions.NullAction;
import model.actions.market.BuyAction;
import model.changes.ChangeMsg;
import model.player.Player;

public class CanBuyState implements State {
	
	@Override
	public void transition(Player player, BuyAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(action.acceptMove(player, gameState)==true){
			if(action.checkCondition(player, gameState)==true){
				action.doAction(player, gameState);
				System.out.println(player.getNickname()+" decided what to buy");
				gameState.notifyAllExceptPlayer(player, new ChangeMsg(player.getNickname()+" decided what to buy"));
				player.setState(new StartState());
				player.getState().checkTurn(player, gameState);
				
				if(player==gameState.getPlayers().get(gameState.getPlayers().size()-1)){
					gameState.getMarket().getContractSet().clear();
				}
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
				System.out.println(player.getNickname()+" passed the turn");
				gameState.notifyAllExceptPlayer(player, new ChangeMsg(player.getNickname()+" passed the turn"));
				player.setState(new StartState());
				player.getState().checkTurn(player, gameState);
			}
		}

	}
	
	@Override
	public void checkTurn(Player player, GameState gameState){
		if(player==null || gameState==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		
		if(player==gameState.getPlayers().get(gameState.getPlayers().size()-1)){
			gameState.notifyObserver(new ChangeMsg("The market has finished"));
		}
		gameState.nextPlayer(player);
		gameState.notifyObserver(new ChangeMsg("Now it's time for "+gameState.getCurrentPlayer().getNickname()+" to play"));
	}
}
