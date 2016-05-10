package map;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import bonusItem.BonusItem;

import java.util.ArrayList; 
import bonusable.Bonusable;
import player.Player;

public class City extends Bonusable{
	private String name; 
	private Region region; 
	private Set<City> nearCities; // File!
	
	public City(String name, ArrayList<BonusItem> bonuses) {
		super(bonuses);
		this.name = name; 
		this.nearCities = new HashSet<City>();
		//it should read near cities from configuration file!
	}
	
	/*public boolean kingPresence() {
		return false;
	}*/
	/**
	 * @return name of the city
	 */
	public String getName() {
		return name; 
	}
	/**
	 * @return name of the region
	 */
	public Region getRegion() {
		return region; 
	}
	/**
	 * @return all the cities near to a given one (read from file)
	 */
	public Collection<City> getNearCities() {
		return nearCities; 
	}
	/**
	 * @param player
	 * @return true if the player has built in a determined city
	 */
	public boolean hasBuiltThere(Player player) {
		for(City c : player.getBuiltCities()) {
			if(player.getBuiltCities().contains(c))
				return true; 
		}
		return false; 
	}

}
