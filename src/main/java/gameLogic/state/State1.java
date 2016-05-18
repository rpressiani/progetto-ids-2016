package gameLogic.state;

import actions.MainAction;
import actions.QuickAction;
import gameState.GameState;
import player.Player;

public class State1 implements State {
	
	@Override
	public State transition(Player player, MainAction action, GameState gameState){
		//action.doAction(player, gameState);
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" did a MainAction");
			return new State2();
		}
		
		else{
			System.out.println("It's not your turn "+player.getNickname());
			return this;
		}
	}
	
	@Override
	public State transition(Player player, QuickAction action, GameState gameState){
		//action.doAction(player, gameState);
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" did a QuickAction");
			return new State3();
		}
		
		else{
			System.out.println("It's not your turn "+player.getNickname());
			return this;
		}
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State1");
	}

}
