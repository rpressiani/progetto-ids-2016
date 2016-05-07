package politicalDeck;
import java.util.ArrayList; 

public class Hand extends PoliticalDeck {
	private ArrayList<PoliticalCard> hand; 
	
	public Hand() {
		hand = new ArrayList<PoliticalCard>();
		
	}
	public void pickRandomCard(PoliticalDeck deck) {
		
	}
	/*public PoliticalCard getCard(int position) { //guardare Javadoc
        hand.get(position);
    }*/			//messo tra commenti per togliere errore di compilazione
	public void clear() {
		hand.clear();
	}
	public void addCard(PoliticalCard c) {
        if (c == null)
            throw new NullPointerException("Can't add a null card to a hand.");
        hand.add(c);
    }
	public void removeCard(PoliticalCard c) {
		hand.remove(c); 
	}
	public void removeCard(int position) {
		if (position < 0 || position >= hand.size())
			throw new IllegalArgumentException("Position does not exist in hand: " + position);
	        hand.remove(position);
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
