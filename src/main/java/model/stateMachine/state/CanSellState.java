package model.stateMachine.state;

import model.GameState;
import model.actions.NullAction;
import model.actions.market.SellAction;
import model.changes.ChangeMsg;
import model.player.Player;

public class CanSellState implements State {
	
	private boolean inputBonusRequired=false;
	
	@Override
	public void transition(Player player, SellAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(isInputBonusRequired()==false){
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
		
		else State.super.transition(player, action, gameState);
	}
	
	@Override
	public void transition(Player player, NullAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
				throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(isInputBonusRequired()==false){	
			if(action.acceptMove(player, gameState)==true){
				if(action.checkCondition(player, gameState)==true){
					action.doAction(player, gameState);
					System.out.println(player.getNickname()+" passed the turn");
					gameState.notifyObserver(new ChangeMsg(player.getNickname()+" passed the turn"));
					player.setState(new CanBuyState());
					player.getState().checkTurn(player, gameState);
				}
			}
		}
		
		else State.super.transition(player, action, gameState);
	}
	
	@Override
	public void checkTurn(Player player, GameState gameState){
		if(player==null || gameState==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		
		if(isInputBonusRequired()==false){
			if(player==gameState.getPlayers().get(gameState.getPlayers().size()-1)){
				gameState.notifyObserver(new ChangeMsg("The market has started"));
			}
			gameState.nextPlayer(player);
			gameState.notifyObserver(new ChangeMsg("Now it's time for "+gameState.getCurrentPlayer().getNickname()+" to play"));
		}
		
		else State.super.checkTurn(player, gameState);
	}
	
	@Override
	public void printOut(Player player, State state){
		if(player==null || state==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		System.out.println(player.getNickname()+": "+"State4");
	}

	public boolean isInputBonusRequired() {
		return inputBonusRequired;
	}

	public void setInputBonusRequired(boolean inputBonusRequired) {
		this.inputBonusRequired = inputBonusRequired;
	}
	
}
