package bonusable;

import java.util.ArrayList;
import bonusItem.BonusItem;

public class NobilityBox extends Bonusable {

	private final int index;
	
	public NobilityBox(ArrayList<BonusItem> bonuses, int index) {
		super(bonuses);
		this.index=index;
	}
	
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

}
