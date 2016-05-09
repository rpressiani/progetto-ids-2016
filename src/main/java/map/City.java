package map;

import java.util.Collection;

import player.Player;

public class City {
	private String name; 
	private Region region; 
	private Collection<City> nearCities; // File!
	private Map map; 
	public City(String name) {
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
	public Collection<City> getNearCities() {
		return nearCities; 
	}
	public boolean hasBuiltThere(Player player) {
		for(City c : player.getBuiltCities()) {
			if(player.getBuiltCities().contains(c))
				return true; 
		}
		return false; 
	}

}
