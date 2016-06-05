package model.actions.quick;

import model.GameState;
import model.changes.ChangeElectCounsellorWithAssistant;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.map.Region;
import model.player.Assistants;
import model.player.Player;
import utilities.Color;

public class ElectCounsellorWithAssistant implements QuickAction {
	
	/**
	 * @param region
	 * @param color
	 * @throws NullPointerException if region or color is null
	 */
	public ElectCounsellorWithAssistant(Region region, Color color) {
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null");
		}
		this.region = region;
		this.color = color;
	}

	private Region region;
	private Color color;
	
	@Override
	public void doAction(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		
		region.getBalcony().putCounsellor(color, gameState.getCounsellorGarbage());
		player.getAssistants().sub(1);
		
		gameState.notifyObserver(player, new ChangeElectCounsellorWithAssistant(new Assistants(1), color, region));
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		
		if(player.getAssistants().getItems()<1){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to elect a counsellor"));
			return false;
		}
		
		return true;
	}

}
