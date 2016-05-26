package controller.changes;

import model.player.Player;
import model.politicalDeck.PoliticalHand;

public class HandChange extends Change {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3204768228185779770L;
	private PoliticalHand newHand; 
	private Player player; 
	
	public HandChange(PoliticalHand newHand) {
		this.newHand = newHand; 
	}
	public PoliticalHand getNewHand() {
		return newHand; 
	}
	@Override
	public String toString() {
		return "HandChange [newHand=" + newHand + ", player=" + player + "]";
	}
	

}
