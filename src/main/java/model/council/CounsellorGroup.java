/**
 * 
 */
package model.council;

import utilities.Color;

/**
 * @author Riccardo Pressiani
 *
 */
public class CounsellorGroup {
	
	private Color color;
	private Integer counter;
	
	/**
	 * @param color
	 * @param counter
	 * @throws NullPointerException is color is null
	 * @throws IllegalArgumentException if counter<=0
	 */
	public CounsellorGroup(Color color, Integer counter){
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		if(counter<=0) {
			throw new IllegalArgumentException("counter must be greater than zero"); 
		}
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CounsellorGroup [color=" + color + ", counter=" + counter + "]";
	}
	
	


}
