package dto.changes;

import dto.playerInfo.DTOAssistants;

public class DTOChangeSubstitutePermissionCards implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2959752683182474503L;

	private final DTOAssistants assistants;
	private final String nameRegion;
	
	public DTOChangeSubstitutePermissionCards(DTOAssistants assistants, String nameRegion){
		this.assistants=assistants;
		this.nameRegion=nameRegion;
	}

	public DTOAssistants getAssistants() {
		return assistants;
	}

	public String getNameRegion() {
		return nameRegion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "You used "+assistants+" assistants to substitute permission cards of "+nameRegion;
	}
	
}
