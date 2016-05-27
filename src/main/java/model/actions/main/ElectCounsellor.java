package model.actions.main;

import model.GameState;
import model.actions.MainAction;
import model.map.Region;
import model.player.Player;
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
