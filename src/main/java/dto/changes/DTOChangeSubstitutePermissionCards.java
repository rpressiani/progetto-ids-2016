package dto.changes;

import dto.map.DTORegion;
import dto.playerInfo.DTOAssistants;

public class DTOChangeSubstitutePermissionCards implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2959752683182474503L;

	private final DTOAssistants assistants;
	private final DTORegion region;
	
	/**
	 * @param assistants
	 * @param region
	 * @throws NullPointerException if assistants or region are null
	 */
	public DTOChangeSubstitutePermissionCards(DTOAssistants assistants, DTORegion region) {
		if(assistants==null) {
			throw new NullPointerException("assistants cannot be null"); 
		}
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		this.assistants=assistants;
		this.region=region;
	}

	/**
	 * 
	 * @return the assistants
	 */
	public DTOAssistants getAssistants() {
		return assistants;
	}

	/**
	 * 
	 * @return the region
	 */
	public DTORegion getRegion() {
		return region;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "You used "+assistants+" assistants to substitute permission cards of "+region;
	}
	
}
