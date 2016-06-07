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
	
	/**
	 * 
	 * @param assistants
	 * @param city
	 * @param card
	 * @throws NullPointerException if assistants/city/card are null
	 */
	public DTOChangeBuildEmporiumWithCard(DTOAssistants assistants, DTOCity city, DTOPermissionCard card){
		if(assistants==null || city==null || card==null){
			throw new NullPointerException("assistants or city or card can't be null");
		}
		this.assistants=assistants;
		this.city=city;
		this.card=card;
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
	 * @return the city
	 */
	public DTOCity getCity() {
		return city;
	}

	/**
	 * 
	 * @return the card
	 */
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
