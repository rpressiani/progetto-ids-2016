package dto.queries.respond;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import dto.DTOObject;
import dto.map.DTOCity;
import dto.utilities.DTOPermissionCard;

public class DTOPermissionAvailableResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3441019209674861132L;
	
	private final Map<String, Set<DTOPermissionCard>> permissionPerRegion;
	
	public DTOPermissionAvailableResponse(Map<String, Set<DTOPermissionCard>> permissionPerRegion) {
		this.permissionPerRegion = permissionPerRegion;
	}

	/**
	 * @return the permissionPerRegion
	 */
	public Map<String, Set<DTOPermissionCard>> getPermissionPerRegion() {
		return permissionPerRegion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("\n[SERVER] Permission cards available:");
		
		for (Entry<String, Set<DTOPermissionCard>> entry : this.getPermissionPerRegion().entrySet()) {
			msg.append("\n[SERVER] " + entry.getKey().toUpperCase() + ": ");
			
			for (DTOPermissionCard card : entry.getValue()) {
				msg.append("\n[SERVER]\t Card ID: " + card.getIdCard() + ",\tcities:  ");
				
				for (DTOCity city : card.getCities()) {
					msg.append(" " + city.getName());
				}
			}
		}
		msg.append("\n");
		
		return msg.toString();
	}

}
