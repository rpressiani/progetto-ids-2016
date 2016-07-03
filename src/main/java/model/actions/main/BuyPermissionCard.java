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
	
	/**
	 * @param region
	 * @param proposal
	 * @param index
	 * @throws NullPointerException if region, proposal are null
	 * @throws IllegalArgumentException if index <0
	 */
	public BuyPermissionCard(Region region, PoliticalContainer proposal, int index) {
		if(proposal==null) {
			throw new NullPointerException("proposal cannot be null"); 
		}
		
		this.region=region;
		this.proposal=proposal;
		this.index=index;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		int numCards, sumToPay, sumJolly;
		int size=player.getPoliticalHand().getDeck().size();
		sumJolly=proposal.getDeck().get(size-1).getNumCards();
		PermissionCard drawedCard;
		
		numCards=calculateNumCards(proposal);
		
		if(numCards==1) sumToPay=10;
		else if(numCards==2) sumToPay=7;
		else if(numCards==3) sumToPay=4;
		else sumToPay=0;
			
		sumToPay=sumToPay+sumJolly;
		
		player.getCoins().sub(sumToPay);
		subProposal(player.getPoliticalHand(), proposal);
		gameState.getGarbage().add(proposal);
		drawedCard=region.getPermissionDeck().drawCard(region.getPermissionDeck().getDeck(), region.getPermissionDeck().getVisibleCards(), index);
		player.getPermissionHand().add(drawedCard);
		
		gameState.notifyObserver(player, new ChangeBuyPermissionCard(new Coins(sumToPay), region, drawedCard));
		drawedCard.assignBonuses(player, gameState);
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
		gameState.getNobility().checkNobility(player, gameState);
	}
	
	/**
	 * 
	 * @param hand
	 * @param proposal
	 * @return
	 * throws NullPointerException if hand or proposal are null
	 */
	public boolean checkHand(PoliticalHand hand, PoliticalContainer proposal){
		if(hand==null) {
			throw new NullPointerException("hand cannot be null"); 
		}
		if(proposal==null) {
			throw new NullPointerException("proposal cannot be null"); 
		}
		
		for(int i=0; i<hand.getDeck().size(); i++){
			if(hand.getDeck().get(i).getNumCards()<proposal.getDeck().get(i).getNumCards()) return false;
		}
		
		return true;
	}
	
	/**
	 * @param proposal
	 * @param balcony
	 * @return true if proposal is ok
	 * @throws NullPointerException if proposal or balcony are null
	 */
	public boolean checkProposal(PoliticalContainer proposal, Balcony balcony) {
		if(proposal==null) {
			throw new NullPointerException("proposal cannot be null"); 
		}
		if(balcony==null) {
			throw new NullPointerException("balcony cannot be null"); 
		}
		
		int sum=calculateNumCards(proposal);
		
		if (sum>=balcony.getnCounsellorsPerBalcony() || sum==0) return false;
		
		for(int i=0; i<proposal.getDeck().size()-1; i++){
				if(proposal.getDeck().get(i).getNumCards() > balcony.getBalconyState().getState().get(i).getCounter()) 
					return false;
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

		if(region==null){
			gameState.notifyObserver(player, new ChangeMsg("The region you selected doesn't exist"));
			return false;
		}
		
		if(index!=0 && index!=1){
			gameState.notifyObserver(player, new ChangeMsg("You have to choose 0 or 1 as the index of permission card to buy"));
			return false;
		}
		
		if(this.proposal.getDeck().get(0).getNumCards() == -1) {
			gameState.notifyObserver(player, new ChangeMsg("Type 'help' to check the correct card proposal structure"));
			return false;
		}
		
		if(checkHand(player.getPoliticalHand(), proposal)==false){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough cards to make this proposal"));
			return false;
		}
		
		if(checkProposal(proposal, region.getBalcony())==false){
			gameState.notifyObserver(player, new ChangeMsg("Your proposal doesn't fit the state of balcony you chosed, try again"));
			return false;
		}
		
		
		int sumToPay;
		int size=player.getPoliticalHand().getDeck().size();
		int numCards=calculateNumCards(proposal);
		int sumJolly=proposal.getDeck().get(size-1).getNumCards();
		
		if(numCards==1) sumToPay=10;
		else if(numCards==2) sumToPay=7;
		else if(numCards==3) sumToPay=4;
		else sumToPay=0;
		
		sumToPay=sumToPay+sumJolly;
		
		if(sumToPay>player.getCoins().getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough coins to buy the card with this proposal"));
			return false;
		}
		
		return true;
	}
	
}
