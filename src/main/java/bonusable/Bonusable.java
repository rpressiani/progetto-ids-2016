package bonusable;

import java.util.ArrayList;
import java.util.Iterator;

import bonusItem.BonusItem;
import gameState.GameState;
import player.Player;

public abstract class Bonusable {
	private final ArrayList<BonusItem> bonuses;
	
	public Bonusable(ArrayList<BonusItem> bonuses) {
		this.bonuses = bonuses;
	}
	
	public void assignBonuses(Player player, GameState gameState){
		Iterator<BonusItem> itr=bonuses.iterator();
		while(itr.hasNext()){
			itr.next().giveBonus(player, gameState);
		}
	}
	
	/**
	 * @return the bonuses
	 */
	public ArrayList<BonusItem> getBonuses() {
		return bonuses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bonusable [bonuses=" + bonuses + "]";
	}
	
}
