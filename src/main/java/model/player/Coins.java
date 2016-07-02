package model.player;

import model.market.Marketable;

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
	
	/**
	 * Constructor
	 * @param coins
	 * @throws NullPointerException if coins<0
	 */
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
	public void makeExchange(Marketable m, Player fromPlayer, Player toPlayer) {
		if(fromPlayer==null || toPlayer==null) {
			throw new NullPointerException("both these two players should not be null"); 
		}
		
		Coins coins=(Coins) m;
		
		fromPlayer.getCoins().sub(coins.getItems());
		toPlayer.getCoins().add(coins.getItems());
		
	}

}
