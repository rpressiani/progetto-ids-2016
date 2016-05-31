package model.actions.quick;

import model.GameState;
import model.map.Region;
import model.player.Player;

public class ChangePermissionCards extends QuickAction {

	private Region region;
	
	public ChangePermissionCards(Region region){
		this.region=region;
	}
	
	public void doAction(Player player, GameState gameState){
		if(player.getAssistants().getItems()>=1){
			region.getPermissionDeck().substituteCards(region.getPermissionDeck().getDeck(), region.getPermissionDeck().getVisibleCards());
			player.getAssistants().sub(1);
		}
	}

}
