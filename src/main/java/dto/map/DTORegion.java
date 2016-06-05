package dto.map;

import dto.DTOObject;

public class DTORegion implements DTOObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3197025209267242803L;
	private final String name;
	
	/**
	 * @param name
	 * @throws NullPointerException if name is null
	 */
	public DTORegion(String name) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

	
}
