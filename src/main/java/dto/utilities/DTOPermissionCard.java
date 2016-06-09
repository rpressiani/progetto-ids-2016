package dto.utilities;

import java.util.Set;

import dto.DTOObject;
import dto.map.DTOCity;

public class DTOPermissionCard extends DTOPermissionCardSelection implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3018472196804517104L;
	
	private final boolean used;
	private final Set<DTOCity> cities;
	
	public DTOPermissionCard(int idCard, boolean used, Set<DTOCity> cities) {
		super(idCard);

		this.used = used;
		this.cities = cities;
	}

	/**
	 * @return the used
	 */
	public boolean isUsed() {
		return used;
	}

	/**
	 * @return the cities
	 */
	public Set<DTOCity> getCities() {
		return cities;
	}

}
