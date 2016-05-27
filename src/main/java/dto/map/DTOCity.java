package dto.map;

import dto.DTOObject;

public class DTOCity implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2654644097065784285L;
	
	private final String name;
	
	public DTOCity(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
