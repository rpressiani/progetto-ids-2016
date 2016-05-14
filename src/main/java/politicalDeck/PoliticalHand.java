package politicalDeck;

import java.util.Iterator;
import java.util.Random;

import jaxb.CFGPoliticalCard;

public class PoliticalHand extends PoliticalDeck {
	
	public PoliticalHand(PoliticalRealDeck deck) {
		super(PoliticalHand.getParser());
		for (Iterator<CFGPoliticalCard> iterator = PoliticalDeck.getParser().getCFGPoliticalDeck().getPoliticalCard().iterator(); iterator.hasNext();) {
			CFGPoliticalCard cfgPoliticalCard = iterator.next();
			this.getDeck().add(new PoliticalCard(cfgPoliticalCard.getColor(), 0));
		}
		
		for (int i = 0; i < 6; i++) {
			this.drawCard(deck);
		}
	}
	
	/**
	 * @param deck
	 * draws a card from deck and puts it in a hand
	 */
	public void drawCard(PoliticalRealDeck deck) {
		Random rnd;
		int temp;
		do {
			rnd = new Random();
			temp = rnd.nextInt(this.getDeck().size());
		} while ( deck.getDeck().get(temp).getNumCards() == 0 );
		
		deck.getDeck().get(temp).removeCards(1);
		this.getDeck().get(temp).addCards(1);
		if (deck.isEmpty()) {
			deck.refill();
		}
	}
	/**
	 * @param deck
	 * @param index
	 * discards a card from the hand and puts it in the garbage deck
	 */
	public void discardCard(PoliticalGarbage garbageDeck, int index) {
		this.getDeck().get(index).removeCards(1); 
		garbageDeck.getDeck().get(index).addCards(1);
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PoliticalHand [toString()=" + super.toString() + "]";
	}

}
