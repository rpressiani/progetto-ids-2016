package model.politicalDeck;


/**
 * @author Alessandro Pezzotta
 *
 */
public class PoliticalCard {
	
	private final String color;
	private int numCards;
	
	/**
	 * @param color can't be null
	 * @param numCards number of cards for each color
	 * @throws IllegalArgumentException if numCards<0
	 * @throws IllegalArgumentException if String==null
	 * constructor
	 */
	public PoliticalCard(String color, int numCards) {
		if(numCards<0) {
			throw new IllegalArgumentException("numCards cannot be less than zero"); 
		}
		if(color==null) {
			throw new IllegalArgumentException("color can't be null"); 
		}
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
	 * @param c numbers of cards to set for Card object
	 */
	public void setNumCards(int c) {
		if(c<=0) {
			throw new IllegalArgumentException("c must be >0"); 
		}
		this.numCards = c; 
	}
	/**
	 * @param c 
	 * adds c card
	 */
	public void addCards(int c) {
		if(c<=0) {
			throw new IllegalArgumentException("c must be greater than 0"); 
		}
		this.numCards+=c; 
	}
	/**
	 * @param c
	 * removes c card
	 */
	public void removeCards(int c) {
		if(c<=0) {
			throw new IllegalArgumentException("c must be greater than 0"); 
		}
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
