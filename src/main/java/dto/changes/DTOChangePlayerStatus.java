package dto.changes;

import dto.playerInfo.DTOAssistants;
import dto.playerInfo.DTOCoins;
import dto.playerInfo.DTONobilityLevel;
import dto.playerInfo.DTOScore;

public class DTOChangePlayerStatus implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7711372302722210237L;

	private final DTOCoins coins;
	private final DTOAssistants assistants;
	private final DTONobilityLevel nobilityLevel;
	private final DTOScore score;
	
	public DTOChangePlayerStatus(DTOCoins coins, DTOAssistants assistants, DTONobilityLevel nobilityLevel, DTOScore score){
		this.coins=coins;
		this.assistants=assistants;
		this.nobilityLevel=nobilityLevel;
		this.score=score;
	}

	public DTOCoins getCoins() {
		return coins;
	}

	public DTOAssistants getAssistants() {
		return assistants;
	}

	public DTONobilityLevel getNobilityLevel() {
		return nobilityLevel;
	}

	public DTOScore getScore() {
		return score;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Your current status is: \ncoins = " + coins + "\nassistants = " + assistants + "\nnobilityLevel = "
				+ nobilityLevel + "\nscore = " + score + "";
	}
	
	
}
