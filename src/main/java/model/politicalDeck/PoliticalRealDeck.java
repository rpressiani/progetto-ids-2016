package model.politicalDeck;

import java.util.Iterator;

import jaxb.CFGPoliticalCard;
import parser.Parser;

public class PoliticalRealDeck extends PoliticalDeck {
	
	private PoliticalGarbage garbage;
	
	public PoliticalRealDeck(Parser parser, PoliticalGarbage garbage) {
		super(parser);
		this.garbage = garbage;
		for (Iterator<CFGPoliticalCard> iterator = parser.getCFGPoliticalDeck().getPoliticalCard().iterator(); iterator.hasNext();) {
			CFGPoliticalCard cfgPoliticalCard = iterator.next();
			this.getDeck().add(new PoliticalCard(cfgPoliticalCard.getColor(), cfgPoliticalCard.getQuantity().intValue()));
		}
		
	}
	/**
	 * @param garbageDeck
	 * it fills the political deck with garbage deck when the main deck is empty
	 * @throws NullPointerException if deck is null
	 */
	public void refill() {
		if(this.getDeck()==null) {
			throw new NullPointerException("deck should not be null"); 
		}
		if(!this.garbage.isEmpty() && this.getDeck().isEmpty()) {
			int numGarbage = this.garbage.getNumColors();  
			for(int i=0; i<numGarbage; i++) {
				// c is the index of each color of the garbage deck
				int c = this.garbage.getDeck().get(i).getNumCards(); 
				this.getDeck().get(i).addCards(c);
			}
		}
		this.garbage.toZero();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PoliticalRealDeck [toString()=" + super.toString() + "]";
	}
	
}
