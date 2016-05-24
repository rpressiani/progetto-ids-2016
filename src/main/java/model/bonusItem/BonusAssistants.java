package model.bonusItem;
import model.GameState;
import model.player.Player;

public class BonusAssistants implements BonusItem {
	private final int items;
	
	/**
	 * set assistants bonus
	 * @param items can't be <=0
	 */
	public BonusAssistants(int items) {
		this.items = items;
	}

	@Override
	public void giveBonus(Player player, GameState gameState){
		player.getAssistants().add(items);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BonusAssistants [items=" + items + "]";
	}
}
