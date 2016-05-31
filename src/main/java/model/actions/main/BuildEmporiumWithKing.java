package model.actions.main;

import model.GameState;
import model.council.Balcony;
import model.map.City;
import model.player.Player;
import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalContainer;
import model.politicalDeck.PoliticalDeck;
import model.politicalDeck.PoliticalHand;

public class BuildEmporiumWithKing extends MainAction {
	
	private PoliticalDeck proposal;
	private City cityChosed;
	
	public BuildEmporiumWithKing(PoliticalContainer proposal, City cityChosed) {
		super();
		this.proposal = proposal;
		this.cityChosed = cityChosed;
	}

	@Override
	public void doAction(Player player, GameState gameState) {
		
		int numCards, sumToPay, sumJolly, assistantsToPay;
		int size=player.getPoliticalHand().getDeck().size();
		
		if(checkProposal(proposal, gameState.getKingBalcony())==true){
			numCards=calculateNumCards(player.getPoliticalHand());
			
			if(numCards==1) sumToPay=10;
			else if(numCards==2) sumToPay=7;
			else if(numCards==3) sumToPay=4;
			else sumToPay=0;
			
			sumJolly=(player.getPoliticalHand().getDeck().get(size).getNumCards());
			sumToPay=sumToPay+sumJolly;
			
			sumToPay=sumToPay+2*gameState.getMap().numericDistance(gameState.getKing().getKingCity(), cityChosed);
			assistantsToPay=checkOtherEmporium(cityChosed, gameState);
			
			if(sumToPay<=player.getCoins().getItems() &&
				cityChosed.hasBuiltHere(player)==false &&
				assistantsToPay<=player.getAssistants().getItems()){
					
					player.getCoins().sub(sumToPay);
					gameState.getKing().setKingCity(cityChosed);
					player.getBuiltCities().add(cityChosed);
					
					for(City c : cityChosed.linkedCities(gameState.getMap(), player)){
						c.assignBonuses(player, gameState);
					}
			}
		}
		
		
		if(cityChosed.hasBuiltHere(player)==false) player.getBuiltCities().add(cityChosed);
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
	
	public int checkOtherEmporium(City city, GameState gameState){
		int res=0;
		
		for(Player player : gameState.getPlayers()){
			if(player.getBuiltCities().contains(city)) res++;
		}
		
		return res;
	}
}
