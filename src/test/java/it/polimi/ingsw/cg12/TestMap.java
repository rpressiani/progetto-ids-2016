package it.polimi.ingsw.cg12;

import static org.junit.Assert.*;

import org.junit.Test;

import model.council.GarbageState;
import model.map.City;
import model.map.Map;
import parser.Parser;

public class TestMap {

	@Test
	public void testNullMapThrowsException() {
		boolean thrown = false; 
		Parser parser = null; 
		Parser parser2 = new Parser(); 
		GarbageState garbage = new GarbageState(parser2);
		try {
			Map map = new Map(parser, garbage); 
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
			Map map = new Map(parser, garbage); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
}
