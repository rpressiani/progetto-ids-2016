package model.actions.market;

import java.util.Set;

import model.GameState;
import model.actions.GeneralAction;
import model.bonusable.PermissionCard;
import model.market.Contract;
import model.player.Player;

public class SellAction implements GeneralAction {

	private int sellCoins, buyCoins;
	private int sellAssistants, buyAssistants;
	private Set<PermissionCard> sellPermissionCards, buyPermissionCards;
	
	public SellAction(){
		
	}
	
	/**
	 * create the sell action
	 */
	public SellAction(int sellCoins, int sellAssistants, Set<PermissionCard> sellPermissionCards,
			int buyCoins, int buyAssistants, Set<PermissionCard> buyPermissionCards){
		this.sellCoins=sellCoins;
		this.sellAssistants=sellAssistants;
		this.sellPermissionCards=sellPermissionCards;
		this.buyCoins=buyCoins;
		this.buyAssistants=buyAssistants;
		this.buyPermissionCards=buyPermissionCards;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		
		Contract contract=new Contract(player);
		
		contract.sellCoins(sellCoins);
		contract.sellAssistants(sellAssistants);
		for(PermissionCard card : sellPermissionCards){
			contract.sellPermissionCard(card);
		}
		
		contract.buyCoins(buyCoins);
		contract.buyAssistants(buyAssistants);
		for(PermissionCard card : buyPermissionCards){
			contract.buyPermissionCard(card);
		}
		
		gameState.getMarket().addContract(contract);
		
	}

}
