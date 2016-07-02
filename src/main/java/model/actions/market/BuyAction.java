package model.actions.market;

import model.GameState;
import model.actions.GeneralAction;
import model.changes.ChangeMsg;
import model.market.Contract;
import model.market.Marketable;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;

public class BuyAction implements GeneralAction {

	private Contract contract;
	
	/**
	 * create the buy action
	 */
	public BuyAction() {
		
	}
	
	/**
	 * Constructor
	 * @param contract
	 * @throws NullPointerException if contract is null
	 */
	public BuyAction(Contract contract) {
		if(contract==null) {
			throw new NullPointerException(); 
		}
		this.contract=contract;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		gameState.getMarket().acceptContract(contract, player);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(contract==null){
			gameState.notifyObserver(player, new ChangeMsg(player.getNickname()+", the player you want to buy from has no contracts in the market or someone already accepted his contract"));
			return false;
		}
		
		Coins coins=null;
		for(Marketable m : contract.getSellBag()){
			if(m instanceof Coins){
				coins=(Coins) m;
			}
		}
		if(player.getCoins().getItems()<coins.getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough coins to accept this contract"));
			return false;
		}
		
		Assistants assistants=null;
		for(Marketable m : contract.getSellBag()){
			if(m instanceof Assistants){
				assistants=(Assistants) m;
			}
		}
		if(player.getAssistants().getItems()<assistants.getItems()){
			gameState.notifyObserver(player, new ChangeMsg("You don't have enough assistants to accept this contract"));
			return false;
		}
		
		return true;
	}

}
