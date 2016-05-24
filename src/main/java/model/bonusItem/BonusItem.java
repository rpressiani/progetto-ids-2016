package model.bonusItem;
import model.GameState;
import model.player.Player;

public interface BonusItem {

	/**
	 * give the single bonus to the player
	 * @param player can't be null
	 * @param gameState can't be null
	 */
	public void giveBonus(Player player, GameState gameState);
}
