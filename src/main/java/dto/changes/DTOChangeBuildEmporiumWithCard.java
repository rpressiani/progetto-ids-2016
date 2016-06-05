package dto.changes;

import dto.map.DTOCity;
import dto.playerInfo.DTOAssistants;
import dto.utilities.DTOPermissionCard;

public class DTOChangeBuildEmporiumWithCard implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4204659380548463995L;

	private final DTOAssistants assistants;
	private final DTOCity city;
	private final DTOPermissionCard card;
	
	public DTOChangeBuildEmporiumWithCard(DTOAssistants assistants, DTOCity city, DTOPermissionCard card){
		this.assistants=assistants;
		this.city=city;
		this.card=card;
	}

	public DTOAssistants getAssistants() {
		return assistants;
	}

	public DTOCity getCity() {
		return city;
	}

	public DTOPermissionCard getCard() {
		return card;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "You used "+assistants+" assistants and permission card number "+card+" to build an emporium in "+city;
	}
	
	
}
