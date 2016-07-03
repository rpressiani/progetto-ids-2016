package dto.changes;

import dto.playerInfo.DTOCoins;
import dto.utilities.DTOColor;

public class DTOChangeElectCounsellor implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = -164544571255023350L;

	private final DTOCoins coins;
	private final DTOColor color;
	
	/**
	 * @param coins
	 * @param color
	 * @throws NullPointerException if coins, color or region are null
	 */
	public DTOChangeElectCounsellor(DTOCoins coins, DTOColor color){
		if(coins==null) {
			throw new NullPointerException("coins cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
	
		this.coins=coins;
		this.color=color;
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
		return "You gained "+coins+" coins for having elected a "+color+" counsellor";
	}

}
