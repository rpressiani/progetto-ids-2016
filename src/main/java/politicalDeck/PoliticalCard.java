package politicalDeck;
import java.awt.color.*;

public class PoliticalCard {
	
	private final Color color;
	private int numCards;
	
	public PoliticalCard(Color color, int numCards) {
		this.color = color; 
		this.numCards = numCards; 
		
	}
	public Color getColor() {
		return color; 
	}
	public int getNumCards() {
		return numCards; 
	}

}
