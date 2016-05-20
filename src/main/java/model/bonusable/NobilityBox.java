package model.bonusable;

import java.util.ArrayList;

import model.bonusItem.BonusItem;

public class NobilityBox extends Bonusable {

	private final int level;
	
	public NobilityBox(ArrayList<BonusItem> bonuses, int level) {
		super(bonuses);
		this.level=level;
	}
	
	/**
	 * @return the index
	 */
	public int getLevel() {
		return level;
	}

}
