package model.bonusItem;
import model.GameState;
import model.player.Player;

public interface BonusItem {

	public void giveBonus(Player player, GameState gameState);
}
