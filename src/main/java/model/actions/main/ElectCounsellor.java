package model.actions.main;

import model.GameState;
import model.changes.ChangeElectCounsellor;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.council.Balcony;
import model.council.CounsellorGroup;
import model.player.Coins;
import model.player.Player;
import utilities.Color;

public class ElectCounsellor implements MainAction {
	
	private Balcony balcony;
	private Color color;
	
	/**
	 * @param balcony
	 * @param color
	 * @throws NullPointerException if region or color are null
	 */
	public ElectCounsellor(Balcony balcony, Color color) {
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		
		this.balcony=balcony;
		this.color=color;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		balcony.putCounsellor(color, gameState.getCounsellorGarbage());
		player.getCoins().add(4);
		
		gameState.notifyObserver(player, new ChangeElectCounsellor(new Coins(4), color));
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		CounsellorGroup el=null;
		
		for(int i=0; i<gameState.getCounsellorGarbage().getState().size(); i++){
			if(gameState.getCounsellorGarbage().getState().get(i).getColor().getStringID().equals(color.getStringID()))
				el=gameState.getCounsellorGarbage().getState().get(i);
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
