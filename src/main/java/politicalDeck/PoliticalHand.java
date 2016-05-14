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
		
		for (int i = 0; i < PoliticalHand.getParser().getCFGRoot().getPlayers().getNInitPoliticalCards().intValue(); i++) {
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
	 * Discard a card from the hand and put it in the garbage deck
	 * 
	 * @param garbageDeck				the garbage deck that collects the discarded cards
	 * @param index						the index of the card color the player want to discard
	 * 
	 * @throws IllegalAccessException	throws an exception if the player tries to discard a card he doesn't have
	 */
	public void discardCard(PoliticalGarbage garbageDeck, int index) throws IllegalAccessException {
		if (this.getDeck().get(index).getNumCards() == 0) throw new IllegalAccessException("Cannot discard a card if you don't have it");
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
