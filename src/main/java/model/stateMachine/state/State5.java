package model.stateMachine.state;

import model.GameState;
import model.actions.BuyAction;
import model.player.Player;

public class State5 implements State {
	
	public void transition(Player player, BuyAction action, GameState gameState){
		
		if(action.acceptMove(player, gameState)==true){
			System.out.println(player.getNickname()+" decided what to buy");
			player.setState(new State1());
			this.checkTurn(player, gameState);
		}
		
		else player.setState(this);
	}
	
	@Override
	public void printOut(Player player, State state){
		System.out.println(player.getNickname()+": "+"State5");
	}
	
	@Override
	public void checkTurn(Player player, GameState gameState){
		gameState.nextPlayer(player);
		if(player==gameState.getPlayers().get(gameState.getPlayers().size()-1) && gameState.isMarketStarted()) gameState.setMarketStarted(false);
	}
}
