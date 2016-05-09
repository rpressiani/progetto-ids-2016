package sharedObjects;

import java.util.ArrayList;
import java.util.Iterator;

import bonusable.NobilityBox;
import player.Player;

public class Nobility {
	
	private ArrayList<NobilityBox> boxes;
	
	public Nobility(){
		boxes=new ArrayList<NobilityBox>();
	}
	
	public void checkNobility(Player player){
		Iterator<NobilityBox> itr=boxes.iterator();
		while(itr.hasNext()){
			if(itr.next().getLevel()==player.getNobilityLevel().getItems().intValue())
			{
				itr.next().assignBonuses(player);
			}
		}
	}

	/**
	 * @return the boxes
	 */
	public ArrayList<NobilityBox> getBoxes() {
		return boxes;
	}
	
}

