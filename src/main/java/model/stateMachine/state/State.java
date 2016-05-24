package model.stateMachine.state;

import model.GameState;
import model.actions.BuyAction;
import model.actions.MainAction;
import model.actions.NullAction;
import model.actions.QuickAction;
import model.actions.SellAction;
import model.player.Player;

public interface State {
	
	public default void transition(Player player, MainAction action, GameState gameState){
		if(action.acceptMove(player, gameState)==true) System.out.println("You can't do a MainAction now");
	}
	
	public default void transition(Player player, QuickAction action, GameState gameState){
		if(action.acceptMove(player, gameState)==true) System.out.println("You can't do a QuickAction now"); 
	}
	
	public default void transition(Player player, NullAction action, GameState gameState){
		if(action.acceptMove(player, gameState)==true) System.out.println("You can't do a NullAction now");
	}
	
	public default void transition(Player player, SellAction action, GameState gameState){
		if(action.acceptMove(player, gameState)==true) System.out.println("You can't sell items now");
	}
	
	public default void transition(Player player, BuyAction action, GameState gameState){
		if(action.acceptMove(player, gameState)==true) System.out.println("You can't buy items now");
		//player.setState(this);
	}
	
	public default void checkTurn(Player player, GameState gameState){
		
	}
	
	public void printOut(Player player, State state);
}
