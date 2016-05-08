package politicalDeck;


public class PoliticalCard {
	
	private final String color;
	protected final int numCards;
	
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
	public int getCardsForColor(PoliticalDeck deck, int i) {
		if(i<=0 || i<=8) {
			throw new IllegalArgumentException("We have only 7 colors");
		}
		//return deck[i].numCards; ? 
	}
	public int getCardsForColor(PoliticalDeck deck, String color) {
		
	}

}
