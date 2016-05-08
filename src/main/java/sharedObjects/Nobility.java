package sharedObjects;

import java.util.ArrayList;
import bonusable.NobilityBox;

public class Nobility {
	
	private ArrayList<NobilityBox> boxes;
	
	public Nobility(){
		boxes=new ArrayList<NobilityBox>();
	}

	/**
	 * @return the boxes
	 */
	public ArrayList<NobilityBox> getBoxes() {
		return boxes;
	}
	
}

