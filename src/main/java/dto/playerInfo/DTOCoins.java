package dto.playerInfo;

import dto.DTOObject;

public class DTOCoins implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833978408071379439L;

	private final int quantity;
	
	public DTOCoins(int quantity){
		this.quantity=quantity;
	}

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
