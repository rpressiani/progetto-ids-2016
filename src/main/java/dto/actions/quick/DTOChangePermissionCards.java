package dto.actions.quick;

import dto.actions.DTOAction;
import dto.map.DTORegion;

public class DTOChangePermissionCards implements DTOAction {

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
