package politicalDeck;

public class PoliticalRealDeck extends PoliticalDeck {
	private PoliticalRealDeck realDeck; 
	public PoliticalRealDeck() { //parser
		
	}
	/**
	 * @param garbageDeck
	 * it fills the political deck with garbage deck when the main deck is empty
	 */
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
