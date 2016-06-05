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
	
	/**
	 * @param assistants
	 * @param coins
	 * @throws NullPointerException if assistants or coins are null
	 */
	public DTOChangeHireAssistants(DTOAssistants assistants, DTOCoins coins) {
		if(assistants==null) {
			throw new NullPointerException("assistants cannot be null"); 
		}
		if(coins==null) {
			throw new NullPointerException("coins cannot be null"); 
		}
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
