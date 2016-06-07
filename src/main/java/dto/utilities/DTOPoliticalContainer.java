package dto.utilities;

import java.util.ArrayList;

import dto.DTOObject;

public class DTOPoliticalContainer implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8648520283710676411L;
	
	private final ArrayList<Integer> structure;
	
	/**
	 * 
	 * @param structure
	 * @throws NullPointerException if structure==null
	 */
	public DTOPoliticalContainer(ArrayList<Integer> structure){
		if(structure==null) {
			throw new NullPointerException("structure passed can't be null"); 
		}
		this.structure=structure;
	}

	/**
	 * 
	 * @return the structure
	 */
	public ArrayList<Integer> getStructure() {
		return structure;
	}

}