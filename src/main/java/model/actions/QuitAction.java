package model.actions;

import model.GameState;
import model.player.Player;

public class QuitAction implements GeneralAction {

	@Override
	public void doAction(Player player, GameState gameState) {
		// TODO Auto-generated method stub
		gameState.getPlayers().remove(player);
		gameState.getPlayersDisconnected().add(player);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		return true;
	}

}
