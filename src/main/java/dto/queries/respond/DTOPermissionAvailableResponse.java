package dto.queries.respond;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import dto.DTOObject;
import dto.utilities.DTOPermissionCard;

public class DTOPermissionAvailableResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3441019209674861132L;
	
	private final Map<String, Set<DTOPermissionCard>> permissionPerRegion;
	
	/**
	 * @param permissionPerRegion
	 * @throws NullPointerException if permissionPerRegion is null
	 */
	public DTOPermissionAvailableResponse(Map<String, Set<DTOPermissionCard>> permissionPerRegion) {
		if(permissionPerRegion==null) {
			throw new NullPointerException("permissionPerRegion cannot be null"); 
		}
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
				msg.append(card);
			}
		}
		msg.append("\n");
		
		return msg.toString();
	}

}
