package model.actions.market;

import model.GameState;
import model.actions.GeneralAction;
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
		// TODO Auto-generated method stub
		return true;
	}

}
