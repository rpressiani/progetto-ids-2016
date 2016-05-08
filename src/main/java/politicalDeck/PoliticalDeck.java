package politicalDeck;

import java.util.ArrayList;
 
public class PoliticalDeck {

	private ArrayList<PoliticalCard> deck; 
	protected final int numColors; //for parser
	private final String[] colors = {"Orange", "Pink", "Black", "Grey", "White", "Blue", "Jolly"};
	//private final ArrayList<PoliticalCard> cards; 

	public PoliticalDeck() {
		deck = new ArrayList<PoliticalCard>(); 
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
	public ArrayList<PoliticalCard> getDeck() {
		return deck; 
	}

	
}