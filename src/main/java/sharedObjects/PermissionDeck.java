package sharedObjects;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import bonusable.PermissionCard;

public class PermissionDeck {
	
	private Queue<PermissionCard> deck;
	
	public PermissionDeck(){
		this.deck=new LinkedList<PermissionCard>();
	}

	public void shuffleDeck(LinkedList<PermissionCard> deck){
		Collections.shuffle(deck);
	}
	
	/**
	 * @return the deck
	 */
	public Queue<PermissionCard> getDeck() {
		return deck;
	}
	
	
}
