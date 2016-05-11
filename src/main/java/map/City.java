package map;

import java.util.ArrayList;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;

import bonusable.Bonusable;

import bonusItem.BonusItem;
import player.Player;

public class City extends Bonusable{
	private String name; 
	private Region region; 
	private boolean kingPresence;
	
	public City(String name, ArrayList<BonusItem> bonuses) {
		super(bonuses);
		this.name = name; 
	}
	
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
	 * @param player
	 * @return true if a player has built in a determined city
	 */
	public boolean hasBuiltHere(Player player) {
		return player.getBuiltCities().contains(this);
	}
	
	/**
	 * @return the kingPresence
	 */
	public boolean isKingPresence() {
		return kingPresence;
	}

	/**
	 * @param kingPresence the kingPresence to set
	 */
	public void setKingPresence(boolean kingPresence) {
		this.kingPresence = kingPresence;
	}
	// controllo città adiacenti
	//
	/**
	 * @param map
	 * @param player
	 * @return all the connected cities where a player has built
	 */
	public Set<City> linkedCities(Map map, Player player) {
		Set<City> linkedCities = null;
		Set<City> builtCities = player.getBuiltCities(); 
		//Set<City> notBuiltCities = map.allVertexes(); 
		int counter = 1; 
		linkedCities.add(this);
		//assuming controller already knows that "this" is contained in builtCities
		for(City c : builtCities) {
			if(map.numericDistance((UndirectedGraph<City, DefaultEdge>)map, this, c)==counter) {
				linkedCities.add(c); 
			}
			c = this; 
		}
		return linkedCities; 
	}

}
