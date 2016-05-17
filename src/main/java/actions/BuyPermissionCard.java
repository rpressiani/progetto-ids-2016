package actions;

import bonusable.PermissionCard;
import council.Balcony;
import gameState.GameState;
import map.Region;
import player.Player;
import politicalDeck.PoliticalCard;
import politicalDeck.PoliticalDeck;
import politicalDeck.PoliticalHand;

public class BuyPermissionCard extends MainAction {
	
	private Region region;
	private PoliticalDeck proposal;
	private int index;

	public BuyPermissionCard(Region region, PoliticalDeck proposal, int index) {
		this.region=region;
		this.proposal=proposal;
		this.index=index;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		int numCards, sumToPay, sumJolly;
		int size=player.getPoliticalHand().getDeck().size();
		PermissionCard drawedCard;
		
		if(checkProposal(proposal, region.getBalcony())==true){
			numCards=calculateNumCards(player.getPoliticalHand());
			
			if(numCards==1) sumToPay=10;
			else if(numCards==2) sumToPay=7;
			else if(numCards==3) sumToPay=4;
			else sumToPay=0;
			
			sumJolly=(player.getPoliticalHand().getDeck().get(size).getNumCards());
			sumToPay=sumToPay+sumJolly;
			
			if(sumToPay<=player.getCoins().getItems()) {
				player.getCoins().sub(sumToPay);
				drawedCard=region.getPermissionDeck().drawCard(region.getPermissionDeck().getDeck(), region.getPermissionDeck().getVisibleCards(), index);
				drawedCard.assignBonuses(player, gameState);
				player.getPermissionHand().add(drawedCard);
			}
		}
	}
	
	public boolean checkProposal(PoliticalDeck proposal, Balcony balcony){
		
		int sum=calculateNumCards(proposal);
		
		if (sum>=balcony.getnCounsellorsPerBalcony() && sum!=0) return false;
		
		else{
			for(int i=0; i<proposal.getDeck().size()-1; i++){
				if(proposal.getDeck().get(i).getNumCards() > balcony.getBalconyState().getState().get(i).getCounter()) return false;
			}
		}
		
		return true;
	}
	
	public int calculateNumCards(PoliticalDeck proposal){
		int sum=0;
		
		for(PoliticalCard card : proposal.getDeck()){
			sum=sum+card.getNumCards();
		}
		
		return sum;
	}
	
	public void subProposal(PoliticalHand hand, PoliticalDeck proposal){
		for(int i=0; i<hand.getDeck().size(); i++){
			hand.getDeck().get(i).removeCards(proposal.getDeck().get(i).getNumCards());
		}
	}
	
}
