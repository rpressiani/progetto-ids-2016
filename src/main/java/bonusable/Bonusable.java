package bonusable;

import java.util.ArrayList;
import java.util.Iterator;

import bonusItem.BonusItem;
import player.Player;

public abstract class Bonusable {
	private final ArrayList<BonusItem> bonuses;
	
	public Bonusable(ArrayList<BonusItem> bonuses) {
		this.bonuses = bonuses;
	}
	
	public void assignBonuses(Player player){
		Iterator<BonusItem> itr=bonuses.iterator();
		while(itr.hasNext()){
			itr.next().giveBonus(player);
		}
	}
	
	/**
	 * @return the bonuses
	 */
	public ArrayList<BonusItem> getBonuses() {
		return bonuses;
	}
	
}
