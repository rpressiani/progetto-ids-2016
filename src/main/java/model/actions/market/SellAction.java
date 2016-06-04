package model.actions.market;

import java.util.ArrayList;
import java.util.Set;

import model.GameState;
import model.actions.GeneralAction;
import model.bonusable.PermissionCard;
import model.market.Contract;
import model.player.Player;

public class SellAction implements GeneralAction {

	private int sellCoins, buyCoins;
	private int sellAssistants, buyAssistants;
	private Set<PermissionCard> sellPermissions, buyPermissions;
	private ArrayList<Integer> sellPoliticals, buyPoliticals;
	
	public SellAction(){
		
	}
	
	/**
	 * create the sell action
	 */
	public SellAction(int sellCoins, int sellAssistants, Set<PermissionCard> sellPermissions, ArrayList<Integer> sellPoliticals,
			int buyCoins, int buyAssistants, Set<PermissionCard> buyPermissions, ArrayList<Integer> buyPoliticals){
		this.sellCoins=sellCoins;
		this.sellAssistants=sellAssistants;
		this.sellPermissions=sellPermissions;
		this.sellPoliticals=sellPoliticals;
		
		this.buyCoins=buyCoins;
		this.buyAssistants=buyAssistants;
		this.buyPermissions=buyPermissions;
		this.buyPoliticals=buyPoliticals;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		
		Contract contract=new Contract(player);
		
		contract.sellCoins(sellCoins);
		contract.sellAssistants(sellAssistants);
		for(PermissionCard card : sellPermissions){
			contract.sellPermissionCard(card);
		}
		contract.sellPoliticalCards(sellPoliticals);
		
		contract.buyCoins(buyCoins);
		contract.buyAssistants(buyAssistants);
		for(PermissionCard card : buyPermissions){
			contract.buyPermissionCard(card);
		}
		contract.buyPoliticalCards(buyPoliticals);
		
		gameState.getMarket().addContract(contract);
		
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		// TODO Auto-generated method stub
		return true;
	}

}
