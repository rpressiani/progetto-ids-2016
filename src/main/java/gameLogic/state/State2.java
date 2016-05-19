package gameLogic.state;

import actions.NullAction;
import actions.QuickAction;
import gameState.GameState;
import player.Player;

public class State2 implements State {
	
	@Override
	public void transition(Player player, QuickAction action, GameState gameState){
		//action.doAction(player, gameState);
		if(action.acceptMove(player, gameState)==true) player.setState(new State4());
		
		else player.setState(this);
	}
	
	@Override
	public void transition(Player player, NullAction action, GameState gameState){
		//action.doAction(player, gameState);
		if(action.acceptMove(player, gameState)==true) player.setState(new State4());
		
		else player.setState(this);
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State2");
	}
}
