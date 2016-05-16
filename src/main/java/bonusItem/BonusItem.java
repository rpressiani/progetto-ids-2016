package bonusItem;
import gameState.GameState;
import player.Player;

public interface BonusItem {

	public void giveBonus(Player player, GameState gameState);
}
