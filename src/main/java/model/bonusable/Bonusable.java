package model.bonusable;

import java.util.ArrayList;
import java.util.Iterator;

import model.GameState;
import model.bonusItem.BonusItem;
import model.player.Player;

public abstract class Bonusable {
	private final ArrayList<BonusItem> bonuses;
	
	/**
	 * create the set of bonuses for a bonusable object
	 * @param bonuses can't be null
	 */
	public Bonusable(ArrayList<BonusItem> bonuses) {
		this.bonuses = bonuses;
	}
	
	/**
	 * check all bonuses to give to the player
	 * @param player can't be null
	 * @param gameState can't be null
	 */
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
