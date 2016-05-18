package gameLogic.state;

import actions.NullAction;
import actions.QuickAction;
import gameState.GameState;
import player.Player;

public class State2 implements State {
	
	@Override
	public State transition(Player player, QuickAction action, GameState gameState){
		//action.doAction(player, gameState);
		if(action.acceptMove(player, gameState)==true) return new State4();
		
		else return this;
	}
	
	@Override
	public State transition(Player player, NullAction action, GameState gameState){
		//action.doAction(player, gameState);
		if(action.acceptMove(player, gameState)==true) return new State4();
		
		else return this;
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State2");
	}
}
