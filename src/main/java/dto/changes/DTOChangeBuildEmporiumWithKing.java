package dto.changes;

import dto.map.DTOCity;
import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;

public class DTOChangeBuildEmporiumWithKing implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4597153489792785978L;
	
	private final DTOAssistants assistants;
	private final DTOCoins coins;
	private final DTOCity city;
	
	public DTOChangeBuildEmporiumWithKing(DTOAssistants assistants, DTOCoins coins, DTOCity city){
		this.assistants=assistants;
		this.coins=coins;
		this.city=city;
	}

	public DTOAssistants getAssistants() {
		return assistants;
	}

	public DTOCoins getCoins() {
		return coins;
	}

	public DTOCity getCity() {
		return city;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Thanks to the help of king you built in "+city+", spending "+coins+" and using "+assistants+" assistants";
	}
	
	
}
