package dto.playerInfo;

import dto.DTOObject;

public class DTOCoins implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833978408071379439L;

	private final int quantity;
	
	/**
	 * @param quantity
	 * @throws IllegalArgumentException if quantity<0
	 */
	public DTOCoins(int quantity) {
		if(quantity<0) {
			throw new IllegalArgumentException("quantity must be >=0");
		}
		this.quantity=quantity;
	}

	/**
	 * 
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(this.getQuantity());
	}

}
