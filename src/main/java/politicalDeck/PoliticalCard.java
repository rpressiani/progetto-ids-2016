package politicalDeck;


public class PoliticalCard {
	
	private final String color;
	private int numCards;
	
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
	 * removes a card
	 */
	public void removeCards(int c) {
		this.numCards-=c; 
	}
	

}
