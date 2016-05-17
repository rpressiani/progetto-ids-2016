package controller.state;

import actions.MainAction;
import actions.NullAction;
import actions.QuickAction;
import gameState.GameState;
import player.Player;

public interface State {
	
	public default State transition(Player player, MainAction action, GameState gameState){
		System.out.println("You can't do a MainAction now");
		return this;
	}
	
	public default State transition(Player player, QuickAction action, GameState gameState){
		System.out.println("You can't do a QuickAction now");
		return this;
	}
	
	public default State transition(Player player, NullAction action, GameState gameState){
		System.out.println("You can't do a NullAction now");
		return this;
	}
}
