package model.politicalDeck;


/**
 * @author Alessandro Pezzotta
 *
 */
public class PoliticalCard {
	
	private final String color;
	private int numCards;
	
	/**
	 * @param color
	 * @param numCards
	 * constructor
	 */
	public PoliticalCard(String color, int numCards) {
		this.color = color; 
		this.numCards = numCards; 
		
	}
	/**
	 * @return color of the card
	 */
	public String getColor() {
		return color; 
	}
	/**
	 * @return number of cards for color
	 */
	public int getNumCards() {
		return numCards; 
	}
	/**
	 * @param c
	 * assigns a numeric value to numCards
	 */
	public void setNumCards(int c) {
		this.numCards = c; 
	}
	/**
	 * @param c
	 * add c cards to numCards
	 */
	public void addCards(int c) {
		this.numCards+=c; 
	}
	/**
	 * @param c
	 * removes c card
	 */
	public void removeCards(int c) {
		this.numCards-=c; 
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PoliticalCard [color=" + color + ", numCards=" + numCards + "]";
	}
	

}
