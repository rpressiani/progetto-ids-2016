package dto.actions.quick;

import controller.VisitorActions;
import dto.actions.DTOAction;
import dto.map.DTORegion;
import model.actions.GeneralAction;

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

	@Override
	public void accept(VisitorActions v) {
		v.visit(this);
	}

}
