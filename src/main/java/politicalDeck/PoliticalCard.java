package politicalDeck;


public class PoliticalCard {
	
	private final String color;
	private int numCards;
	
	public PoliticalCard(String color, int numCards) {
		this.color = color; 
		this.numCards = numCards; 
		
	}
	public String getColor() {
		return color; 
	}
	public int getNumCards() {
		return numCards; 
	}
	public void addCards() {
			this.numCards++; 
	}
	public void removeCards() {
		this.numCards--; 
	}
	

}
