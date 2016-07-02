package dto.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
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
	private final Map<String, Integer> bonuses;
	
//	TO STRING!!!
	public DTOPermissionCard(int idCard, boolean used, Set<DTOCity> cities, Map<String, Integer> bonuses) {
		super(idCard);

		this.used = used;
		this.cities = cities;
		this.bonuses = bonuses;
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

	/**
	 * @return the bonuses
	 */
	public Map<String, Integer> getBonuses() {
		return bonuses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append("\n[SERVER] Card " + this.getIdCard() + "\n\t[SERVER] Cities: ");
		for (DTOCity city: this.cities) {
			msg.append(city.getName() + " ");
		}
		msg.append("\n\t[SERVER] Bonuses: ");
		int index = 0;
		for (Map.Entry<String, Integer> entry : this.bonuses.entrySet()) {
			if (index != 0) msg.append(", ");
			ArrayList<String> classExpand = new ArrayList<String>(Arrays.asList(entry.getKey().split("\\.")));
			msg.append(classExpand.get(2) + ": " + entry.getValue());
			index++;
		}
		msg.append(".");
		
		return msg.toString();
	}

}
