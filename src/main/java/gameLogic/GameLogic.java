package gameLogic;

import java.util.ArrayList;

import actions.GeneralAction;
import actions.MainAction;
import actions.NullAction;
import actions.QuickAction;
import gameState.GameState;
import player.Player;

public class GameLogic {
	private GameState gameState;
	
	public GameLogic(GameState gameState){
		this.gameState=gameState;
	}

	public void play(GameState gameState){
		//if(gameState.getCurrentPlayer().getState()==4) gameState.setCurrentPlayer(nextPlayer(gameState.getPlayers(), gameState.getCurrentPlayer()));
	}
	
	public void acceptMove(Player player, MainAction action){
		/*if(player==gameState.getCurrentPlayer()){
			
		}
		
		else throw exception*/
		player.setState(player.getState().transition(player, action, gameState));
	}
	
	public void acceptMove(Player player, QuickAction action){
		player.setState(player.getState().transition(player, action, gameState));
	}
	
	public void acceptMove(Player player, NullAction action){
		player.setState(player.getState().transition(player, action, gameState));
	}
	
	public Player nextPlayer(ArrayList<Player> players, Player player){
		int i=players.indexOf(player);
		if((i+1)!=players.size()) return players.get(i+1);
		else return players.get(0);
	}
}
