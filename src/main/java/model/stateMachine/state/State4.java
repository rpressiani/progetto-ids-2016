package model.stateMachine.state;

import model.GameState;
import model.actions.SellAction;
import model.player.Player;

public class State4 implements State {
	
	public void transition(Player player, SellAction action, GameState gameState){
		
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" decided what to sell");
			player.setState(new State6());
		}
		
		else player.setState(this);
	}
	
	@Override
	public void checkTurn(Player player, GameState gameState){
		if(gameState.isMarketStarted()==false) gameState.nextPlayer(player);
		if(player==gameState.getPlayers().get(gameState.getPlayers().size()-1)) gameState.setMarketStarted(true);
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State4");
	}
	
}
