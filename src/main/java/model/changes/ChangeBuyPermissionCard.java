package model.changes;

import dto.changes.DTOChangeBuyPermissionCard;
import model.map.Region;
import model.player.Coins;
import view.VisitorChanges;

public class ChangeBuyPermissionCard implements Change {

	private Coins coins;
	private Region region;
	
	public ChangeBuyPermissionCard(Coins coins, Region region){
		this.coins=coins;
		this.region=region;
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
	
}
