package controller.changes;

import model.player.Coins;

public class CoinsChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2302334949255472831L;
	private Coins newAmountofCoins; 
	
	public CoinsChange(Coins newAmountOfCoins) {
		super(); 
	}
	public Coins getAmount() {
		return newAmountofCoins; 
	}
	@Override
	public String toString() {
		return "CoinsChange [newAmountofCoins=" + newAmountofCoins + "]";
	}
	
	

}
