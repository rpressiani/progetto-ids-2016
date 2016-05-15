package bonusable;

import java.util.ArrayList;

import bonusItem.BonusItem;

public class KingCard extends Bonusable {

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
