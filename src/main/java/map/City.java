package map;

import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import bonusItem.BonusItem;
import java.util.ArrayList; 
import bonusable.Bonusable;
import player.Player;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;


public class City extends Bonusable{
	private String name; 
	private Region region; 
	private Set<City> nearCities; // File
	public City(String name, ArrayList<BonusItem> bonuses) {
		super(bonuses);
		this.name = name; 
		this.nearCities = new HashSet<City>();
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
	public Set<City> getNearCities() {
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
	//returns all the connected cities "conquered" by a player
	public Set<City> linkedCities(UndirectedGraph<City, DefaultEdge> map, Player player, City c) {
		Set<City> linkedCities; 
		//player must have built somewhere
		if(player.getBuiltCities()!=null && player.getBuiltCities().contains(c) ) {
			
		}
		return nearCities; 
	}
	

}
