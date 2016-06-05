package dto.map;

import dto.DTOObject;

public class DTORegion implements DTOObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3197025209267242803L;
	private final String name;
	
	public DTORegion(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

	
}
