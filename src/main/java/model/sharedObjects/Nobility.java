package model.sharedObjects;

import java.util.ArrayList;
import java.util.Iterator;

import model.GameState;
import model.bonusable.NobilityBox;
import model.player.Player;

public class Nobility {
	
	private ArrayList<NobilityBox> boxes;
	
	public Nobility(){
		boxes=new ArrayList<NobilityBox>();
	}
	
	public void checkNobility(Player player, GameState gameState){
		Iterator<NobilityBox> itr=boxes.iterator();
		while(itr.hasNext()){
			if(itr.next().getLevel()==player.getNobilityLevel().getItems().intValue())
			{
				itr.next().assignBonuses(player, gameState);
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

