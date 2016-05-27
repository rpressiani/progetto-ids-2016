package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.council.Balcony;
import model.council.BalconyState;
import model.council.GarbageState;
import parser.Parser;
import utilities.Color;

public class TestBalcony {

	@Test
	public void testNullParserThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		Parser parser2 = new Parser(); 
		GarbageState garbage = new GarbageState(parser2); 
		try {
			Balcony balcony = new Balcony(garbage, parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullGarbageThrowsException() {
		boolean thrown = false; 
		Parser parser = new Parser(); 
		GarbageState garbage = null; 
		try {
			Balcony balcony = new Balcony(garbage, parser); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	

}
