package bonusable;

import java.util.ArrayList;

import bonusItem.BonusItem;
import map.Region;

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
