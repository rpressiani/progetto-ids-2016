package bonusable;

import java.util.ArrayList;
import bonusItem.BonusItem;
import market.Marketable;
import player.Player;

public class PermissionCard extends Bonusable implements Marketable {
	
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
	
	@Override
	public void makeExchange(Player fromPlayer, Player toPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyAdd(Player player) {
		// TODO Auto-generated method stub
		return false;
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
