package model.actions.market;

import java.util.ArrayList;
import java.util.Set;

import model.GameState;
import model.actions.GeneralAction;
import model.bonusable.PermissionCard;
import model.market.Contract;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;

public class SellAction implements GeneralAction {

	private int sellCoins, buyCoins;
	private int sellAssistants, buyAssistants;
	private Set<PermissionCard> sellPermissionCards, buyPermissionCards;
	private ArrayList<Integer> sellPoliticals, buyPoliticals;
	
	public SellAction(){
		
	}
	
	/**
	 * create the sell action
	 */
	public SellAction(int sellCoins, int sellAssistants, Set<PermissionCard> sellPermissionCards, ArrayList<Integer> sellPoliticals,
			int buyCoins, int buyAssistants, Set<PermissionCard> buyPermissionCards, ArrayList<Integer> buyPoliticals){
		this.sellCoins=sellCoins;
		this.sellAssistants=sellAssistants;
		this.sellPermissionCards=sellPermissionCards;
		this.sellPoliticals=sellPoliticals;
		this.buyCoins=buyCoins;
		this.buyAssistants=buyAssistants;
		this.buyPermissionCards=buyPermissionCards;
		this.buyPoliticals=buyPoliticals;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		
		Contract contract=new Contract(player);
		
		contract.sellCoins(sellCoins);
		contract.sellAssistants(sellAssistants);
		for(PermissionCard card : sellPermissionCards){
			contract.sellPermissionCard(card);
		}
		contract.sellPoliticalCards(sellPoliticals);
		
		contract.buyCoins(buyCoins);
		contract.buyAssistants(buyAssistants);
		for(PermissionCard card : buyPermissionCards){
			contract.buyPermissionCard(card);
		}
		contract.buyPoliticalCards(buyPoliticals);
		
		gameState.getMarket().addContract(contract);
		
	}

}
