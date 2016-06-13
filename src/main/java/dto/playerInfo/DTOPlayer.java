package dto.playerInfo;

import dto.DTOObject;
import dto.utilities.DTOColor;

public class DTOPlayer extends DTOPlayerBasic implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1502123848556511187L;
	
	private final DTOCoins coins;
	private final DTOAssistants assistants;
	private final DTONobilityLevel nobilityLevel;
	private final DTOScore score;
	
	/**
	 * @param serialID
	 * @param nickname
	 * @param color
	 * @param coins
	 * @param assistants
	 * @param nobilityLevel
	 * @param score
	 */
	public DTOPlayer(int serialID, String nickname, DTOColor color, DTOCoins coins, DTOAssistants assistants,
			DTONobilityLevel nobilityLevel, DTOScore score) {
		
		super(serialID, nickname, color);
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
		this.coins = coins;
		this.assistants = assistants;
		this.nobilityLevel = nobilityLevel;
		this.score = score;
	}
	
	/**
	 * @return the coins
	 */
	public DTOCoins getCoins() {
		return coins;
	}

	/**
	 * @return the assistants
	 */
	public DTOAssistants getAssistants() {
		return assistants;
	}

	/**
	 * @return the nobilityLevel
	 */
	public DTONobilityLevel getNobilityLevel() {
		return nobilityLevel;
	}

	/**
	 * @return the score
	 */
	public DTOScore getScore() {
		return score;
	}

}
