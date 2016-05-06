package player;

/**
 * @author Riccardo Pressiani
 *
 */
public class Assistants extends SimpleItem {
	
	
	/**
	 * Subtract n-items from the total
	 * 
	 * @param	items						number of items to subtract
	 * @throws	IllegalArgumentException	if the argument is NOT greater than zero
	 */
	public void sub(Integer items){
		if (items < 0) throw new IllegalArgumentException("Argument must be greater than zero");
		this.setItems(Integer.sum(this.getItems(), -items));
		
	}

}
