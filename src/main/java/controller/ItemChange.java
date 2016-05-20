package controller;

import model.player.SimpleItem;

public class ItemChange extends Change  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6239826156135704217L;
	private SimpleItem itemChange; 
	
	public ItemChange(SimpleItem itemChange) {
		this.itemChange = itemChange; 
	}
	public SimpleItem getItemChange() {
		return itemChange; 
	}
	@Override
	public String toString() {
		return "ItemChange [itemChange=" + itemChange + "]";
	}
	

}
