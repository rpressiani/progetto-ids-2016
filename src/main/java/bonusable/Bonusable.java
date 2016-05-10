package bonusable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bonusItem.BonusAssistants;
import bonusItem.BonusCoins;
import bonusItem.BonusItem;
import bonusItem.BonusNobility;
import bonusItem.BonusScore;
import jaxb.CFGBonus;
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
