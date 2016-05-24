package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusCoins implements BonusItem {
	private final int items;
		
	/**
	 * set coins bonus
	 * @param items can't be <=0
	 * @throws IllegalArgumentException if items<=0
	 */
	public BonusCoins(int items) {
		if(items<=0) {
			throw new IllegalArgumentException("items must be greater than zero"); 
		}
		this.items = items;
	}
	@Override
	public void giveBonus(Player player, GameState gameState){
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
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
