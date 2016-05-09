package map;

import java.util.HashSet;
import java.util.Set;

import council.Balcony;
import council.GarbageState;
import parser.Parser;
import sharedObjects.PermissionDeck;

public class Region {
	private String name;
	private PermissionDeck permissionDeck;
	private Balcony balcony;
	private Set<City> regionCities;
	
	public Region(String name, GarbageState garbage, Parser parser){
		this.name = name;
		this.balcony = new Balcony(garbage, parser);
		
		//To be implemented with the data received by the parser
		this.regionCities = new HashSet<City>();
		
		this.permissionDeck = new PermissionDeck(parser, this.name, null);
	}
	
	/**
	 * @return the permissionDeck
	 */
	public PermissionDeck getPermissionDeck() {
		return permissionDeck;
	}
	
	/**
	 * @return the balcony
	 */
	public Balcony getBalcony() {
		return balcony;
	}

	/**
	 * @return the regionCities
	 */
	public Set<City> getRegionCities() {
		return regionCities;
	}
	
}
