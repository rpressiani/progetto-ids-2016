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
	private String nameLong;
	private Region region;
	private Ancestry ancestry;
	
	/**
	 * @param name
	 * @param bonuses
	 * @param ancestry
	 * @param nameLong
	 * @throws NullPointerException if one of the parameters is null
	 * constructor for object City
	 */
	public City(String name, String nameLong, ArrayList<BonusItem> bonuses, Region region, Ancestry ancestry) {
		super(bonuses);
		if(name==null) {
			throw new NullPointerException("name cannot be null"); 
		}
		if(nameLong==null) {
			throw new NullPointerException("nameLong cannot be null"); 
		}
		if(bonuses==null) {
			throw new NullPointerException("bonuses cannot be null"); 
		}
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		if(ancestry==null) {
			throw new NullPointerException("ancestry cannot be null"); 
		}
		this.name = name;
		this.region = region;
		this.ancestry = ancestry;
		this.nameLong = nameLong;
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
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		return player.getBuiltCities().contains(this);
	}
	
	/**
	 * @param map
	 * @param player
	 * @return all the connected cities where a player has built
	 */
	public Set<City> linkedCities(Map map, Player player) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(map==null) {
			throw new IllegalArgumentException("cannot have a null map"); 
		}
		Set<City> linkedCities = null;
		UndirectedSubgraph<City, DefaultEdge> sg = new UndirectedSubgraph<City, DefaultEdge>(map.getGraph(), player.getBuiltCities(), null); 
		ConnectivityInspector<City, DefaultEdge> inspector = new ConnectivityInspector<City, DefaultEdge>(sg);
		linkedCities = inspector.connectedSetOf(this);
		return linkedCities; 
	}
	/**
	 * @return the ancestry
	 */
	public Ancestry getAncestry() {
		return ancestry;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "City [name=" + name + ",nameLong=" + nameLong + ",region=" + region + ",\tancestry=" + ancestry
				+ ", toString()=" + super.toString() + "]";
	}
	
	public String toStringSimple() {
		return this.name+" ";
	}


}
