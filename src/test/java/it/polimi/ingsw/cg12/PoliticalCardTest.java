package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.politicalDeck.PoliticalCard;

public class PoliticalCardTest extends TestCase {

	private PoliticalCard card; 
	@Before
	public void setUp() throws Exception {
		card = new PoliticalCard("Red", 13); 
	}

	@Test
	public void isColorOk() {
		assertEquals(card.getColor()=="Red", true); 
	}

}
