package model.player;

import model.market.Marketable;

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
	
	/**
	 * Constructor
	 * @param assistants
	 * @throws IllegalArgumentException if assistants <0 
	 */
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
	public void makeExchange(Marketable m, Player fromPlayer, Player toPlayer) {
		if(fromPlayer==null || toPlayer==null) {
			throw new NullPointerException("both these two players should not be null"); 
		}
		
		Assistants assistants=(Assistants) m;
		
		fromPlayer.getAssistants().sub(assistants.getItems());
		toPlayer.getAssistants().add(assistants.getItems());	
	
	}

}
