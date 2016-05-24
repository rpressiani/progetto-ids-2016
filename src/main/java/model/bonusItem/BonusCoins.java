package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusCoins implements BonusItem {
	private final int items;
		
	/**
	 * set coins bonus
	 * @param items can't be <=0
	 */
	public BonusCoins(int items) {
		this.items = items;
	}

	@Override
	public void giveBonus(Player player, GameState gameState){
		player.getCoins().add(items);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BonusCoins [items=" + items + "]";
	}
	

}
