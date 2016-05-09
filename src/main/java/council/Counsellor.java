/**
 * 
 */
package council;

import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class Counsellor {
	
	private Color color;
	
	public Counsellor(Color color){
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
