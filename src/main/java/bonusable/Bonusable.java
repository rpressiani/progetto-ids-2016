package bonusable;
import bonusItem.BonusItem;

public abstract class Bonusable {
	private BonusItem[] bonuses;

	/**
	 * @return the bonuses
	 */
	public BonusItem[] getBonuses() {
		return bonuses;
	}

	/**
	 * @param bonuses the bonuses to set
	 */
	public void setBonuses(BonusItem[] bonuses) {
		this.bonuses = bonuses;
	} 
}
