package gui;

import java.awt.Point;
import java.io.IOException;

import javax.swing.ImageIcon;

import utilities.Color;

public class Pedina extends SelectableObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1714029226348912713L;
	// private Color color; 
	private ImageIcon pedina; 
	
	public Pedina() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void moveTo(Point destination, int timeMillisec) {
		//call to the super method
		super.moveTo(destination, timeMillisec);

		//Set the right image according to the  
		//selected direction by cheking the 
		//difference between starting position
		//and target position
		int delta_x = destination.x - getX();
		int delta_y = destination.y - getY();

		if(Math.abs(delta_x) > Math.abs(delta_y)) {
			if(delta_x > 0) {
				//still have to edit the images
				//setIcon();	
			} else {
				//setIcon();	
			}
		} else {
			if(delta_y > 0) {
				//setIcon();	
			} else {
				//setIcon();	
			}
		}


	}
	

}
