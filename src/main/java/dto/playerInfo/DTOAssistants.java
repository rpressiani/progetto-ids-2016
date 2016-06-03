package dto.playerInfo;

import dto.DTOObject;

public class DTOAssistants implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -639695862716823885L;

	private final int quantity;
	
	public DTOAssistants(int quantity){
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
