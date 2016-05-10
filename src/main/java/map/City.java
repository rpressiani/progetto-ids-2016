package map;

import bonusItem.BonusItem;

import java.util.ArrayList; 
import bonusable.Bonusable;
import player.Player;

public class City extends Bonusable{
	private String name; 
//	private Set<City> nearCities; // File!

	
	public City(String name, ArrayList<BonusItem> bonuses) {
		super(bonuses);
		this.name = name; 
//		this.nearCities = nearCities;
		//it should read near cities from configuration file!
	}

	/*public boolean kingPresence() {
		return false;
	}*/
	public String getName() {
		return name; 
	}

//	public Collection<City> getNearCities() {
//		return nearCities; 
//	}
	
	public boolean hasBuiltThere(Player player) {
		for(City c : player.getBuiltCities()) {
			if(player.getBuiltCities().contains(c))
				return true; 
		}
		return false; 
	}

}
