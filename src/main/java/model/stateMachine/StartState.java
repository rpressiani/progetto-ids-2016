package model.stateMachine;

import model.GameState;
import model.actions.main.MainAction;
import model.actions.quick.QuickAction;
import model.changes.ChangeMsg;
import model.player.Player;

public class StartState implements State {
	
	@Override
	public void transition(Player player, MainAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		
		if(action.acceptMove(player, gameState)==true){
			if(action.checkCondition(player, gameState)==true){
				action.doAction(player, gameState);
				System.out.println(player.getNickname()+" did a MainAction");
				gameState.notifyAllExceptPlayer(player ,new ChangeMsg(player.getNickname()+" did a MainAction"));
				player.setState(new CanQuickOrNullState());
				player.getState().checkTurn(player, gameState);
			}
		}
	
	}
	
	@Override
	public void transition(Player player, QuickAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be not null"); 
		}
		if(action.acceptMove(player, gameState)==true){
			if(action.checkCondition(player, gameState)==true){
				action.doAction(player, gameState);
				System.out.println(player.getNickname()+" did a QuickAction");
				gameState.notifyAllExceptPlayer(player, new ChangeMsg(player.getNickname()+" did a QuickAction"));
				player.setState(new CanMainState());
				player.getState().checkTurn(player, gameState);
			}
		}
		
	}
	
	@Override
	public void checkTurn(Player player, GameState gameState) {
		if(player==null || gameState==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		
		gameState.nextPlayer(player);
		gameState.notifyObserver(new ChangeMsg("Now it's time for "+gameState.getCurrentPlayer().getNickname()+" to play"));
	}

}
