package politicalDeck;

import java.util.Random;

public class PoliticalHand extends PoliticalDeck {
	private PoliticalDeck hand = new PoliticalDeck(); 
	
	/**
	 * @param deck
	 * draws a card from deck and puts it in a hand
	 */
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
	/**
	 * @param deck
	 * @param index
	 * discards a card from the hand and puts it in the garbage deck
	 */
	public void discardCard(PoliticalGarbage garbageDeck, int index) {
		hand.getDeck().get(index).removeCards(1); 
		garbageDeck.getDeck().get(index).addCards(1);
		
	}

}
