package politicalDeck;

import java.util.Random;

public class PoliticalHand extends PoliticalDeck {
	private PoliticalDeck hand = new PoliticalDeck(); 
	
	public void drawCard(PoliticalRealDeck deck) {
		Random rnd;
		int temp;
		do {
			rnd = new Random(); 
			temp = rnd.nextInt(6);
		} while ( deck.getDeck().get(temp).getNumCards() == 0 );
		
		deck.getDeck().get(temp).removeCards(1);
		hand.getDeck().get(temp).addCards(1);
	}
	//given the index, it discards a card. No random needed here
	public void discardCard(PoliticalRealDeck deck, int index) {
		hand.getDeck().get(index).removeCards(1); 
		deck.getDeck().get(index).addCards(1);
		
	}

}
