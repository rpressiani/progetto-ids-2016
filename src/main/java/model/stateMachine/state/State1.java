package model.stateMachine.state;

import model.GameState;
import model.actions.MainAction;
import model.actions.QuickAction;
import model.player.Player;

public class State1 implements State {
	
	@Override
	public void transition(Player player, MainAction action, GameState gameState){
	
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" did a MainAction");
			player.setState(new State2());
			player.getState().checkTurn(player, gameState);
		}
	
	}
	
	@Override
	public void transition(Player player, QuickAction action, GameState gameState){
	
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" did a QuickAction");
			player.setState(new State3());
			player.getState().checkTurn(player, gameState);
		}
		
	}
	
	@Override
	public void checkTurn(Player player, GameState gameState){
		gameState.nextPlayer(player);
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State1");
	}

}
