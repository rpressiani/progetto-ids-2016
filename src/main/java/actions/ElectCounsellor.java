package actions;

import gameState.GameState;
import map.Region;
import player.Player;

public class ElectCounsellor extends PrimaryAction {
	
	private Region region;
	
	@Override
	public void doAction(Player player, GameState gameState) {
		
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	
	

}
