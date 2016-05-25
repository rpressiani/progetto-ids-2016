package model.bonusable;

import java.util.ArrayList;

import model.bonusItem.BonusItem;
import model.map.Region;

public class RegionCard extends Bonusable {

	private Region region;
	
	/**
	 * create the region card
	 * @param bonuses can't be null
	 * @param region can't be null
	 * @throws NullPointerException if region if null
	 */
	public RegionCard(ArrayList<BonusItem> bonuses, Region region) {
		super(bonuses);
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		this.region=region;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}
	
}
