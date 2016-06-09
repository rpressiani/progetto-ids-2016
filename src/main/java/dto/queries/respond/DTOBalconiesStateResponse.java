package dto.queries.respond;

import java.util.Map;
import java.util.Map.Entry;

import dto.DTOObject;
import dto.utilities.DTOBalcony;
import dto.utilities.DTOColor;

public class DTOBalconiesStateResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4370308575803402241L;
	
	private final Map<String, DTOBalcony> balconies;
	
	public DTOBalconiesStateResponse(Map<String, DTOBalcony> balconies) {
		this.balconies = balconies;
	}

	/**
	 * @return the balconies
	 */
	public Map<String, DTOBalcony> getBalconies() {
		return balconies;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("\n[SERVER] Balconies state:\t< ------------------------ ]");
		
		for (Entry<String, DTOBalcony> balcony : this.balconies.entrySet()) {
			if (balcony.getKey().length() < 7) {
				msg.append("\n[SERVER] " + balcony.getKey().toUpperCase() + ":\t\t\t");
			} else {
				msg.append("\n[SERVER] " + balcony.getKey().toUpperCase() + ":\t\t");
			}
			
			for (DTOColor color : balcony.getValue().getBalconyState()) {
				msg.append(color.getColorString() + "\t");
			}
		}
		msg.append("\n");
		
		return msg.toString();
	}
	

}
