package actions;

import gameState.GameState;
import player.Player;

public interface GeneralAction {
	
	public boolean acceptMove(Player player, GameState gameState);
	public void doAction(Player player, GameState gameState);
}
