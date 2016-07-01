package model.bonusItem;

import model.GameState;
import model.changes.ChangeMsg;
import model.map.City;
import model.player.Player;

public class BonusToken implements BonusInputItem {

	private int tokenToChoose;
	
	/**
	 * @param tokenToChoose
	 * @throws IllegalArgumentException if tokenToChoose<0
	 */
	public BonusToken(int tokenToChoose) {
		if(tokenToChoose<0) {
			throw new IllegalArgumentException("tokenToChoose cannot be null");			
		}
		this.tokenToChoose=tokenToChoose;
	}

	@Override
	public void giveBonus(Player player, GameState gameState) {
		int count=0;
		
		for(City c : player.getBuiltCities()){
			for(BonusItem b : c.getBonuses()){
				if(b instanceof BonusNobility) count++;
			}
		}
		
		if(player.getBuiltCities().isEmpty()){
			gameState.notifyObserver(player, new ChangeMsg("You got a bonus token, but you haven't built any emporiums yet, sorry"));
		}
		
		else if(count<=player.getBuiltCities().size()-this.getTokenToChoose()){
				player.getBonusInputs().add(this);
				gameState.notifyObserver(player, new ChangeMsg("Congratulations, you can get bonuses of "+tokenToChoose+" token among cities you have built an emporium in"));
		}
		
		else gameState.notifyObserver(player, new ChangeMsg("You got a bonus token, but all the cities you have built in have a nobility bonus on their token, sorry"));
	}
	
	public int getTokenToChoose() {
		return tokenToChoose;
	}

}
