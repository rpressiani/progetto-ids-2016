/**
 * 
 */
package council;

import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class CounsellorGroup {
	
	private Color color;
	private Integer counter;
	
	public CounsellorGroup(Color color, Integer counter){
		this.color = color;
		this.counter = counter;
	}
	
	public void add(){
		this.counter++;
	}
	
	public void remove(){
		this.counter--;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	
	/**
	 * @return the counter
	 */
	public Integer getCounter() {
		return counter;
	}
	
	


}
