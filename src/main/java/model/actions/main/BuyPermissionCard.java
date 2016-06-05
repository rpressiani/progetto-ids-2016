package model.actions.main;

import model.GameState;
import model.bonusable.PermissionCard;
import model.changes.ChangeBuyPermissionCard;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.council.Balcony;
import model.map.Region;
import model.player.Coins;
import model.player.Player;
import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalContainer;
import model.politicalDeck.PoliticalHand;

public class BuyPermissionCard implements MainAction {
	
	private Region region;
	private PoliticalContainer proposal;
	private int index;

	//temporary for ClientLogic
	public BuyPermissionCard(){
		
	}
	
	/**
	 * @param region
	 * @param proposal
	 * @param index
	 * @throws NullPointerException if region, proposal are null
	 * @throws IllegalArgumentException if index <0
	 */
	public BuyPermissionCard(Region region, PoliticalContainer proposal, int index) {
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		if(proposal==null) {
			throw new NullPointerException("proposal cannot be null"); 
		}
		if(index<0) {
			throw new IllegalArgumentException("index cannot be <0"); 
		}
		this.region=region;
		this.proposal=proposal;
		this.index=index;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		int numCards, sumToPay, sumJolly;
		int size=player.getPoliticalHand().getDeck().size();
		PermissionCard drawedCard;
		
		numCards=calculateNumCards(proposal);
		
		if(numCards==1) sumToPay=10;
		else if(numCards==2) sumToPay=7;
		else if(numCards==3) sumToPay=4;
		else sumToPay=0;
			
		sumJolly=(player.getPoliticalHand().getDeck().get(size).getNumCards());
		sumToPay=sumToPay+sumJolly;
			
		player.getCoins().sub(sumToPay);
		subProposal(player.getPoliticalHand(), proposal);
		drawedCard=region.getPermissionDeck().drawCard(region.getPermissionDeck().getDeck(), region.getPermissionDeck().getVisibleCards(), index);
		drawedCard.assignBonuses(player, gameState);
		player.getPermissionHand().add(drawedCard);
		
		gameState.notifyObserver(new ChangeBuyPermissionCard(new Coins(sumToPay), region));
		gameState.notifyObserver(new ChangePlayerStatus(player));
	}
	
	/**
	 * @param proposal
	 * @param balcony
	 * @return true if proposal is ok
	 * @throws NullPointerException if proposal or balcony are null
	 */
	public boolean checkProposal(PoliticalContainer proposal, Balcony balcony){
		if(proposal==null) {
			throw new NullPointerException("proposal cannot be null"); 
		}
		if(balcony==null) {
			throw new NullPointerException("balcony cannot be null"); 
		}
		
		int sum=calculateNumCards(proposal);
		
		if (sum>=balcony.getnCounsellorsPerBalcony() && sum!=0) return false;
		
		else{
			for(int i=0; i<proposal.getDeck().size()-1; i++){
				if(proposal.getDeck().get(i).getNumCards() > balcony.getBalconyState().getState().get(i).getCounter()) 
					return false;
			}
		}
		
		return true;
	}
	
	/**
	 * @param proposal
	 * @return number of the cards contained in PoliticalContainer
	 * @throws NullPointerException if proposal is null
	 */
	public int calculateNumCards(PoliticalContainer proposal){
		if(proposal==null) {
			throw new NullPointerException("proposal cannot be null"); 
		}
		int sum=0;
		
		for(PoliticalCard card : proposal.getDeck()){
			sum=sum+card.getNumCards();
		}
		
		return sum;
	}
	
	/**
	 * @param hand
	 * @param proposal
	 * @throws NullPointerException if hand or proposal are null
	 */
	public void subProposal(PoliticalHand hand, PoliticalContainer proposal){
		if(hand==null) {
			throw new NullPointerException("hand cannot be null"); 
		}
		if(proposal==null) {
			throw new NullPointerException("proposal cannot be null"); 
		}
		for(int i=0; i<hand.getDeck().size(); i++){
			hand.getDeck().get(i).removeCards(proposal.getDeck().get(i).getNumCards());
		}
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(index>1){
			gameState.notifyObserver(new ChangeMsg("You have to choose 0 or 1 as the index of permission card to buy"));
			return false;
		}
		
		if(checkProposal(proposal, region.getBalcony())==false){
			gameState.notifyObserver(new ChangeMsg("Your proposal doesn't fit the state of balcony you chosed, try again"));
			return false;
		}
		
		int sumToPay;
		int size=player.getPoliticalHand().getDeck().size();
		int numCards=calculateNumCards(proposal);
		int sumJolly=(player.getPoliticalHand().getDeck().get(size).getNumCards());
		
		if(numCards==1) sumToPay=10;
		else if(numCards==2) sumToPay=7;
		else if(numCards==3) sumToPay=4;
		else sumToPay=0;
		
		sumToPay=sumToPay+sumJolly;
		
		if(sumToPay>player.getCoins().getItems()){
			gameState.notifyObserver(new ChangeMsg("You don't have enough coins to buy the card with this proposal"));
			return false;
		}
		
		return true;
	}
	
}
