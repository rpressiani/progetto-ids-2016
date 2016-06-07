package dto.actions.quick;

import controller.VisitorActions;
import dto.map.DTORegion;
import model.actions.quick.SubstitutePermissionCards;
import model.player.Player;

public class DTOSubstitutePermissionCards implements DTOQuickAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5267892027275442082L;
	
	private final DTORegion region;
	
	/**
	 * @param region
	 * @throws NullPointerException if region is null
	 */
	public DTOSubstitutePermissionCards(DTORegion region) {
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
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
