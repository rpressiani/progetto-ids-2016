package actions;

import gameState.GameState;
import map.Region;
import player.Player;
import utilities.Color;

public class ElectCounsellorWithAssistant extends SecondaryAction {
	
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
