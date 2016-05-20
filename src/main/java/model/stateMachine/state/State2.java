package model.stateMachine.state;

import model.GameState;
import model.actions.NullAction;
import model.actions.QuickAction;
import model.player.Player;

public class State2 implements State {
	
	@Override
	public void transition(Player player, QuickAction action, GameState gameState){
	
		if(action.acceptMove(player, gameState)==true) player.setState(new State4());
		
		else player.setState(this);
	}
	
	@Override
	public void transition(Player player, NullAction action, GameState gameState){
		
		if(action.acceptMove(player, gameState)==true) player.setState(new State4());
		
		else player.setState(this);
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State2");
	}
}