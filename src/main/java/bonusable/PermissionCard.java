package bonusable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import bonusItem.BonusItem;
import map.City;
import market.Marketable;
import player.Player;

public class PermissionCard extends Bonusable implements Marketable {
	
	private static int counter=0;
	private final int idCard;
	
	/**
	 * used=true if PermissionCard has been used to build an emporium
	 */
	private boolean used;
	private Set<City> possibleCities;
	
	public PermissionCard(ArrayList<BonusItem> bonuses, HashSet<City> cities) {
		super(bonuses);
		this.idCard=counter;
		counter++;
		this.used=false;
		this.possibleCities = cities;
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

	/**
	 * @return the counter
	 */
	public static int getCounter() {
		return counter;
	}

	/**
	 * @return the possibleCities
	 */
	public Set<City> getPossibleCities() {
		return possibleCities;
	}
	
}
