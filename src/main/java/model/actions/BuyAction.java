package model.actions;

import model.GameState;
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

}
