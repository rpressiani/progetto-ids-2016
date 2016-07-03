package dto.changes;

import dto.playerInfo.DTOAssistants;
import dto.utilities.DTOColor;

public class DTOChangeElectCounsellorWithAssistant implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6947498374720846137L;

	private final DTOAssistants assistants;
	private final DTOColor color;
	
	/**
	 * @param assistants
	 * @param color
	 * @throws NullPointerException if assistants, color or region are null
	 */
	public DTOChangeElectCounsellorWithAssistant(DTOAssistants assistants, DTOColor color){
		if(assistants==null) {
			throw new NullPointerException("assistants cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}

		this.assistants=assistants;
		this.color=color;
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
	 * @return the color
	 */
	public DTOColor getColor() {
		return color;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "You used "+assistants+" assistants to elect a "+color+" counsellor";
	}

}
