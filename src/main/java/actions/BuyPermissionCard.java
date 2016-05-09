package actions;

import council.BalconyState;
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
	
	public boolean checkProposal(PoliticalHand hand, BalconyState state){
		int sum;
		
		//for(PoliticalCard card : hand.getDeck())
		return false;
	}
	
	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	
	
}
