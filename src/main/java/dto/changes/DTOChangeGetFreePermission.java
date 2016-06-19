package dto.changes;

import dto.map.DTORegion;
import dto.utilities.DTOPermissionCardSelection;

public class DTOChangeGetFreePermission implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2283718843222655955L;
	
	private final DTORegion region;
	private final DTOPermissionCardSelection card;
	
	public DTOChangeGetFreePermission(DTORegion region, DTOPermissionCardSelection card){
		if(region==null || card==null) throw new NullPointerException("region/card can't be null");
		
		this.region=region;
		this.card=card;
	}

	public DTORegion getRegion() {
		return region;
	}

	public DTOPermissionCardSelection getCard() {
		return card;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "You got the permission card #"+card+" from "+region;
	}

}
