package sharedObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import bonusable.PermissionCard;

public class PermissionDeck {
	
	private LinkedList<PermissionCard> deck;
	private ArrayList<PermissionCard> visibleCards;
	private final int visibleLenght;

	public PermissionDeck(ArrayList<PermissionCard> cards/*Parser parser, File file*/){
		this.deck=new LinkedList<PermissionCard>();
		this.visibleCards=new ArrayList<PermissionCard>();
		this.visibleLenght=2; //read by parser

		Iterator<PermissionCard> itr= cards.iterator();
		while(itr.hasNext()){
			deck.add(itr.next());
		}
		
		shuffleDeck(deck);
		
		for(int i=0; i<visibleLenght; i++){
			visibleCards.add(deck.remove());
		}
	}

	public void shuffleDeck(LinkedList<PermissionCard> deck){
		Collections.shuffle(deck);
	}
	
	public PermissionCard drawCard(LinkedList<PermissionCard> deck, ArrayList<PermissionCard> visibleCards, int index){
		PermissionCard drawedCard=visibleCards.remove(index);
		visibleCards.add(index, deck.remove());
		return drawedCard;
	}
	
	public void substituteCards(LinkedList<PermissionCard> deck, ArrayList<PermissionCard> visibleCards){
		for(int i=0, temp=visibleLenght; i<temp; temp--){
			deck.add(visibleCards.remove(i));	//better with iterator?
		}
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
