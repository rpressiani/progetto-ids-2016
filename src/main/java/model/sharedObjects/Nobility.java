package model.sharedObjects;

import java.util.HashMap;

import jaxb.CFGNobilityBox;
import model.GameState;
import model.bonusable.NobilityBox;
import model.player.Player;
import parser.Parser;

public class Nobility {
	
	private HashMap<Integer,NobilityBox> boxes;
	
	public Nobility(Parser parser){
		this.boxes = new HashMap<Integer,NobilityBox>();
		
		for (CFGNobilityBox nobilityBox : parser.getCFGRoot().getNobility().getNobilityBox()) {
			NobilityBox tmp = new NobilityBox(
					parser.getBonusesFromParser(nobilityBox.getBonuses().getBonus()),
					nobilityBox.getLevel().intValue());
			this.boxes.put(tmp.getLevel(), tmp);
		}
	}
	
	public void checkNobility(Player player, GameState gameState){
		System.out.println(this.getBoxes().get(1));
		if (this.getBoxes().get(player.getNobilityLevel().getItems()) != null) {
			this.getBoxes().get(player.getNobilityLevel().getItems()).assignBonuses(player, gameState);
		}
	}

	/**
	 * @return the boxes
	 */
	public HashMap<Integer,NobilityBox> getBoxes() {
		return boxes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Nobility [boxes=" + boxes + "]";
	}
	
}

