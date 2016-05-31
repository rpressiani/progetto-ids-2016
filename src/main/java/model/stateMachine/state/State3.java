package model.stateMachine.state;

import model.GameState;
import model.actions.main.MainAction;
import model.player.Player;

public class State3 implements State {
	
	@Override
	public void transition(Player player, MainAction action, GameState gameState){
		if(player==null || action==null || gameState==null) {
			throw new NullPointerException("player, action and gameState should all be !=null"); 
		}
		if(action.acceptMove(player, gameState)==true){
			action.doAction(player, gameState);
			System.out.println(player.getNickname()+" did a MainAction");
			player.setState(new State4());
			player.getState().checkTurn(player, gameState);
		}
		
	}
	
	@Override
	public void printOut(Player player, State state) {
		if(player==null || state==null) {
			throw new NullPointerException("player and state should not be null"); 
		}
		System.out.println(player.getNickname()+": "+"State3");
	}

}
