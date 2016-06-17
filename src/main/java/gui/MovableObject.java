package gui;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MovableObject extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1811434164953481177L;
	private static final long DURATION_MUL = (long) 1E6;
	private static final int TIMER_DELAY = 10;
	private Point endPosition;
	private Point startPosition;
	private long startingTime;
	private long animationDuration;
	private boolean animating;
	
	public boolean isAnimating() {
		return animating; 
	}
	
	public void moveTo(Point destination, int timeMillisec) {
		startingTime = System.nanoTime();
		animationDuration = (long) (timeMillisec*DURATION_MUL);
		startPosition = getBounds().getLocation();
		this.endPosition = destination;
		animating = true;
		performAnimation();
	}
	
	private void performAnimation() {
		
		//We want to write a block of code to call
		//repeatedly by the timer each 10ms
		ActionListener animationTask = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				//get the current time in nanoseconds
				long now = System.nanoTime();
				//progress is a number between 0 and 1 represents the progress of the animation
				//according to the passed time from the start of the animation
				double progress =  now > (startingTime + animationDuration) ?
						1 : (double)(now - startingTime) / (double)animationDuration ;

				if(now < startingTime) {
					progress = 0;
				}

				//Apply to the progress a function, chose one of the following! 
				
				//Linear, nothing change
				//progress = progress;
				
				//Concave function. Motion is fast, then slow
				//progress = Math.sqrt(progress,20);
				
				//Convex function. Motion is slow, then fast
				//progress = Math.pow(progress,20);

				//Compute the new position using a simple proportion 
				double newX = startPosition.x + (endPosition.x - startPosition.x)*progress;
				double newY = startPosition.y + (endPosition.y - startPosition.y)*progress;


				Point newPosition = new Point((int)newX,(int)newY);

				//check whether the animation must end
				if(progress == 1) {
					((Timer)evt.getSource()).stop();
					animating = false;
				}

				//Set the current location
				MovableObject.this.setLocation(newPosition);
			}
		};

		//Set up a timer that fire each 10ms, calling 
		//the method declare in the animationTask
		Timer timer = new Timer(TIMER_DELAY,animationTask);
		timer.start();
	}

}
