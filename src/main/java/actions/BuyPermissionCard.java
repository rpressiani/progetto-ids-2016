package actions;

import council.Balcony;
import gameState.GameState;
import map.Region;
import player.Player;
import politicalDeck.PoliticalCard;
import politicalDeck.PoliticalHand;

public class BuyPermissionCard extends PrimaryAction {
	
	private Region region;
	
	@Override
	public void doAction(Player player, GameState gameState) {
	
	}
	
	public boolean checkProposal(PoliticalHand hand, Balcony balcony){
		int sum=0;
		
		for(PoliticalCard card : hand.getDeck()){
			sum=sum+card.getNumCards();
		}
		
		if (sum>=balcony.getnCounsellorsPerBalcony()) return false;
		else return true;
	}
	
	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	
	
}
