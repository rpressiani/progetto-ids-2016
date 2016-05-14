package player;

import market.Marketable;

/**
 * @author Riccardo Pressiani
 *
 */

public class Coins extends SimpleItem implements Marketable {
	
	/**
	 * Constructor
	 * Call SimpleItem constructor
	 */
	public Coins(){
		super();
	}
	
	public Coins(Integer coins) {
		if (coins < 0) throw new IllegalArgumentException("Argument must be greater than zero");
		this.items = coins;
	}
	
	
	/**
	 * Subtract n-items from the total
	 * 
	 * @param	items						number of items to subtract
	 * @throws	IllegalArgumentException	if the argument is NOT greater than zero
	 */
	public void sub(Integer items){
		if (items < 0) throw new IllegalArgumentException("Argument must be greater than zero");
		this.items = Integer.sum(this.getItems(), -items);
	}

	@Override
	public boolean verifyAdd(Player player) {
		if (Integer.compare(player.getCoins().getItems(), this.getItems()) < 0) return false;
		else return true;
		
	}

	@Override
	public void makeExchange(Player fromPlayer, Player toPlayer) {
		fromPlayer.getCoins().sub(this.getItems());
		toPlayer.getCoins().add(this.getItems());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coins [items=" + items + "]";
	}


}
