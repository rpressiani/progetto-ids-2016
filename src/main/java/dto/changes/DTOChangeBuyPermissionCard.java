package dto.changes;

import dto.map.DTORegion;
import dto.playerInfo.DTOCoins;
import dto.utilities.DTOPermissionCardSelection;

public class DTOChangeBuyPermissionCard implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2994976216910264582L;

	private final DTOCoins coins;
	private final DTORegion region;
	private final DTOPermissionCardSelection card;
	
	/**
	 * 
	 * @param coins
	 * @param region
	 * @throws NullPointerException if coins/region are null
	 */
	public DTOChangeBuyPermissionCard(DTOCoins coins, DTORegion region, DTOPermissionCardSelection card){
		if(coins==null || region==null){
			throw new NullPointerException("coin or region can't be null");
		}
		this.coins=coins;
		this.region=region;
		this.card=card;
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
	 * @return the region
	 */
	public DTORegion getRegion() {
		return region;
	}

	public DTOPermissionCardSelection getCard() {
		return card;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Having used these cards, you spent "+coins+" coins to buy the permission card #"+card+" from "+region;
	}	
	
}
