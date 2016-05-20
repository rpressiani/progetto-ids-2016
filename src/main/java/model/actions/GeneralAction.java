package model.actions;

import model.GameState;
import model.player.Player;

public interface GeneralAction {
	
	public void doAction(Player player, GameState gameState);
	public boolean acceptMove(Player player, GameState gameState);
}
