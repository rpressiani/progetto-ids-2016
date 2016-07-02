package model.politicalDeck;

import java.util.Iterator;

import jaxb.CFGPoliticalCard;
import parser.Parser;

public class PoliticalGarbage extends PoliticalDeck {
	
	/**
	 * @param parser
	 */
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
		for(int i=0; i<this.getDeck().size(); i++) {
			//gives numCards for each index
			this.getDeck().get(i).setNumCards(0); 
		}
	}
	
	/**
	 * @param proposal
	 * adds cards to market proposal
	 */
	public void add(PoliticalContainer proposal) {
		if(proposal==null) throw new NullPointerException("proposal can't be null");
		
		for(int i=0; i<proposal.getDeck().size(); i++){
			this.getDeck().get(i).addCards(proposal.getDeck().get(i).getNumCards());
		}
	}
}	

