package model.changes;

import dto.changes.DTOChangeElectCounsellor;
import model.map.Region;
import model.player.Coins;
import utilities.Color;
import view.VisitorChanges;

public class ChangeElectCounsellor implements Change {

	private Coins coins;
	private Color color;
	private Region region;
	
	public ChangeElectCounsellor(Coins coins, Color color, Region region) {
		this.coins=coins;
		this.color=color;
		this.region=region;
	}
	
	@Override
	public DTOChangeElectCounsellor accept(VisitorChanges v) {
		return v.visit(this);
	}

	/**
	 * @return the coins
	 */
	public Coins getCoins() {
		return coins;
	}
	
	/**
	 * @return the colorAssistant
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

}
