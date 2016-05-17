package controller.state;

import actions.MainAction;
import actions.QuickAction;
import gameState.GameState;
import player.Player;

public class State1 implements State {
	
	@Override
	public State transition(Player player, MainAction action, GameState gameState){
		action.doAction(player, gameState);
		return new State2();
	}
	
	@Override
	public State transition(Player player, QuickAction action, GameState gameState){
		action.doAction(player, gameState);
		return new State3();
	}

}
