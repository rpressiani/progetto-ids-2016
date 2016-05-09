package map;

import java.util.Set;

import council.Balcony;
import sharedObjects.PermissionDeck;

public class Region {
	private PermissionDeck permissionDeck;
	private Balcony balcony;
	private Set<City> regionCities;
	
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
