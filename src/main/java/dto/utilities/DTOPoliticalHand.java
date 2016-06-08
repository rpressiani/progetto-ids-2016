package dto.utilities;

import java.util.Map;

import dto.DTOObject;

public class DTOPoliticalHand implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1547245534944554302L;
	
	private final Map<DTOColor, Integer> structure;
	
	public DTOPoliticalHand(Map<DTOColor, Integer> structure) {
		this.structure = structure;
	}

	/**
	 * @return the politicalHand
	 */
	public Map<DTOColor, Integer> getStructure() {
		return structure;
	}

}
