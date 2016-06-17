package model.stateMachine;

import model.GameState;
import model.actions.NullAction;
import model.actions.quick.QuickAction;
import model.changes.ChangeMsg;
import model.player.Player;

public class CanQuickOrNullState implements State {

	@Override
	public void transition(Player player, QuickAction action, GameState gameState){
		if(player.getBonusInputs().isEmpty()){
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
		
		if(player.getBonusInputs().isEmpty()){	
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

}
