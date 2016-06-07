package model.stateMachine.state;

import model.GameState;
import model.actions.NullAction;
import model.actions.quick.QuickAction;
import model.changes.ChangeMsg;
import model.player.Player;

public class CanQuickOrNullState implements State {
	
	private boolean inputBonusRequired=false;
	
	@Override
	public void transition(Player player, QuickAction action, GameState gameState){
		if(isInputBonusRequired()==false){
			if(player==null || action==null || gameState==null) {
				throw new NullPointerException("player, action and gameState should all be !=null"); 
			}
			
			if(action.acceptMove(player, gameState)==true){
				if(action.checkCondition(player, gameState)==true){
					action.doAction(player, gameState);
					System.out.println(player.getNickname()+" did a QuickAction");
					gameState.notifyObserver(new ChangeMsg(player.getNickname()+" did a QuickAction"));
					player.setState(new CanSellState());
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
					player.setState(new CanSellState());
					player.getState().checkTurn(player, gameState);
				}
			}
		}
		
		else State.super.transition(player, action, gameState);
	}
	
	@Override
	public void printOut(Player player, State state) {
		if(player==null || state==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		System.out.println(player.getNickname()+": "+"State2");
	}

	public boolean isInputBonusRequired() {
		return inputBonusRequired;
	}

	public void setInputBonusRequired(boolean inputBonusRequired) {
		this.inputBonusRequired = inputBonusRequired;
	}
}
