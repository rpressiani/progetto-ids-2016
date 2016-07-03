package model.actions.quick;

import model.GameState;
import model.changes.ChangeElectCounsellorWithAssistant;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.council.Balcony;
import model.council.CounsellorGroup;
import model.player.Assistants;
import model.player.Player;
import utilities.Color;

public class ElectCounsellorWithAssistant implements QuickAction {
	
	private Balcony balcony;
	private Color color;
	
	/**
	 * @param balcony
	 * @param color
	 * @throws NullPointerException if region or color is null
	 */
	public ElectCounsellorWithAssistant(Balcony balcony, Color color) {
		if(color==null) {
			throw new NullPointerException("color cannot be null");
		}
		this.balcony = balcony;
		this.color = color;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		
		balcony.putCounsellor(color, gameState.getCounsellorGarbage());
		player.getAssistants().sub(1);
		
		gameState.notifyObserver(player, new ChangeElectCounsellorWithAssistant(new Assistants(1), color));
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		CounsellorGroup el=null;
		
		for(int i=0; i<gameState.getCounsellorGarbage().getState().size(); i++){
			if(gameState.getCounsellorGarbage().getState().get(i).getColor().getStringID().equals(color.getStringID()))
				el=gameState.getCounsellorGarbage().getState().get(i);
		}
		
		if(player.getAssistants().getItems()<1){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to elect a counsellor"));
			return false;
		}
		
		if(balcony==null){
			gameState.notifyObserver(player, new ChangeMsg("The region you selected doesn't exist"));
			return false;
		}
		
		if(el==null){
			gameState.notifyObserver(player, new ChangeMsg("The colour you selected doesn't exist"));
			return false;
		}
		
		else if(el.getCounter()==0){
				gameState.notifyObserver(player, new ChangeMsg("There aren't any counsellors of this colour"));
				return false;
			
		}
		
		return true;
	}

}
