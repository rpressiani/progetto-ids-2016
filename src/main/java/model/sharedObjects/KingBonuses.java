package model.sharedObjects;

import java.util.ArrayList;
import java.util.LinkedList;

import model.bonusItem.BonusItem;
import model.bonusable.KingCard;
import parser.Parser;

public class KingBonuses {
	private LinkedList<KingCard> kingBonuses;

	/**
	 * create kingBonus cards
	 * @param parser can't be null
	 * @throws NullPointerException if parser is null
	 */
	public KingBonuses(Parser parser) {
		if(parser==null) {
			throw new NullPointerException("parser cannot be null"); 
		}
		this.kingBonuses = new LinkedList<KingCard>();
		
		for (int i = 0; i < parser.getCFGRoot().getKingBonuses().getBonuses().size(); i++) {
			ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
			bonuses = parser.getBonusesFromParser(parser.getCFGRoot().getKingBonuses().getBonuses().get(i).getBonus());
			KingCard kingCardToAdd = new KingCard(bonuses);
			this.kingBonuses.add(kingCardToAdd);
		}
		
	}
	
	/**
	 * @return the kingbonuses
	 */
	public LinkedList<KingCard> getKingbonuses() {
		return kingBonuses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KingBonuses [kingBonuses=" + kingBonuses + "]";
	}
	
}
