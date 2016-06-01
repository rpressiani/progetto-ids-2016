package dto.utilities;

import java.util.ArrayList;

import dto.DTOObject;

public class DTOPoliticalContainer implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8648520283710676411L;
	
	private final ArrayList<Integer> structure;
	
	public DTOPoliticalContainer(ArrayList<Integer> structure){
		this.structure=structure;
	}

	public ArrayList<Integer> getStructure() {
		return structure;
	}

}