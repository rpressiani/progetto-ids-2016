package model.actions.main;

import model.GameState;
import model.map.Region;
import model.player.Player;
import utilities.Color;

public class ElectCounsellor implements MainAction {
	
	private Region region;
	private Color color;
	
	/**
	 * @param region
	 * @param color
	 * @throws NullPointerException if region or color are null
	 */
	public ElectCounsellor(Region region, Color color) {
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		this.region=region;
		this.color=color;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		region.getBalcony().putCounsellor(color, gameState.getCounsellorGarbage());
		player.getCoins().add(4);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		return true;
	}

}
