package model.map;

import java.util.ArrayList;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.UndirectedSubgraph;
import org.jgrapht.alg.ConnectivityInspector;

import model.bonusItem.BonusItem;
import model.bonusable.Bonusable;
import model.player.Player;

/**
 * @author Alessandro Pezzotta
 *
 */
public class City extends Bonusable{
	private String name; 
	private Region region;
	private String ancestry;
	
	/**
	 * @param name
	 * @param bonuses
	 * constructor for object City
	 */
	public City(String name, ArrayList<BonusItem> bonuses, String ancestry) {
		super(bonuses);
		this.name = name;
		this.region = null;
		this.ancestry = ancestry;
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
	 * @param map
	 * @param player
	 * @return all the connected cities where a player has built
	 */
	public Set<City> linkedCities(Map map, Player player) {
		Set<City> linkedCities = null;
		UndirectedSubgraph<City, DefaultEdge> sg = new UndirectedSubgraph<City, DefaultEdge>(map.getGraph(), player.getBuiltCities(), null); 
		ConnectivityInspector<City, DefaultEdge> inspector = new ConnectivityInspector<City, DefaultEdge>(sg);
		linkedCities = inspector.connectedSetOf(this); 
		return linkedCities; 
	}
	/**
	 * @return the ancestry
	 */
	public String getAncestry() {
		return ancestry;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}


}
