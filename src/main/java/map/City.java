package map;

import java.util.ArrayList; 
import bonusable.Bonusable;

import bonusItem.BonusItem;
import player.Player;

public class City extends Bonusable{
	private String name; 
	private Region region; 
	
	public City(String name, ArrayList<BonusItem> bonuses) {
		super(bonuses);
		this.name = name; 
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
	
	public boolean hasBuiltHere(Player player) {
		return player.getBuiltCities().contains(this);
	}

}
