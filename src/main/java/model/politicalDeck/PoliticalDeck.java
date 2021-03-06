package model.politicalDeck;

import java.util.ArrayList;

import parser.Parser;
 
public abstract class PoliticalDeck {

	private ArrayList<PoliticalCard> deck; 
	private final int numColors;	//numColors doesn't include jolly
	private static Parser parser;

	/**
	 * @param parser
	 * @throws NullPointerException if parser is null
	 */
	public PoliticalDeck(Parser parser) {
		if(parser==null) {
			throw new NullPointerException("cannot have a null parser"); 
		}
		deck = new ArrayList<PoliticalCard>(); 
		this.numColors = parser.getCFGPoliticalDeck().getNumColors().intValue();
		PoliticalDeck.parser = parser;
	}

	/**
	 * @return true if political deck is empty --> need refill
	 * @throws NullPointerException if political deck(this) is null
	 */
	public boolean isEmpty() {
		if(this.getDeck()==null) {
			throw new NullPointerException("deck should not be null"); 
		}
		for(int i=0; i<deck.size(); i++) {
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

	/**
	 * @return the parser
	 */
	public static Parser getParser() {
		return parser;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PoliticalDeck [deck=" + deck + "]";
	}
}