package dto.playerInfo;

import dto.DTOObject;
import dto.utilities.DTOColor;
import dto.utilities.DTOPoliticalHand;

public class DTOPlayerAdvanced extends DTOPlayer implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1086491797264924647L;
	
	private final DTOPoliticalHand politicalHand;
	
	public DTOPlayerAdvanced(int serialID, String nickname, DTOColor color, DTOCoins coins, DTOAssistants assistants,
			DTONobilityLevel nobilityLevel, DTOScore score, DTOPoliticalHand politicalHand) {
		
		super(serialID, nickname, color, coins, assistants, nobilityLevel, score);
		
		this.politicalHand = politicalHand;
	}
	
	/**
	 * @return the politicalCards
	 */
	public DTOPoliticalHand getPoliticalHand() {
		return politicalHand;
	}

}
