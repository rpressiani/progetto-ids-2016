package map;

import java.util.HashSet;
import bonusItem.BonusItem;
import java.util.ArrayList; 
import bonusable.Bonusable;
import player.Player;

public class City extends Bonusable{
	private String name; 
	private Region region; 
	private HashSet<City> nearCities; // File!
	public City(String name, ArrayList<BonusItem> bonuses) {
		super(bonuses);
		this.name = name; 
		//it should read near cities from configuration file!
	}
	
	/*public boolean kingPresence() {
		return false;
	}*/
	public String getName() {
		return name; 
	}
	public Region getRegion() {
		return region; 
	}
	public HashSet<City> getNearCities() {
		return nearCities; 
	}
	//checks if a given player has built in a determined city
	public boolean hasBuiltThere(Player player) {
		for(City c : player.getBuiltCities()) {
			if(player.getBuiltCities().contains(c))
				return true; 
		}
		return false; 
	}
	

}
