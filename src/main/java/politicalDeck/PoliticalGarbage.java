package politicalDeck;

import java.util.Iterator;

public class PoliticalGarbage extends PoliticalDeck {
	private PoliticalDeck garbage = new PoliticalDeck(); 
	private PoliticalDeck politicalDeck;  //points to the "real" political deck
	private int numColors; 
	//the one generated by Model
	public PoliticalGarbage() {
		
	}
	//puts garbage deck indexes to zero. Helpful for "refill" method
	public void toZero() {
		for(int i=0; i<numColors; i++) {
			//gives numCards for each index
			garbage.getDeck().get(i).setNumCards(0); 
		}
	}
}	
