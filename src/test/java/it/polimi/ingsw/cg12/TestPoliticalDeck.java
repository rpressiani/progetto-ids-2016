package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.politicalDeck.PoliticalCard;
import model.politicalDeck.PoliticalDeck;
import parser.Parser;

public class TestPoliticalDeck {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		try {
			Parser parser = null; 
			PoliticalDeck deck = new PoliticalDeck(parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIsEmptyWithNullDeckThrowsException() {
		boolean thrown = false; 
		PoliticalDeck deck = null; 
		try {
			deck.isEmpty(); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfGetParserWorks() {
		Parser parser = new Parser(); 
		PoliticalDeck deck = new PoliticalDeck(parser); 
		assertTrue(PoliticalDeck.getParser()==parser); 
	}
	@Test
	public void testIfGetNumColorsWorks() {
		Parser parser = new Parser(); 
		PoliticalDeck deck = new PoliticalDeck(parser); 
		int temp = deck.getNumColors(); 
		assertTrue(deck.getNumColors()==temp);
	}
	@Test
	public void testIfGetDeckWorks() {
		Parser parser = new Parser(); 
		PoliticalDeck deck = new PoliticalDeck(parser); 
		ArrayList<PoliticalCard> temp = deck.getDeck(); 
		assertTrue(deck.getDeck()==temp); 
	}
}