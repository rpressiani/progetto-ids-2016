package model.bonusable;

import java.util.ArrayList;

import model.bonusItem.BonusItem;
import model.map.Region;

public class RegionCard extends Bonusable {

	private Region region;
	
	public RegionCard(ArrayList<BonusItem> bonuses, Region region) {
		super(bonuses);
		this.region=region;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}
	
}
