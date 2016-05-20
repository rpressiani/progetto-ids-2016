package model.player;


/**
 * @author Riccardo Pressiani
 *
 */
public abstract class SimpleItem {
	
	Integer items;
	
	/**
	 * Constructor
	 * Set items to zero.
	 */
	public SimpleItem(){
		this.items = 0;
	}
	
	
	/**
	 * Add n-items to the total
	 * 
	 * @param	items						number of items to add
	 * @throws	IllegalArgumentException	if the argument is NOT greater than zero
	 */
	public void add(Integer items){
		if (items < 0) throw new IllegalArgumentException("Argument must be greater than zero");
		this.items = Integer.sum(this.items, items);
		
	}

	/**
	 * @return the items
	 */
	public Integer getItems() {
		return items;
	}
	
	

//	/**
//	 * @param items	number of items to set
//	 */
//	void setItems(Integer items) {
//		this.items = items;
//	}

}
