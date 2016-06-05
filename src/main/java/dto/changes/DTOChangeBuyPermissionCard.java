package dto.changes;

import dto.map.DTORegion;
import dto.playerInfo.DTOCoins;

public class DTOChangeBuyPermissionCard implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2994976216910264582L;

	private final DTOCoins coins;
	private final DTORegion region;
	
	public DTOChangeBuyPermissionCard(DTOCoins coins, DTORegion region){
		this.coins=coins;
		this.region=region;
	}

	public DTOCoins getCoins() {
		return coins;
	}

	public DTORegion getRegion() {
		return region;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Having used these cards, you spent "+coins+" coins to buy a permission card from "+region;
	}
	
	
}
