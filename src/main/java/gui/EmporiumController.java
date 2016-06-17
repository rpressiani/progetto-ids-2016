package gui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class EmporiumController implements MouseListener{
	
	private ArrayList<Emporium> emporiums; 
	private Emporium selectedEmporium; 
	
	public EmporiumController(ArrayList<Emporium> emporiums) {
		this.emporiums = emporiums; 
		this.selectedEmporium = null; 
	}
	
	private void moveAction(MouseEvent e) {
		
		Emporium emporiumUnderTheMouse = null;
		
		//Find the pigeon where the mouse cursor is placed
		Point mousePosition = e.getPoint();
		for(Emporium emp : emporiums) {
			//Check if the mouse cursor is inside the 
			//a pigeon. I simply check if the position of
			//the mouse is inside the rectangular region
			//of the pigeon
			if(emp.getBounds().contains(mousePosition)){
				emporiumUnderTheMouse = emp;
				break;
			}
		}
		if(emporiumUnderTheMouse != null) {

			//Save the reference to the old selected pigeon
			Emporium oldSelectedEmporium = selectedEmporium;

			//save the reference to the pigeon that is below the mouse pointer
			//e.getSource() 
			selectedEmporium = emporiumUnderTheMouse;

			//the "select" method (from SelectableObject class)
			//shows a red circle around the image
 
			selectedEmporium.select(true);


			//deselect the old pigeon
			if(oldSelectedEmporium != null && oldSelectedEmporium != selectedEmporium) {
				oldSelectedEmporium.select(false);
			}
			
		} else {
			if(selectedEmporium != null) {

				int distance = (int) Math.sqrt(Math.pow(selectedEmporium.getX() - e.getPoint().getX(),2.0) +
						Math.pow(selectedEmporium.getY() - e.getPoint().getY(),2.0));


				selectedEmporium.moveTo(e.getPoint(), distance * 10);

			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
