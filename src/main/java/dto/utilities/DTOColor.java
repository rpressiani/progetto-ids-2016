package dto.utilities;

import dto.DTOObject;

public class DTOColor implements DTOObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4725332874694722062L;
	private final String colorString;
	
	public DTOColor(String colorString) {
		this.colorString = colorString;
	}

	/**
	 * @return the colorString
	 */
	public String getColorString() {
		return colorString;
	}

}
