package model.actions.market;

import model.GameState;
import model.actions.GeneralAction;
import model.changes.ChangeFail;
import model.market.Contract;
import model.player.Player;

public class BuyAction implements GeneralAction {

	private Contract contract;
	
	/**
	 * create the buy action
	 */
	public BuyAction() {
		
	}
	
	public BuyAction(Contract contract){
		this.contract=contract;
	}
	
	@Override
	public void doAction(Player player, GameState gameState) {
		gameState.getMarket().acceptContract(contract, player);
	}

	@Override
	public boolean checkCondition(Player player, GameState gameState) {
		if(contract==null){
			gameState.notifyObserver(new ChangeFail(player.getNickname()+", the player you want to buy from has no contracts in the market"));
			return false;
		}
		
		return true;
	}

}
