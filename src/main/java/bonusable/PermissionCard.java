package bonusable;

import java.util.ArrayList;
import bonusItem.BonusItem;

public class PermissionCard extends Bonusable {
	
	/**
	 * used=true if PermissionCard has been used to build an emporium
	 */
	private static int counter=0;
	private final int idCard;
	private boolean used;
	
	public PermissionCard(ArrayList<BonusItem> bonuses) {
		super(bonuses);
		idCard=counter;
		counter++;
		this.used=false;
	}

	/**
	 * @return the idCard
	 */
	public int getIdCard() {
		return idCard;
	}

	/**
	 * @return the used
	 */
	public boolean isUsed() {
		return used;
	}

	/**
	 * @param used the used to set
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}
	
}
