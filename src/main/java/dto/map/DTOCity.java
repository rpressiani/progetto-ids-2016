package dto.map;

import dto.DTOObject;

public class DTOCity implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2654644097065784285L;
	
	private final String name;
	
	/**
	 * @param name
	 * @throws NullPointerException if name is null
	 */
	public DTOCity(String name) {
		if(name==null) {
			throw new NullPointerException("name cannot be null"); 
		}
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
