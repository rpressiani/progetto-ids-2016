package dto.playerInfo;

import java.util.ArrayList;

import dto.DTOObject;
import dto.map.DTOCity;
import dto.utilities.DTOColor;
import dto.utilities.DTOPermissionCard;
import dto.utilities.DTOColorCounter;

public class DTOPlayerAdvanced extends DTOPlayer implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1086491797264924647L;
	
	private final DTOColorCounter politicalHand;
	private final ArrayList<DTOPermissionCard> permissionCards;
	private final ArrayList<DTOCity> builtCities;
	
	public DTOPlayerAdvanced(int serialID, String nickname, DTOColor color, DTOCoins coins, DTOAssistants assistants,
			DTONobilityLevel nobilityLevel, DTOScore score, DTOColorCounter politicalHand,
			ArrayList<DTOPermissionCard> permissionCards, ArrayList<DTOCity> builtCities) {
		
		super(serialID, nickname, color, coins, assistants, nobilityLevel, score);
		if(politicalHand==null) {
			throw new NullPointerException("politicalHand cannot be null"); 
		}
		if(permissionCards==null) {
			throw new NullPointerException("permissionCards cannot be null"); 
		}
		if(builtCities==null) {
			throw new NullPointerException("builtCities cannot be null"); 
		}
		this.politicalHand = politicalHand;
		this.permissionCards = permissionCards;
		this.builtCities = builtCities;
	}
	
	/**
	 * @return the politicalCards
	 */
	public DTOColorCounter getPoliticalHand() {
		return politicalHand;
	}

	/**
	 * @return the permissionCards
	 */
	public ArrayList<DTOPermissionCard> getPermissionCards() {
		return permissionCards;
	}

	/**
	 * @return the builtCities
	 */
	public ArrayList<DTOCity> getBuiltCities() {
		return builtCities;
	}

}
