package map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import council.Balcony;
import council.GarbageState;
import jaxb.CFGRegion;
import parser.Parser;
import sharedObjects.PermissionDeck;

public class Region {
	private String name;
	private PermissionDeck permissionDeck;
	private Balcony balcony;
	private Set<City> regionCities;
	
	public Region(String name, GarbageState garbage, Parser parser, Map map){
		this.name = name;
		this.balcony = new Balcony(garbage, parser);
		
		//To be implemented with the data received by the parser
		this.regionCities = new HashSet<City>();
		Set<City> allCities = map.allVertexes();
		List<CFGRegion> cfgRegions = parser.getCFGRoot().getMap().getRegion();
		CFGRegion cfgRegion = new CFGRegion();
		for (Iterator<CFGRegion> iterator = cfgRegions.iterator(); iterator.hasNext();) {
			cfgRegion = iterator.next();
			if (cfgRegion.getName() == this.name) break;
		}
		

		for (Iterator<String> iteratorRegionCity = cfgRegion.getCities().getCity().iterator(); iteratorRegionCity.hasNext();) {
			String cityString =  iteratorRegionCity.next();
			for (Iterator<City> iteratorAllCities = allCities.iterator(); iteratorAllCities.hasNext();) {
				City cityToAdd = iteratorAllCities.next(); 
				if (cityToAdd.getName() == cityString) {
					this.regionCities.add(cityToAdd);
					break;
				}
			}
		}
		
		this.permissionDeck = new PermissionDeck(parser, this);

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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
