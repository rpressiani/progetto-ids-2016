package model.actions.main;

import model.GameState;
import model.changes.ChangeBuildEmporiumWithKing;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.council.Balcony;
import model.map.City;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalContainer;
import model.politicalDeck.PoliticalHand;

public class BuildEmporiumWithKing implements MainAction {
	
	private PoliticalContainer proposal;
	private City cityChosed;
	
	/**
	 * @param proposal
	 * @param cityChosed
	 */
	public BuildEmporiumWithKing(PoliticalContainer proposal, City cityChosed) {
		super();
		if(proposal==null) {
			throw new NullPointerException("proposal cannot be null"); 
		} 
		if(cityChosed==null) {
			throw new NullPointerException("cityChosed cannot be null"); 
		}
		this.proposal = proposal;
		this.cityChosed = cityChosed;
	}

	@Override
	public void doAction(Player player, GameState gameState) {
		if(player==null) {
			throw new NullPointerException("player cannot be null"); 
		}
		if(gameState==null) {
			throw new NullPointerException("gameState cannot be null"); 
		}
		int numCards, sumToPay, sumJolly, assistantsToPay;
		int size=player.getPoliticalHand().getDeck().size();
		
		numCards=calculateNumCards(proposal);
			
		if(numCards==1) sumToPay=10;
		else if(numCards==2) sumToPay=7;
		else if(numCards==3) sumToPay=4;
		else sumToPay=0;
			
		sumJolly=(player.getPoliticalHand().getDeck().get(size).getNumCards());
		sumToPay=sumToPay+sumJolly;
			
		sumToPay=sumToPay+2*gameState.getMap().numericDistance(gameState.getKing().getKingCity(), cityChosed);
		assistantsToPay=checkOtherEmporium(cityChosed, gameState);
					
		player.getCoins().sub(sumToPay);
		subProposal(player.getPoliticalHand(), proposal);
		player.getAssistants().sub(assistantsToPay);
		gameState.getKing().setKingCity(cityChosed);
		player.getBuiltCities().add(cityChosed);
					
		for(City c : cityChosed.linkedCities(gameState.getMap(), player)){
			c.assignBonuses(player, gameState);
		}
		
		gameState.notifyObserver(player, new ChangeBuildEmporiumWithKing(new Coins(sumToPay), new Assistants(assistantsToPay), cityChosed));
		gameState.notifyObserver(player, new ChangePlayerStatus(player));
		gameState.notifyObserver(new ChangeMsg("The king has been moved to "+cityChosed));
	}
	
	public boolean checkProposal(PoliticalContainer proposal, Balcony balcony){
		
		int sum=calculateNumCards(proposal);
		
		if (sum>=balcony.getnCounsellorsPerBalcony() && sum!=0) return false;
		
		else{
			for(int i=0; i<proposal.getDeck().size()-1; i++){
				if(proposal.getDeck().get(i).getNumCards() > balcony.getBalconyState().getState().get(i).getCounter()) return false;
			}
		}
		
		return true;
	}
	
	public int calculateNumCards(PoliticalContainer proposal){
		int sum=0;
		
		for(PoliticalCard card : proposal.getDeck()){
			sum=sum+card.getNumCards();
		}
		
		return sum;
	}
	
	public void subProposal(PoliticalHand hand, PoliticalContainer proposal){
		for(int i=0; i<hand.getDeck().size(); i++){
			hand.getDeck().get(i).removeCards(proposal.getDeck().get(i).getNumCards());
		}
	}
	
	public int checkOtherEmporium(City city, GameState gameState){
		int res=0;
		
		for(Player player : gameState.getPlayers()){
			if(player.getBuiltCities().contains(city)) res++;
		}
		
		return res;
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		
		if(this.proposal.getDeck().get(0).getNumCards() == -1) {
			gameState.notifyObserver(player, new ChangeMsg("Type 'help' to check the correct card proposal structure"));
			return false;
		}
		
		if(checkProposal(proposal, gameState.getKingBalcony())==false) return false;
		
		int sumToPay=0;
		int size=player.getPoliticalHand().getDeck().size();
		int numCards=calculateNumCards(proposal);
		int sumJolly=(player.getPoliticalHand().getDeck().get(size).getNumCards());
		
		if(numCards==1) sumToPay=10;
		else if(numCards==2) sumToPay=7;
		else if(numCards==3) sumToPay=4;
		
		sumToPay=sumToPay+sumJolly;
		
		if(sumToPay>player.getCoins().getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough coins to satisfy the king's balcony"));
			return false;
		}
		
		if(cityChosed.hasBuiltHere(player)==true){
			gameState.notifyObserver(player, new ChangeMsg("You already built an emporium in this city"));
			return false;
		}
		
		int assistantsToPay=checkOtherEmporium(cityChosed, gameState);
		
		if(assistantsToPay>player.getAssistants().getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to build in this city"));
			return false;
		}
		
		return true;
	}
}
