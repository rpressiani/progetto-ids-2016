package model.actions.quick;

import model.GameState;
import model.map.Region;
import model.player.Player;
import utilities.Color;

public class ElectCounsellorWithAssistant implements QuickAction {
	
	public ElectCounsellorWithAssistant(Region region, Color color) {
		this.region = region;
		this.color = color;
	}

	private Region region;
	private Color color;
	
	@Override
	public void doAction(Player player, GameState gameState) {
		region.getBalcony().putCounsellor(color, gameState.getCounsellorGarbage());
		player.getAssistants().sub(1);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(player.getAssistants().getItems()==0) return false;
		
		else return true;
	}

}
