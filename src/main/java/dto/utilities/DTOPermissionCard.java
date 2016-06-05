package dto.utilities;

import dto.DTOObject;

public class DTOPermissionCard implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4102612563103193760L;
	
	private final int idCard;
	
	public DTOPermissionCard(int idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the idCard
	 */
	public int getIdCard() {
		return idCard;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(idCard);
	}

	
}
