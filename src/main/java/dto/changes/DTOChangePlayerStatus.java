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
	
	/**
	 * @param coins
	 * @param assistants
	 * @param nobilityLevel
	 * @param score
	 * @throws NullPointerException if coins, assistants, nobilityLevel or score are null
	 */
	public DTOChangePlayerStatus(DTOCoins coins, DTOAssistants assistants, DTONobilityLevel nobilityLevel, DTOScore score){
		if(coins==null) {
			throw new NullPointerException("coins cannot be null"); 
		}
		if(assistants==null) {
			throw new NullPointerException("assistants cannot be null"); 
		}
		if(nobilityLevel==null) {
			throw new NullPointerException("nobilityLevel cannot be null"); 
		}
		if(score==null) {
			throw new NullPointerException("score cannot be null"); 
		}
		this.coins=coins;
		this.assistants=assistants;
		this.nobilityLevel=nobilityLevel;
		this.score=score;
	}

	/**
	 * 
	 * @return the coins
	 */
	public DTOCoins getCoins() {
		return coins;
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
	 * @return the  nobilityLevel
	 */
	public DTONobilityLevel getNobilityLevel() {
		return nobilityLevel;
	}

	/**
	 * 
	 * @return the score
	 */
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
