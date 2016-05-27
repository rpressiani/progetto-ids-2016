package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.politicalDeck.PoliticalGarbage;
import parser.Parser;

public class TestPoliticalGarbage {

	@Test
	public void testNullParserInConstructorThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		try {
			PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfToZeroPutsGarbageToZero() {
		Parser parser = new Parser(); 
		PoliticalGarbage garbage = new PoliticalGarbage(parser); 
		garbage.toZero();
		assertTrue(garbage.isEmpty()); 
	}
	@Test 
	public void testIfNullDeckThrowsException() {
		boolean thrown = false; 
		PoliticalGarbage garbage = null; 
		try {
			garbage.toZero(); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
