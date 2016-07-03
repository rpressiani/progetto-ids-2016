package model.changes;


import dto.changes.DTOChangeBuyPermissionCard;
import model.bonusable.PermissionCard;
import model.map.Region;
import model.player.Coins;
import view.VisitorChanges;

public class ChangeBuyPermissionCard implements Change {

	private Coins coins;
	private Region region;
	private PermissionCard card;
	
	/**
	 * @param coins
	 * @param region
	 * @param card
	 * @throws NullPointerException if one(or more) of the parameters are null
	 */
	public ChangeBuyPermissionCard(Coins coins, Region region, PermissionCard card) {
		if(coins==null) {
			throw new NullPointerException("coins cannot be null"); 
		}
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		this.coins=coins;
		this.region=region;
		this.card=card;
	}

	@Override
	public DTOChangeBuyPermissionCard accept(VisitorChanges v) {
		return v.visit(this);
	}

	/**
	 * @return the coins
	 */
	public Coins getCoins() {
		return coins;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @return the card
	 */
	public PermissionCard getCard() {
		return card;
	}

}
