package actions;

import gameState.GameState;
import player.Player;

public interface GeneralAction {
	public void doAction(Player player, GameState gameState);
}
