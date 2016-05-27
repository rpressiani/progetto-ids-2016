package dto.actions;

import dto.DTOObject;
import dto.map.DTORegion;

public class DTOChangePermissionCards implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5267892027275442082L;
	
	private final DTORegion region;
	
	public DTOChangePermissionCards(DTORegion region) {
		this.region = region;
	}

	/**
	 * @return the region
	 */
	public DTORegion getRegion() {
		return region;
	}

}
