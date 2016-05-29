/**
 * 
 */
package model.council;

import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class Counsellor {
	
	private Color color;
	
	/**
	 * @param color
	 * @throws NullPointerException if color is null
	 */
	public Counsellor(Color color) {
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		this.color = color;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Counsellor [color=" + color + "]";
	}
	
	

}
