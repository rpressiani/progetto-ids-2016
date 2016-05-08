package politicalDeck;
import java.util.ArrayList;
import java.util.Random; 

public class Hand extends PoliticalDeck {
	private ArrayList<PoliticalCard> hand; 
	private int numCards;
	PoliticalDeck deck; 
	
	public Hand() {
		hand = new ArrayList<PoliticalCard>();
		
	}

	public PoliticalCard getCard(int position) { //guardare Javadoc
        hand.get(position);
    }
	public void clear() {
		for(int i=1; i<=numCards; i++) {
			 
		}
	}
	public void addCard(PoliticalCard c) {
        
    }
	public void removeCard(int position) {
		
	}
	
	public boolean isDeckEmpty(PoliticalDeck deck) {
		for(int i=1; i<=deck.numCards; i++) {
			
		}
	}
	public void sortByColor() { // Look for "Comparator"
       /* ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            PoliticalCard c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if ( c1.getColor() < c.getColor() ||
                        (c1.getColor() == c.getColor())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand; */
    }
		
	
	

}
