package model.actions.quick;

import model.GameState;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.changes.ChangeSubstitutePermissionCards;
import model.map.Region;
import model.player.Assistants;
import model.player.Player;

public class SubstitutePermissionCards implements QuickAction {

	private Region region;
	
	/**
	 * @param region
	 */
	public SubstitutePermissionCards(Region region) {
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
		
		gameState.notifyObserver(player, new ChangeSubstitutePermissionCards(new Assistants(1), region));
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		
		if(region==null){
			gameState.notifyObserver(player, new ChangeMsg("The region you selected doesn't exist"));
			return false;
		}
		
		if(player.getAssistants().getItems()<1){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to substitute permission cards"));
			return false;
		}
		
		return true;
	}

}
