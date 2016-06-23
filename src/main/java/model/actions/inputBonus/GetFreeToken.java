package model.actions.inputBonus;

import java.util.Set;

import model.GameState;
import model.bonusItem.BonusItem;
import model.bonusItem.BonusNobility;
import model.bonusItem.BonusToken;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.map.City;
import model.player.Player;

public class GetFreeToken implements InputBonusAction {

	private Set<City> citiesToChoose;
	
	public GetFreeToken(Set<City> citiesToChoose){
		this.citiesToChoose=citiesToChoose;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		
		player.setBonusChosed(true);
		player.getBonusInputs().remove(0);
		
		for(City c : citiesToChoose){
			c.assignBonuses(player, gameState);
		}
		
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
		gameState.getNobility().checkNobility(player, gameState);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(!(player.getBonusInputs().get(0) instanceof BonusToken)){
			gameState.notifyObserver(player, new ChangeMsg("It's no time to choose a bonus token to get"));
			return false;
		}
		
		for(City c : citiesToChoose){
			if(c==null){
				gameState.notifyObserver(player, new ChangeMsg("One or more cities you chosed don't exist"));
				return false;
			}
		}
		
		int i=((BonusToken)player.getBonusInputs().get(0)).getTokenToChoose();
		
		if(i!=citiesToChoose.size()){
			gameState.notifyObserver(player, new ChangeMsg("You have to choose the number of tokens indicated by the bonus you received"));
			return false;
		}
		
		for(City c : citiesToChoose){
			if(!player.getBuiltCities().contains(c)){
				gameState.notifyObserver(player, new ChangeMsg("You have to choose cities you have built an emporium in"));
				return false;
			}
		}
		
		for(City c : citiesToChoose){
			for(BonusItem b : c.getBonuses()){
				if(b instanceof BonusNobility){
					gameState.notifyObserver(player, new ChangeMsg("You have to choose tokens which don't contain a nobility bonus"));
					return false;
				}
			}
		}
		
		return true;
	}

}
