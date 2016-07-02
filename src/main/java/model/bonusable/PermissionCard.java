package model.bonusable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.bonusItem.BonusItem;
import model.map.City;
import model.market.Marketable;
import model.player.Player;

public class PermissionCard extends Bonusable implements Marketable {
	
	private static int counter=0;
	private final int idCard;
	private boolean used;	//true if used
	private Set<City> possibleCities;
	
	/**
	 * create the permission cards
	 * @param bonuses can't be null
	 * @param cities can't be null
	 * @throws NullPointerException if cities is null
	 */
	public PermissionCard(ArrayList<BonusItem> bonuses, HashSet<City> cities) {
		super(bonuses);
		if(cities==null) {
			throw new NullPointerException("cities should not be null");
		}
		this.idCard=counter;
		counter++;
		this.used=false;
		this.possibleCities = cities;
	}
	
	@Override
	public void makeExchange(Marketable m, Player fromPlayer, Player toPlayer) {
		if(fromPlayer==null || toPlayer==null) {
			throw new NullPointerException("both these two players should not be null"); 
		}
		
		PermissionCard card=(PermissionCard) m;
		
		fromPlayer.getPermissionHand().remove(card);
		toPlayer.getPermissionHand().add(card);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PermissionCard [idCard=" + idCard + ", used=" + used + ", possibleCities=" + possibleCities + "]";
	}
	
}
