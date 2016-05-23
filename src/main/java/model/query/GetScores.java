package model.query;

import model.GameState;
import model.player.Player;

public class GetScores extends Query<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4255291160412653582L;

	@Override
	public String perform(Player player, GameState game) {
		StringBuilder scores = new StringBuilder();
		scores.append("\n[SERVER] PLAYERS SCORE:\n");
		
		for (Player nextPlayer : game.getPlayers()) {
			if (player.equals(nextPlayer)) {
				scores.append("[SERVER] " + nextPlayer.getNickname().toUpperCase() + ": " + nextPlayer.getScore().getItems().intValue() + "\n");
			} else {
				scores.append("[SERVER] " + nextPlayer.getNickname() + ": " + nextPlayer.getScore().getItems().intValue() + "\n");
			}
		}
		
		
		return scores.toString();
	}

}
