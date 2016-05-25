package model.politicalDeck;

import java.util.Iterator;

import jaxb.CFGPoliticalCard;
import parser.Parser;

public class PoliticalGarbage extends PoliticalDeck {
	
	public PoliticalGarbage(Parser parser) {
		super(parser);
		for (Iterator<CFGPoliticalCard> iterator = parser.getCFGPoliticalDeck().getPoliticalCard().iterator(); iterator.hasNext();) {
			CFGPoliticalCard cfgPoliticalCard = iterator.next();
			this.getDeck().add(new PoliticalCard(cfgPoliticalCard.getColor(), 0));
		}
	}
	/**
	 * sets all numCards parameters of deck to zero
	 * useful for refill
	 * @throws NullPointerException is garbage deck is null
	 */
	public void toZero() {
		if(this.getDeck()==null) {
			throw new NullPointerException("deck should not be null"); 
		}
		for(int i=0; i<this.getNumColors(); i++) {
			//gives numCards for each index
			this.getDeck().get(i).setNumCards(0); 
		}
	}
}	

