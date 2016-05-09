package sharedObjects;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;
import bonusable.PermissionCard;

public class PermissionDeck {
	
	private final int capacity=45; //read by parser
	private LinkedBlockingQueue<PermissionCard> deck;

	public PermissionDeck(){
		this.deck=new LinkedBlockingQueue<PermissionCard>(capacity);
	}
	
	public void shuffleDeck(){
		//Collection.shuffle()
	}
	/**
	 * @return the deck
	 */
	public LinkedBlockingQueue<PermissionCard> getDeck() {
		return deck;
	}
}
