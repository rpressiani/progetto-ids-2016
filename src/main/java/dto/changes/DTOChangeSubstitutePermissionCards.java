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
	
	public DTOChangeSubstitutePermissionCards(DTOAssistants assistants, DTORegion region){
		this.assistants=assistants;
		this.region=region;
	}

	public DTOAssistants getAssistants() {
		return assistants;
	}

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
