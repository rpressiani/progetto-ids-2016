package model.bonusable;

import java.util.ArrayList;

import model.bonusItem.BonusItem;

public class NobilityBox extends Bonusable {

	private final int level;
	
	/**
	 * create the nobility box with its level
	 * @param bonuses can't be null
	 * @param level can't be <=0
	 * @throws IllegalArgumentException if level is <0
	 */
	public NobilityBox(ArrayList<BonusItem> bonuses, int level) {
		super(bonuses);
		if(level<0) {
			throw new IllegalArgumentException("level cannot be <0");
		}
		this.level=level;
	}
	
	/**
	 * @return the index
	 */
	public int getLevel() {
		return level;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NobilityBox [level=" + level + ", toString()=" + super.toString() + "]\n";
	}

}
