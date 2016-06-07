package dto.playerInfo;

import dto.DTOObject;

public class DTOAssistants implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -639695862716823885L;

	private final int quantity;
	
	/**
	 * @param quantity
	 * @throws IllegalArgumentException if quantity <0
	 */
	public DTOAssistants(int quantity) {
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
