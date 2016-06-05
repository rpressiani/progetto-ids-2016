package dto.utilities;

import dto.DTOObject;

public class DTOPermissionCard implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4102612563103193760L;
	
	private final int idCard;
	
	/**
	 * @param idCard
	 * @throws IllegalArgumentException if idCard<0
	 */
	public DTOPermissionCard(int idCard) {
		if(idCard<0) {
			throw new IllegalArgumentException("idCard must be >=0"); 
		}
		this.idCard = idCard;
	}

	/**
	 * @return the idCard
	 */
	public int getIdCard() {
		return idCard;
	}

}
