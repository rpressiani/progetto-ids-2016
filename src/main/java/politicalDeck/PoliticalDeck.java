package politicalDeck;

import java.util.ArrayList;
 
public class PoliticalDeck {

	private ArrayList<PoliticalCard> deck; 
	private final int numColors; //for parser
	//private final String[] colors = {"Orange", "Pink", "Black", "Grey", "White", "Blue", "Jolly"};
	//private final ArrayList<PoliticalCard> cards; 

	public PoliticalDeck() {
		deck = new ArrayList<PoliticalCard>(); 
		this.numColors = 1;
		/*for(int i=1; i<=7; i++) {
			if(i==1) {
				deck[i] = new PoliticalCard("Orange", 13); 
			}
			if(i==2) {
				deck[i] = new PoliticalCard("Pink", 13); 
			}
			if(i==3) {
				deck[i] = new PoliticalCard("Black", 13);
			}
			if(i==4) {
				deck[i] = new PoliticalCard("Grey", 13);
			}
			if(i==5) {
				deck[i] = new PoliticalCard("White", 13);
			}
			if(i==6) {
				deck[i] = new PoliticalCard("Blue", 13);
			}
			if(i==7) {
				deck[i] = new PoliticalCard("Jolly", 12);
			}
		}			*/
		
	}

	/**
	 * @return true if political deck is empty --> need refill
	 */
	public boolean isEmpty() {
		for(int i=0; i<numColors; i++) {
			if(deck.get(i).getNumCards()!=0)
				return false; 
		}
		return true; 
	}
	
	/**
	 * @return the deck
	 */
	public ArrayList<PoliticalCard> getDeck() {
		return deck; 
	}

	
	/**
	 * @return number of colors
	 */
	public int getNumColors() {
		return numColors; 
	}
}