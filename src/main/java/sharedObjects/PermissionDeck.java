package sharedObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import bonusable.PermissionCard;

public class PermissionDeck {
	
	private LinkedList<PermissionCard> deck;
	private ArrayList<PermissionCard> visibleCards;

	public PermissionDeck(){
		this.deck=new LinkedList<PermissionCard>();
	}

	public void shuffleDeck(LinkedList<PermissionCard> deck){
		Collections.shuffle(deck);
	}
	
	public PermissionCard drawCard(ArrayList<PermissionCard> visibleCards, int index){
		return visibleCards.get(index);
	}
	
	/**
	 * @return the deck
	 */
	public LinkedList<PermissionCard> getDeck() {
		return deck;
	}
	
	/**
	 * @return the visibleCards
	 */
	public ArrayList<PermissionCard> getVisibleCards() {
		return visibleCards;
	}
	
}
