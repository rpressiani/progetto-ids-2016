package model.actions.quick;

import model.GameState;
import model.map.Region;
import model.player.Player;

public class ChangePermissionCards implements QuickAction {

	private Region region;
	
	/**
	 * @param region
	 * @throws NullPointerException if region is null
	 */
	public ChangePermissionCards(Region region) {
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		this.region=region;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		region.getPermissionDeck().substituteCards(region.getPermissionDeck().getDeck(), region.getPermissionDeck().getVisibleCards());
		player.getAssistants().sub(1);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(player.getAssistants().getItems()==0) return false;
		
		else return true;
	}

}
