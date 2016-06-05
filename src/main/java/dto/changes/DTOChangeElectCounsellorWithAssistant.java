package dto.changes;

import dto.map.DTORegion;
import dto.playerInfo.DTOAssistants;
import dto.utilities.DTOColor;

public class DTOChangeElectCounsellorWithAssistant implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6947498374720846137L;

	private final DTOAssistants assistants;
	private final DTOColor color;
	private final DTORegion region;
	
	public DTOChangeElectCounsellorWithAssistant(DTOAssistants assistants, DTOColor color, DTORegion region){
		this.assistants=assistants;
		this.color=color;
		this.region=region;
	}

	public DTOAssistants getAssistants() {
		return assistants;
	}

	public DTOColor getColor() {
		return color;
	}

	public DTORegion getRegion() {
		return region;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "You used "+assistants+" assistants to elect a "+color+" counsellor in "+region+"'s balcony";
	}

}
