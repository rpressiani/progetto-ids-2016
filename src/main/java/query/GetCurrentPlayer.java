package query;

import model.GameState;
import model.player.Player;

public class GetCurrentPlayer extends Query<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2345177739168813204L;

	@Override
	public String perform(Player player, GameState game) {
		StringBuilder scores = new StringBuilder();
		scores.append("\n[SERVER] CURRENT PLAYER:" + game.getCurrentPlayer().getNickname() + "\n");
		
		return scores.toString();
	}

}
