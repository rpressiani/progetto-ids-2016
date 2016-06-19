package dto.changes;

import dto.map.DTORegion;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOColor;

public class DTOChangeElectCounsellor implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = -164544571255023350L;

	private final DTOCoins coins;
	private final DTOColor color;
	private final DTORegion region;
	
	/**
	 * @param coins
	 * @param color
	 * @param region
	 * @throws NullPointerException if coins, color or region are null
	 */
	public DTOChangeElectCounsellor(DTOCoins coins, DTOColor color, DTORegion region){
		if(coins==null) {
			throw new NullPointerException("coins cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		this.coins=coins;
		this.color=color;
		this.region=region;
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

	/**
	 * 
	 * @return the region
	 */
	public DTORegion getRegion() {
		return region;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "You gained "+coins+" coins for having elected a "+color+" counsellor in "+region+"'s balcony";
	}

}
