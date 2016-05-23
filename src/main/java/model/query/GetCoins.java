package model.query;

import model.GameState;
import model.player.Player;

public class GetCoins extends Query<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5802993215110679995L;

	@Override
	public String perform(Player player, GameState game) {
		StringBuilder scores = new StringBuilder();
		scores.append("\n[SERVER] PLAYERS COINS:\n");
		
		for (Player nextPlayer : game.getPlayers()) {
			if (player.equals(nextPlayer)) {
				scores.append("[SERVER] " + nextPlayer.getNickname().toUpperCase() + ": " + nextPlayer.getCoins().getItems().intValue() + "\n");
			} else {
				scores.append("[SERVER] " + nextPlayer.getNickname() + ": " + nextPlayer.getCoins().getItems().intValue() + "\n");
			}
		}
		
		return scores.toString();
	}

}
