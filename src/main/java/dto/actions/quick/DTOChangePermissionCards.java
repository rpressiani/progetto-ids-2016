package dto.actions.quick;

import controller.VisitorActions;
import dto.map.DTORegion;
import model.actions.quick.SubstitutePermissionCards;
import model.player.Player;

public class DTOChangePermissionCards implements DTOQuickAction {

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
	public SubstitutePermissionCards accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
