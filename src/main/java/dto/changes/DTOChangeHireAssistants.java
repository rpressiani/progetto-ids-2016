package dto.changes;

import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;

public class DTOChangeHireAssistants implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4954364611118497515L;

	private final DTOAssistants assistants;
	private final DTOCoins coins;
	
	public DTOChangeHireAssistants(DTOAssistants assistants, DTOCoins coins){
		this.assistants=assistants;
		this.coins=coins;
	}

	public DTOAssistants getAssistants() {
		return assistants;
	}

	public DTOCoins getCoins() {
		return coins;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "You gained "+assistants+" assistants and spent "+coins+" coins";
	}
}
