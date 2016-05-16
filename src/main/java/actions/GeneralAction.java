package actions;

import gameState.GameState;
import player.Player;

public interface GeneralAction {
	public boolean acceptMove(Player player);
	public void doAction(Player player, GameState gameState);
}
