package politicalDeck;
import java.awt.Color; 
import java.util.Random; 

public class PoliticalDeck {
	private static final int MAX_SIZE = 78; 
	private static final int nColor = 6; 
	private static final int nCards = 13; 
	private static final int nJolly = 12; //li trascuro un attimo
	private int cardsUsed; 
	private final String[] colors = {"Orange", "Pink", "Black", "Grey", "White", "Blue", "Jolly"};
	//private final ArrayList<PoliticalCard> cards; 
	
	/*public PoliticalDeck() {
		cards = new ArrayList<PoliticalCard>();
		for(int i=1; i<=nColor; i++) { //Builds 13 cards per color
			for(int j=1; j<=nCards; j++) {
				if(i==1)
					cards.add(new PoliticalCard(new Color(0,0,0)));
				if(i==2)
					cards.add(new PoliticalCard(new Color()));
				if(i==3)
					cards.add(new PoliticalCard(new Color()));
				if(i==4)
					cards.add(new PoliticalCard(new Color()));
				if(i==5)
					cards.add(new PoliticalCard(new Color()));
				if(i==6)
					cards.add(new PoliticalCard(new Color()));
			}
		}
		
	}*/
	
	/*public void shuffle(PoliticalDeck deck) {
		for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            PoliticalCard temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
	} 
	*/
	public void dealCards() {
		
	}

}
