package politicalDeck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class PoliticalRealDeck extends PoliticalDeck {
	private PoliticalRealDeck realDeck; 
	public PoliticalRealDeck() { //parser
		
	}
	public void refill(PoliticalGarbage garbageDeck) {
		if(!garbageDeck.isEmpty() && realDeck.isEmpty()) {
			int numGarbage = garbageDeck.getNumColors();  
			for(int i=0; i<numGarbage; i++) {
				// c is the index of each color of the garbage deck
				int c = garbageDeck.getDeck().get(i).getNumCards(); 
				realDeck.getDeck().get(i).addCards(c);
			}
		}
		garbageDeck.toZero();
	}
	
	
}
