package dto.utilities;

import java.util.ArrayList;

import dto.DTOObject;

public class DTOBalcony implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6170824103299743161L;
	
	private final ArrayList<DTOColor> balconyState;
	
	public DTOBalcony(ArrayList<DTOColor> balconyState) {
		if(balconyState==null) {
			throw new NullPointerException("balconyState cannot be null"); 
		}
		this.balconyState = balconyState;
	}

	/**
	 * @return the balconyState
	 */
	public ArrayList<DTOColor> getBalconyState() {
		return balconyState;
	}

}
