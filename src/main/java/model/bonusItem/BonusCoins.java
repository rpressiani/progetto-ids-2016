package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusCoins implements BonusItem {
	private final int items;
		
	public BonusCoins(int items) {
		this.items = items;
	}

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
