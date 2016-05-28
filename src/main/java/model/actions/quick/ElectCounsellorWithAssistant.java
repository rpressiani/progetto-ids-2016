package model.actions.quick;

import model.GameState;
import model.actions.QuickAction;
import model.map.Region;
import model.player.Player;
import utilities.Color;

public class ElectCounsellorWithAssistant extends QuickAction {
	
	public ElectCounsellorWithAssistant(Region region, Color color) {
		this.region = region;
		this.color = color;
	}

	private Region region;
	private Color color;
	
	public void doAction(Player player, GameState gameState) {
		if(player.getAssistants().getItems()>=1) 
			region.getBalcony().putCounsellor(color, gameState.getCounsellorGarbage());
		
		player.getAssistants().sub(1);
	}

}
