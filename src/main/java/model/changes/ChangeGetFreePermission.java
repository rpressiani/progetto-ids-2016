package model.changes;

import dto.changes.DTOChange;
import model.bonusable.PermissionCard;
import model.map.Region;
import view.VisitorChanges;

public class ChangeGetFreePermission implements Change {

	private Region region;
	private PermissionCard card;
	
	public ChangeGetFreePermission(Region region, PermissionCard card) {
		if(region==null || card==null) throw new NullPointerException("region/card can't be null");
		
		this.region=region;
		this.card=card;
	}
	
	@Override
	public DTOChange accept(VisitorChanges v) {
		return v.visit(this);
	}

	
	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @return the card
	 */
	public PermissionCard getCard() {
		return card;
	}

}
