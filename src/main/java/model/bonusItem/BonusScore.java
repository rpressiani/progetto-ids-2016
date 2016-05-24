package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusScore implements BonusItem {
	private final int items;
	
	/**
	 * set the score bonus
	 * @param items can't be <=0
	 */
	public BonusScore(int items) {
		this.items = items;
	}

	@Override
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
