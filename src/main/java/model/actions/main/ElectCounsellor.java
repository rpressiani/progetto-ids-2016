package model.actions.main;

import model.GameState;
import model.changes.ChangeElectCounsellor;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.council.CounsellorGroup;
import model.map.Region;
import model.player.Coins;
import model.player.Player;
import utilities.Color;

public class ElectCounsellor implements MainAction {
	
	private Region region;
	private Color color;
	
	/**
	 * @param region
	 * @param color
	 * @throws NullPointerException if region or color are null
	 */
	public ElectCounsellor(Region region, Color color) {
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		
		this.region=region;
		this.color=color;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		region.getBalcony().putCounsellor(color, gameState.getCounsellorGarbage());
		player.getCoins().add(4);
		
		gameState.notifyObserver(player, new ChangeElectCounsellor(new Coins(4), color, region));
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		CounsellorGroup el=null;
		
		for(int i=0; i<gameState.getCounsellorGarbage().getState().size(); i++){
			if(gameState.getCounsellorGarbage().getState().get(i).getColor().getStringID().equals(color.getStringID()))
				el=gameState.getCounsellorGarbage().getState().get(i);
		}
		
		if(el==null){
			gameState.notifyObserver(player, new ChangeMsg("The colour you selected doesn't exist"));
			return false;
		}
		
		else{
			if(el.getCounter()==0){
				gameState.notifyObserver(player, new ChangeMsg("There aren't any counsellors of this colour"));
				return false;
			}
		}
		
		return true;
	}

}
