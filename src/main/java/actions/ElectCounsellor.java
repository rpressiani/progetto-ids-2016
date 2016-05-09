package actions;

import gameState.GameState;
import map.Region;
import player.Player;
import utilities.Color;

public class ElectCounsellor extends PrimaryAction {
	
	private Region region;
	private Color color;
	
	@Override
	public void doAction(Player player, GameState gameState) {
		region.getBalcony().putCounsellor(color, gameState.getCounsellorGarbage());
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
}
