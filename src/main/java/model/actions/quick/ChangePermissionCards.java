package model.actions.quick;

import model.GameState;
import model.map.Region;
import model.player.Player;

public class ChangePermissionCards implements QuickAction {

	private Region region;
	
	public ChangePermissionCards(Region region){
		this.region=region;
	}
	
	@Override
	public void doAction(Player player, GameState gameState){
			region.getPermissionDeck().substituteCards(region.getPermissionDeck().getDeck(), region.getPermissionDeck().getVisibleCards());
			player.getAssistants().sub(1);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(player.getAssistants().getItems()==0) return false;
		
		else return true;
	}

}
