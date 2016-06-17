package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class SelectableObject extends MovableObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1850725902416188310L;
	
	private Image selectedImage; 
	private boolean selected; 
	
	public SelectableObject() throws IOException {
		//still to implement
	}
	public void select(boolean s) {
		selected = s; 
	}
	@Override
	public void paint(Graphics g) {
		
		//we want to draw the red circle first
		if(selected)
			g.drawImage(selectedImage, 0, 0, 60, 60, null);
		
		//Then, let's draw the rest of the object
		super.paint(g);
		
	}

}
