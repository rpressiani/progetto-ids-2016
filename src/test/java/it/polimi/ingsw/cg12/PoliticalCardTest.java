package it.polimi.ingsw.cg12;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.politicalDeck.PoliticalCard;

public class PoliticalCardTest extends TestCase {

	private PoliticalCard card; 
	@Before
	public void setUp() throws Exception {
	}
	@Test 
	public void isAddCardsMethodOkTest() {
		card = new PoliticalCard("Red", 8); 
		card.addCards(4);
		assertTrue(card.getNumCards()==12); 
		
	}
	
	

}
