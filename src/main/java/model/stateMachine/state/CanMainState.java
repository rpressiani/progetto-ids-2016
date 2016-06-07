package model.stateMachine.state;

import model.GameState;
import model.actions.main.MainAction;
import model.changes.ChangeMsg;
import model.player.Player;

public class CanMainState implements State {
	
	private boolean intpuBonusRequired=false;
	
	@Override
	public void transition(Player player, MainAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
				throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(isIntpuBonusRequired()==false){	
			if(action.acceptMove(player, gameState)==true){
				if(action.checkCondition(player, gameState)==true){
					action.doAction(player, gameState);
					System.out.println(player.getNickname()+" did a MainAction");
					gameState.notifyObserver(new ChangeMsg(player.getNickname()+" did a MainAction"));
					player.setState(new CanSellState());
					player.getState().checkTurn(player, gameState);
				}
			}
		}
		
		else State.super.transition(player, action, gameState);
		
	}
	
	@Override
	public void transition(Player player, model.actions.inputBonus.InputBonusAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(isIntpuBonusRequired()==true){
			
		}
		
		else State.super.transition(player, action, gameState);
	}
	
	@Override
	public void printOut(Player player, State state) {
		if(player==null || state==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		System.out.println(player.getNickname()+": "+"State3");
	}

	public boolean isIntpuBonusRequired() {
		return intpuBonusRequired;
	}

	public void setIntpuBonusRequired(boolean intpuBonusRequired) {
		this.intpuBonusRequired = intpuBonusRequired;
	}

}
