package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.politicalDeck.PoliticalGarbage;
import model.politicalDeck.PoliticalRealDeck;
import parser.Parser;

public class TestPoliticalRealDeck {

	@Test
	public void testIfEmptyDeckReturnsTrue() {
		Parser parser = new Parser(); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage); 
		for(int i=0; i<deck.getDeck().size(); i++) {
			deck.getDeck().get(i).setNumCards(0);
		}
		assertTrue(deck.isEmpty()); 
	}
	@Test
	public void testIfNullDeckThrowsException() {
		boolean thrown = false; 
		try {
			PoliticalRealDeck deck = null;
			deck.refill();
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
