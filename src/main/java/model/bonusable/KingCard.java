package model.bonusable;

import java.util.ArrayList;

import model.bonusItem.BonusItem;

public class KingCard extends Bonusable {

	/**
	 * create the king card
	 * @param bonuses can't be null
	 */
	public KingCard(ArrayList<BonusItem> bonuses) {
		super(bonuses);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KingCard [toString()=" + super.toString() + "]";
	}

}
