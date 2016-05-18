package gameLogic;

import java.util.ArrayList;

import gameState.GameState;
import player.Player;

public class GameLogic {
	
	public GameLogic(GameState gameState){
	}
	
	public Player nextPlayer(ArrayList<Player> players, Player player){
		int i=players.indexOf(player);
		if((i+1)!=players.size()) return players.get(i+1);
		else return players.get(0);
	}
}
