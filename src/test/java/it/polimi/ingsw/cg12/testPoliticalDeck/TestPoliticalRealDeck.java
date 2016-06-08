package it.polimi.ingsw.cg12.testPoliticalDeck;

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
	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		Parser parser2 = new Parser(); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser2);
		try {
			PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGarbageIsEmptyAfterRefill() {
		Parser parser = new Parser(); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage);
		for(int i=0; i<deck.getDeck().size(); i++) {
			int counter = deck.getDeck().get(i).getNumCards(); 
			while(counter!=0) {
				deck.getDeck().get(i).removeCards(1);
				garbage.getDeck().get(i).addCards(1);
				counter--; 
			}
		}
		deck.refill();
		assertTrue(garbage.isEmpty()); 
	}
	
	public void testDeckIsNotEmptyAfterRefill() {
		Parser parser = new Parser(); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage);
		for(int i=0; i<deck.getDeck().size(); i++) {
			int counter = deck.getDeck().get(i).getNumCards(); 
			while(counter!=0) {
				deck.getDeck().get(i).removeCards(1);
				garbage.getDeck().get(i).addCards(1);
				counter--; 
			}
		}
		deck.refill();
		assertFalse(deck.isEmpty()); 
	}
	@Test
	public void testNullDeckInRefillThrowsException() {
		boolean thrown = false; 
		PoliticalRealDeck deck = null; 
		try {
			deck.refill();
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
