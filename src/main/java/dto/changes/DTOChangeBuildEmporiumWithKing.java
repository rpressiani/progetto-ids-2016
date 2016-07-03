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
	
	/**
	 * 
	 * @param assistants
	 * @param coins
	 * @param city
	 * @throws NullPointerException if assistants/coins/city are null
	 */
	public DTOChangeBuildEmporiumWithKing(DTOAssistants assistants, DTOCoins coins, DTOCity city){
		if(assistants==null || coins==null || city==null){
			throw new NullPointerException("assistants or coins or city can't be null");
		}
		this.assistants=assistants;
		this.coins=coins;
		this.city=city;
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
	 * @return the coins
	 */
	public DTOCoins getCoins() {
		return coins;
	}

	/**
	 * 
	 * @return the city
	 */
	public DTOCity getCity() {
		return city;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Thanks to the help of king you built in "+city+", spending "+coins+" coins and using "+assistants+" assistants";
	}
	
	
}
