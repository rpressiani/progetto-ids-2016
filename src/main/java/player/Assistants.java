package player;

import market.Marketable;

/**
 * @author Riccardo Pressiani
 *
 */
public class Assistants extends SimpleItem implements Marketable {
	
	/**
	 * Constructor
	 * Call SimpleItem constructor
	 */
	public Assistants(){
		super();
	}
	
	public Assistants(Integer assistants){
		if (assistants < 0) throw new IllegalArgumentException("Argument must be greater than zero");
		this.items = assistants;
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
	public void makeExchange(Player fromPlayer, Player toPlayer) {
		fromPlayer.getCoins().sub(this.getItems());
		toPlayer.getCoins().add(this.getItems());
		
	}

	@Override
	public boolean verifyAdd(Player player) {
		if (Integer.compare(player.getAssistants().getItems(), this.getItems()) < 0) return false;
		else return true;
	}


}
