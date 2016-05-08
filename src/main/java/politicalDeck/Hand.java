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


	public void clear() {
		for(int i=1; i<=numCards; i++) {
			 
		}
	}
	public void addCard(PoliticalCard c) {
        
    }
	public void removeCard(int position) {
		
	}
	
	/*public boolean isDeckEmpty(PoliticalDeck deck) {
		for(int i=1; i<=deck.numCards; i++) {
			
		}
	}*/	

}
