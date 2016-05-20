package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusScore implements BonusItem {
	private final int items;
	
	public BonusScore(int items) {
		this.items = items;
	}

	public void giveBonus(Player player, GameState gameState){
		player.getScore().add(items);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BonusScore [items=" + items + "]";
	}
}
