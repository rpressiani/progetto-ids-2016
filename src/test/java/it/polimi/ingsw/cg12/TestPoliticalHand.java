package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.politicalDeck.PoliticalGarbage;
import model.politicalDeck.PoliticalHand;
import model.politicalDeck.PoliticalRealDeck;
import parser.Parser;

public class TestPoliticalHand {

	@Test
	public void testNullHandInDrawCardThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage);
		PoliticalRealDeck deck2 = null; 
		PoliticalHand hand = new PoliticalHand(deck);
		try {
			hand.drawCard(deck2);
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testEmptyDeckInDrawCardThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser();
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage);
		PoliticalHand hand = new PoliticalHand(deck); 
		for(int i=0; i<deck.getDeck().size(); i++) {
			deck.getDeck().get(i).setNumCards(0);
		}
		try {
			hand.drawCard(deck);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testEmptyHandInDiscardCardThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage);
		PoliticalHand hand = new PoliticalHand(deck); 
		for(int i=0; i<hand.getDeck().size(); i++) {
			hand.getDeck().get(i).setNumCards(0);
		}
		try {
			hand.discardCard(garbage, 1);
		} catch(IllegalArgumentException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfDrawCardWorksAsExpected() {
		Parser parser = new Parser(); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		PoliticalRealDeck deck = new PoliticalRealDeck(parser, garbage); 
		PoliticalHand hand = new PoliticalHand(deck); 
		hand.drawCard(deck);
		assertTrue(!hand.getDeck().isEmpty()); 
	}

}
