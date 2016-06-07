package dto.utilities;

import dto.DTOObject;

public class DTOColor implements DTOObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4725332874694722062L;
	private final String colorString;
	
	/**
	 * 
	 * @param colorString
	 * @throws NullPointerException
	 */
	public DTOColor(String colorString) {
		if(colorString==null){
			throw new NullPointerException("colorString can't be null");
		}
		this.colorString = colorString;
	}

	/**
	 * @return the colorString
	 */
	public String getColorString() {
		return colorString;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return colorString;
	}

	
}
