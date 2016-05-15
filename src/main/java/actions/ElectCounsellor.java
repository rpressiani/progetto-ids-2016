package actions;

import gameState.GameState;
import map.Region;
import player.Player;
import utilities.Color;

public class ElectCounsellor extends MainAction {
	
	private Region region;
	private Color color;
	
	public ElectCounsellor(Region region, Color color) {
		this.region=region;
		this.color=color;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		region.getBalcony().putCounsellor(color, gameState.getCounsellorGarbage());
		player.getCoins().add(4);
	}

}
